package cn.wilmar.wcmdemo;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * 创建 by 殷国伟 于 2017/9/15.
 */
@Controller
public class UserController {
    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/user")
    public ModelAndView listUsers() {
        return new ModelAndView("user/userList",
                "users", repository.findAll());
    }





    /**
     * 创建用户的表单
     * @return 返回空用户
     */
    @GetMapping("/user/new")
    public ModelAndView newUserForm() {
        return new ModelAndView("user/userForm", "user", new User());
    }

    /**
     * 提交新建用户
     * @param user 用户对象
     * @return 返回用户查询界面Action
     */
    @PostMapping("/user/new")
    public String createUser(@Valid User user) {
        repository.save(user);
        return "redirect:/user";
    }

    /**
     * 打开编辑用户的表单
     * @param id 用户id
     * @return 返回要编辑的用户对象
     */
    @GetMapping("/user/{id}/edit")
    public ModelAndView editUserForm(@PathVariable("id") Long id) {
        return new ModelAndView("user/userForm", "user", repository.findOne(id));
    }

    /**
     * 保存编辑后的用户
     * @param id 用户id
     * @param user 用户对象
     * @return 返回用户查询界面Action
     */
    @PostMapping("/user/{id}/edit")
    public String updateUser(@PathVariable("id") Long id, @Valid User user) {
        User orgUser = repository.findOne(id);
        orgUser.setFullname(user.getFullname());
        orgUser.setUsername(user.getUsername());
        repository.save(orgUser);
        return "redirect:/user";
    }

    /**
     * 删除用户
     * @param id 用户id
     * @return 返回用户查询界面Action
     */
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id) {
        repository.delete(id);
        return "redirect:/user";
    }




}

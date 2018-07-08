package cn.wilmar.wcmdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 创建 by 殷国伟 于 2017/9/15.
 */
@Controller
public class HelloController {
    @GetMapping("/")
    public String hello() {
        return "index";
    }

    @GetMapping("/layout")
    public String layout() {
        return "layout";
    }
}

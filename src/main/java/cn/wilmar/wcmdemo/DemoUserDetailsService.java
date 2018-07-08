package cn.wilmar.wcmdemo;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * 创建 by 殷国伟 于 2017/9/15.
 */
@Component
public class DemoUserDetailsService implements UserDetailsService {
    private final UserRepository repository;

    public DemoUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        if (user == null ) {
            throw  new UsernameNotFoundException("用户找不到！" + username);
        }
        return new org.springframework.security.core.userdetails.User(
                username, user.getPassword(), new ArrayList<>()
        );
    }
}

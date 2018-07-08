package cn.wilmar.wcmdemo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 创建 by 殷国伟 于 2017/9/15.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);
}

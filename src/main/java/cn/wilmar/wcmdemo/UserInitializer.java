package cn.wilmar.wcmdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/**
 * 创建 by 殷国伟 于 2017/9/15.
 */
//@Component
public class UserInitializer implements CommandLineRunner {
    private  final  UserRepository repository;

    public UserInitializer(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Stream.of("Jon", "Socheer", "James", "Gary", "Aimee", "Will", "Jason")
                .forEach(name -> repository.save(new User(name.toLowerCase(), "f33ac49248dcf049181a4617db101e5a", name)));
        repository.findAll().forEach(System.out::println);
    }
}

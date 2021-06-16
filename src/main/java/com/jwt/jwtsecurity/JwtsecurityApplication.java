package com.jwt.jwtsecurity;

import com.jwt.jwtsecurity.model.User;
import com.jwt.jwtsecurity.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class JwtsecurityApplication {

    @Autowired
   private UserRepository userRepository;

    @PostConstruct
    public void initUsers(){
        List<User> users= Stream.of(
                new User(101,"nelson","pwd","nelson@gmail.com"),
                new User(102,"nelson1","pwd1","nelson1@gmail.com"),
                new User(103,"nelson2","pwd2","nelson2@gmail.com"),
                new User(104,"nelson3","pwd3","nelson3@gmail.com")
        ).collect(Collectors.toList());
        userRepository.saveAll(users);
        System.out.println("================USERS SAVED DONE=====================");
    }
    public static void main(String[] args) {
        SpringApplication.run(JwtsecurityApplication.class, args);
    }

}

package com.example.auth;

import com.example.auth.Controllers.UserController;
import com.example.auth.Entities.User;
import com.example.auth.Repositories.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

    @Bean
    CommandLineRunner start(UserRepo userRepo, UserController userController){
        return args -> {
            Stream.of("amine","ali","taha").forEach(name ->{
                User user = new User();
                user.setPrenom(name);
                user.setMail(name+"@gmail.com");
                user.setNom("ahmed");
                user.setMdp("1234");
                userRepo.save(user);
            });


        };
    }
}

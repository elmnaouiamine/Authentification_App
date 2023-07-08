package com.example.auth.Service;

import com.example.auth.Entities.User;
import com.example.auth.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User save(User user){
        return userRepo.saveAndFlush(user);
    }

    public User update(User user){
        return userRepo.save(user);
    }

    public Optional<User> find(String mail){
        return userRepo.findById(mail);
    }

    public boolean login(String mail, String pass){
        return userRepo.findByMailAndMdp(mail,pass).isPresent();
    }

}

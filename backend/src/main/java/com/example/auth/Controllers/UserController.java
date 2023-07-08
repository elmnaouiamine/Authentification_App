package com.example.auth.Controllers;

import com.example.auth.Entities.User;
import com.example.auth.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    public static final Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);

    @CrossOrigin
    @PostMapping("/login")
    public boolean login(@RequestBody User user){

        boolean b = userService.login(user.getMail(), user.getMdp());
        if(b){
            System.out.println("login success");
        }
        else{
            throw new RuntimeException("login failed");
        }
        return b;
    }


    @CrossOrigin
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User user){
        if(userService.find(user.getMail()).isPresent()){
            logger.error("mail deja existant "+user.getMail());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<User>(userService.save(user), HttpStatus.CREATED);
    }
}
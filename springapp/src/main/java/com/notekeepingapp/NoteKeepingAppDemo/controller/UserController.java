package com.notekeepingapp.NoteKeepingAppDemo.controller;

import com.notekeepingapp.NoteKeepingAppDemo.model.User;
import com.notekeepingapp.NoteKeepingAppDemo.DAO.UserRepository;
import com.notekeepingapp.NoteKeepingAppDemo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@SessionAttributes("name")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    LoginService loginService;

    @GetMapping("/all")
    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Boolean> saveUser(@Valid @RequestBody User user) {
        if (loginService.isUserRegistered(user)) {
            if (loginService.isValidCredentials(user))
                return new ResponseEntity<>(true, HttpStatus.OK);
            else
                return new ResponseEntity<>(false, HttpStatus.OK);
        }
        userRepository.save(user);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
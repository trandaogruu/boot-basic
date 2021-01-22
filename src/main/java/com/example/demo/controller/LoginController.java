package com.example.demo.controller;

import com.example.demo.model.in.AccountLogin;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@RestController

public class LoginController {

    @PostMapping(value = "/login")
    public ModelAndView login (@RequestBody AccountLogin login){
        return null;
    }

    @GetMapping(value = "/logout")
    public ModelAndView findById(){
        return null;
    }
}

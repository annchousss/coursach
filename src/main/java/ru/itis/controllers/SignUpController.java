package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.forms.SignUpForm;
import ru.itis.services.UsersService;

@Controller
public class SignUpController {
    @Autowired
    private UsersService usersService;

    @GetMapping(value = "/signUp")
    public String getSignUpPage() {
        return "signUp";
    }

    @PostMapping(value = "/signUp")
    public String signUp(SignUpForm signUpForm) {
        usersService.signUp(signUpForm);
        return "redirect:/signIn";
    }
}

package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.forms.SignInForm;
import ru.itis.forms.UserForm;
import ru.itis.services.UsersService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Controller
public class SignInController {
    @Autowired
    private UsersService usersService;

    @GetMapping(value = "/signIn")
    private String getSignInPage () {
        return "signIn";
    }

    @PostMapping(value = "/signIn")
    private String login(SignInForm signInForm, HttpServletResponse resp) throws IOException {
        UserForm userForm = usersService.signIn(signInForm);

        if (userForm != null) {
            Cookie auth = new Cookie("auth", userForm.getAuth());
            Cookie userId = new Cookie("userId", String.valueOf(userForm.getUserId()));
            resp.addCookie(auth);
            resp.addCookie(userId);
            return "redirect:/shop";
        } else {
            return "redirect:/signUp";
        }
    }
}

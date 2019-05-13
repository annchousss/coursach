package ru.itis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LogOutController {
    @RequestMapping(value = "/logOut", method = RequestMethod.GET)
    public String logOut(HttpServletRequest req, HttpServletResponse resp) {
        Cookie[] cookies = req.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            cookies[i].setMaxAge(0);
            resp.addCookie(cookies[i]);
        }
        return "redirect:/signIn";
    }


}

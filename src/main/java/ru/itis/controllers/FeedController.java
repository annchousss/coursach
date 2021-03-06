package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.models.Feedback;
import ru.itis.services.ProductService;

import java.util.List;

@Controller
public class FeedController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/feed", method = RequestMethod.GET)
    public String getFeedback(ModelMap modelMap) {
        List<Feedback> feed = productService.showFeedback();
        modelMap.addAttribute("feed", feed);
        return "index";
    }

    @GetMapping(value = "/cars-info")
    public String getCarsInfoPage() {
        return "cars-info";
    }



}

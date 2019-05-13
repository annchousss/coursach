package ru.itis.controllers;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itis.forms.FeedbackForm;
import ru.itis.models.Category;
import ru.itis.models.Customer;
import ru.itis.models.ProductName;
import ru.itis.services.OrderService;
import ru.itis.services.OrderService;
import ru.itis.services.ProductService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ShopController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    private Long currentUser(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("userId")) {
                return Long.valueOf(cookies[i].getValue());
            }
        }
        return null;
    }


    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public String showProducts(ModelMap modelMap) {
        List<ProductName> showProducts = productService.showProducts();
        modelMap.addAttribute("products", showProducts);
        return "choose-car";
    }


    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String showOrder(ModelMap modelMap) {
        return "order";
    }

    @RequestMapping(value = "/sendorder", method = RequestMethod.POST)
    //@ResponseBody
    public ResponseEntity<Object> sendOrder(HttpServletRequest req,
                                    @RequestParam(value = "productId") Long productId) {
        Long userId = currentUser(req);
        orderService.add(userId, productId);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/sendAddress", method = RequestMethod.POST)
    @ResponseBody
    public String sendAddress(HttpServletRequest req,
                             @RequestParam(value = "city") String city,
                             @RequestParam(value = "street") String street,
                             @RequestParam(value = "house") int house) {

        orderService.insertAddressId(orderService.insertAddress(city, street, house), currentUser(req));
        return "redirect:/order";
    }

    @RequestMapping(value = "/getOrder", method = RequestMethod.POST)
    @ResponseBody
    public List<ProductName> getOrder(HttpServletRequest req) {
        Long userId = currentUser(req);
        return orderService.getProduct(userId);
    }


    @RequestMapping(value = "/insertfeed", method = RequestMethod.POST)
    @ResponseBody
    public String getFeed(HttpServletRequest req,
                          @RequestParam(value = "your_fb") String yourFeed) {
        Long userId = currentUser(req);
        FeedbackForm form = FeedbackForm.builder()
                .customer_id(userId)
                .content(yourFeed)
                .build();
        productService.insertFeedback(form);
        return "redirect:/shop";
    }

    @RequestMapping(value = "/categories", method = RequestMethod.POST)
    @ResponseBody
    public List<Category> getCategories() {
        return productService.showCategories();
    }


    @RequestMapping(value = "/categoriesId", method = RequestMethod.POST)
    @ResponseBody
    public List<ProductName> showProducts(HttpServletRequest req) {
        return productService.showProductsByCatId(Long.valueOf(req.getParameter("categoryId")));
    }

    @RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> deleteOrder(HttpServletRequest req,
                                         @RequestParam(value = "productId") Long productId) {
        Long userId = currentUser(req);
        orderService.delete(userId, productId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/deleteAllProducts")
    public ResponseEntity<Object> deleteAllProducts(HttpServletRequest req){
        Long userId = currentUser(req);
        orderService.deleteAll(userId);
        return ResponseEntity.ok().build();
    }


}
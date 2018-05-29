package it.si2001.controller;


import it.si2001.model.User;
import it.si2001.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class HelloWorldController {

    private UserService Userservice;

    @Autowired
    public HelloWorldController(UserService userService){
        this.Userservice = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(ModelMap model){
        List<User> users = this.Userservice.findAllUsers();
        model.addAttribute("users",users);
        return "home"; }
}

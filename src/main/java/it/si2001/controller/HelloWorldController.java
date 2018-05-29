package it.si2001.controller;


import it.si2001.model.User;
import it.si2001.service.MaritalStatusService;
import it.si2001.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloWorldController {

    private UserService Userservice;
    private MaritalStatusService m;

    @Autowired
    public HelloWorldController(UserService userService, MaritalStatusService m){
        this.Userservice = userService; this.m=m;}

        @RequestMapping(method = RequestMethod.GET)
        public String home(ModelMap model){
        List<User> users = this.Userservice.findAllUsers();
        model.addAttribute("users",users);
        return "home"; }

        @RequestMapping(value = {"/create"}, method = RequestMethod.GET)
        public String create(ModelMap model){
        User user = new User();
        model.addAttribute("user",user);
        return "upinsert"; }

        @RequestMapping(method = RequestMethod.POST)
        public String saveRegistration(@Valid User user, BindingResult result, ModelMap model){

        if(result.hasErrors())
            return "upinsert";

        user.setStatus(this.m.findByName(user.getStatus().getStatus()));
        this.Userservice.save(user);
        model.addAttribute("success", "Dear " + user.getFirstname() + " your Registration completed successfully ");
        return "success"; }
}

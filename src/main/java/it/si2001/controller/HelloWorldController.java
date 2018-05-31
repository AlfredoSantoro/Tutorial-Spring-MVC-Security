package it.si2001.controller;


import it.si2001.model.MaritalStatus;
import it.si2001.model.Skills;
import it.si2001.model.User;
import it.si2001.service.MaritalStatusService;
import it.si2001.service.SkillService;
import it.si2001.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloWorldController {

        private UserService Userservice;
        private MaritalStatusService maritalStatusService;
        private SkillService skillService;

        @Autowired
        public HelloWorldController(UserService userService, MaritalStatusService maritalStatusService, SkillService skillService){
        this.Userservice = userService; this.maritalStatusService = maritalStatusService; this.skillService= skillService;}

        @RequestMapping(method = RequestMethod.GET)
        public String home(ModelMap model){
        List<User> users = this.Userservice.findAllUsers();
        model.addAttribute("users",users);
        return "home"; }

        @RequestMapping(value = {"/edit/{id}"},method = RequestMethod.GET)
        public String edit(@PathVariable int id, ModelMap modelMap){
        User user = this.Userservice.findById(id);
        if(user == null){
            modelMap.addAttribute("failure", "Dear " + user.getFirstname() + " User not found ");
            return "failure";
        }
        modelMap.addAttribute("user",user);
        return "upinsert"; }



        @RequestMapping(value = {"/delete/{id}"},method = RequestMethod.GET)
        public String delete(@PathVariable int id, ModelMap modelMap){

            User user = this.Userservice.findById(id);
            System.out.println(user.getLastname() + " " + user.getFirstname());
            if(user == null){
                modelMap.addAttribute("failure", "Dear " + user.getFirstname() + " User not found ");
                return "failure";
            }
            this.Userservice.delete(user);
            modelMap.addAttribute("success", "Dear " + user.getFirstname() + " Your account has been successfully deleted ");
            return "success"; }


        @RequestMapping(value = {"/create"}, method = RequestMethod.GET)
        public String create(ModelMap model){
        User user = new User();
        model.addAttribute("user",user);
        return "upinsert"; }

        @RequestMapping(method = RequestMethod.POST)
        public String saveRegistration(@Valid User user, BindingResult result, ModelMap model){

        if(result.hasErrors())
            return "upinsert";

        if(this.Userservice.findById(user.getId())!=null){
            this.Userservice.updateUser(user);
            model.addAttribute("success", "Dear " + user.getFirstname() + " your updates completed successfully ");
            return "success"; }
        this.Userservice.save(user);
        model.addAttribute("success", "Dear " + user.getFirstname() + " your Registration completed successfully ");
        return "success"; }

        @ModelAttribute("statusAttribute")
        public List<MaritalStatus> initializeMaritalStatus() {return maritalStatusService.findAllStatus(); }

        @ModelAttribute("skillsAttribute")
        public List<Skills> initializeSkills() {return skillService.findAll(); }
}

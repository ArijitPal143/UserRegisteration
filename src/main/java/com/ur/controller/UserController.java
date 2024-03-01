package com.ur.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ur.entity.UserEntity;
import com.ur.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    
    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") UserEntity user, Model model) {
    	try {
    		
            if (userService.isUserExists(user.getUsername())) {
                model.addAttribute("error", "Username already exists. Please choose a different username.");
                return "registration";
            }
            
            if (userService.isPhoneNumberExists(user.getPhoneNumber())) {
                model.addAttribute("error", "Phone number already exists. Please use a different phone number.");
                return "registration";
            }
            
            if (userService.isEmailExists(user.getEmail())) {
                model.addAttribute("error", "Email already exists. Please use a different email address.");
                return "registration";
            } 		
			userService.registerUser(user);
		    return "redirect:/registration-success";
		} catch (Exception e) {
		      model.addAttribute("error", "Registration failed. Please try again.");
		    return "registration";
		}
        
    } 
    
    
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("username") String username, 
                            @RequestParam("password") String password, 
                            Model model) {
        if (userService.authenticate(username, password)) {
            UserEntity user = userService.getUserByUsername(username);
            model.addAttribute("user", user);
            return "user-details"; 
        } else {
            model.addAttribute("error", "Invalid username or password. Please try again");
            return "login"; 
        }
    }

    
    @GetMapping("/registration-success")
    public String showRegistrationSuccessPage() {
        return "registration-success";
    }
    
    
    
    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
    
       HttpSession session = request.getSession(false);
    
    
         if (session != null) {
           session.invalidate();
         }
    
          return "redirect:/login";

    }
    
}








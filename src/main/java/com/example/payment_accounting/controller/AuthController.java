package com.example.payment_accounting.controller;

import com.example.payment_accounting.model.Payment;
import com.example.payment_accounting.model.User;
import com.example.payment_accounting.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/home")
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String logIn (HttpSession session, @ModelAttribute("user") User user){
        String username = (String)session.getAttribute("username");

        if (username == null){
            return "HomePage";
        } else {
            return "redirect:/invoice";
        }
    }
    @PostMapping("/verify")
    public String verify (HttpSession session, @ModelAttribute("user") User user) {
        boolean correct = authService.verifyUser(user, session);
        if (correct){
            return "redirect:/invoice";
        } else {
            return "redirect:/home";
        }
    }
    @PostMapping("/logout")
    public String logout (HttpSession session) {
        session.removeAttribute("username");
        return "redirect:/home";
    }
}

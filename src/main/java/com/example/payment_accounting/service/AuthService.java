package com.example.payment_accounting.service;

import com.example.payment_accounting.model.User;
import com.example.payment_accounting.repository.AuthRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class AuthService {
private AuthRepository authRepository;

    public AuthService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public boolean verifyUser(User user, HttpSession httpSession){
        User actualUser = authRepository.findAllByUsername(user);
        if (actualUser != null && actualUser.getPassword().equals(user.getPassword())){
            httpSession.setAttribute("username", user.getUsername());
            return true;
        }
        else {
            return false;
        }
    }
}

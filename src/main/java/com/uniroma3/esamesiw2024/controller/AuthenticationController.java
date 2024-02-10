package com.uniroma3.esamesiw2024.controller;


import com.uniroma3.esamesiw2024.entity.Credentials;
import com.uniroma3.esamesiw2024.entity.User;
import com.uniroma3.esamesiw2024.repository.UserRepository;
import com.uniroma3.esamesiw2024.service.CredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class AuthenticationController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CredentialsService credentialsService;

    @GetMapping(value = "/login")
    public String showLogin (Model model) {
        return "formLogin.html";
    }

    @GetMapping(value = "/")
    public String showIndex (Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            return "index.html";
        }
        else {
            UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
            if (credentials.getRole().equals(Credentials.ADMIN_ROLE)) {
                return "index.html";
            }
        }

        return "index.html";
    }

    @GetMapping(value = "/success")
    public String defaultAfterLogin(Model model) {
        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
        if (credentials.getRole().equals(Credentials.ADMIN_ROLE)) {
            model.addAttribute("role", "admin");
        } else if (credentials.getRole().equals(Credentials.PRESIDENTE_ROLE)) {
            model.addAttribute("role", "presidente");
        }
        return "index.html";
    }

    @GetMapping(value = "/register")
    public String showRegister(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("credentials", new Credentials());
        return "formRegisterUser.html";
    }

    @PostMapping(value = { "/register" })
    public String registerUser(@ModelAttribute("user") User user,
                               BindingResult userBindingResult,
                               @ModelAttribute("credentials") Credentials credentials,
                               BindingResult credentialsBindingResult,//
                               Model model) throws IOException {

        // se user e credential hanno entrambi contenuti validi, memorizza User e the Credentials nel DB
        if(!userBindingResult.hasErrors() && ! credentialsBindingResult.hasErrors()) {
            user = this.userRepository.save(user);
            credentials.setUser(user);
            credentialsService.saveCredentials(credentials);
            model.addAttribute("user", user);
            return "index.html";
        }
        return "formRegisterUser.html";
    }
}

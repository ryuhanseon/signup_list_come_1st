package com.example.demo.User;


import lombok.RequiredArgsConstructor;
import org.apache.catalina.Authenticator;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;


@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/signup")
    public String sign() {
        return "signup_form";
    }

    @PostMapping("/signup")
    public String sign(@RequestParam(value = "username") String username,
                       @RequestParam(value = "password") String password,
                       @RequestParam(value = "passwordConfirm") String passwordConfirm,
                       Model model) {

        if (!password.equals(passwordConfirm)) {
            model.addAttribute("error",
                    "비밀번호가 일치하지 않습니다.");
            return "signup_form";
        }
        try {
            this.userService.create(username, password);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e.getMessage());
            return "signup_form";
        }
        return "redirect:/question/list";
    }

    @GetMapping("/login")

    public String login() {
        return "login_form";
    }



    }



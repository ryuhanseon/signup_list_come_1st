package com.example.demo.User;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/signup")
    public String sign(){
        return "signup_form";
    }
    @PostMapping("/signup")
    public String sign(@RequestParam(value = "username")String username,
                       @RequestParam(value = "password")String password,
                       @RequestParam(value = "passwordConfirm")String passwordConfirm,
                       Model model) {

        if (!password.equals(passwordConfirm)) {
            model.addAttribute("error",
                    "비밀번호가 일치하지 않습니다.");
            return "signup_form";
        }

        this.userService.create(username, password);
        return "redirect:/question/list";
    }


}

package com.sshs.auth2.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequiredArgsConstructor
@RequestMapping("/signup")
public class SignupController {

    private final UserService userService;

    @GetMapping
    public String getSignup(Model model) {
        HashMap content = new HashMap<String, String>();
        content.put("title", "Signup Page");
        model.addAllAttributes(content);
        return "auth/signup";
    }

    @PostMapping
    public String signup(
        @ModelAttribute UserRegisterDto register
    ) {
        userService.signup(register.getUsername(), register.getPassword());
        // 회원가입 후 로그인 페이지로 이동
        return "redirect:/";
    }
}

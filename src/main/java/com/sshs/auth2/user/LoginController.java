package com.sshs.auth2.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String getLogin(Model model) {
        HashMap content = new HashMap<String, String>();
        content.put("title", "Login Page");
        model.addAllAttributes(content);
        return "auth/signin";
    }

}

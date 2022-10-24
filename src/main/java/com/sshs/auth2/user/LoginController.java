package com.sshs.auth2.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLogin(Model model) {
        HashMap content = new HashMap<String, String>();
        content.put("title", "Hello String");
        model.addAllAttributes(content);
        return "login/index";
    }

}

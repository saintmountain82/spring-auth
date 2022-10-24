package com.sshs.auth2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

/**
 * @author hanseongsan
 *
 * 인덱스 페이지 뷰어
 */
@Controller
public class IndexController {

    @GetMapping("/index.do")
    public String getIndex(Model model) {
        HashMap content = new HashMap<String, String>();
        content.put("title", "Hello String");
        model.addAllAttributes(content);
        return "index";
    }
}

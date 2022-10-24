package com.sshs.auth2.index;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

/**
 * @author hanseongsan
 *
 * 인덱스 페이지 뷰어
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String getIndex(Model model) {
        HashMap content = new HashMap<String, String>();
        content.put("title", "Hello String");
        model.addAllAttributes(content);
        return "index";
    }
}

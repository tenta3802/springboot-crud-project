package com.java.crud;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafTestController {

    @GetMapping(value = "/")
    public String test(Model model) {
        model.addAttribute("spring", "Thymeleaf 테스트 글입니다.");
        return "thymeleafTest";
    }
}

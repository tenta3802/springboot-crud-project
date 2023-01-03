package com.java.crud.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping(value = "/post/write.do")
    public String openPostWrite(Model model) {
//        String title = "제목";
//        String content = "내용";
//        String writer = "홍길동";
//
//        model.addAttribute("title", title);
//        model.addAttribute("content", content);
//        model.addAttribute("writer", writer);
        return "post/write";
    }
}

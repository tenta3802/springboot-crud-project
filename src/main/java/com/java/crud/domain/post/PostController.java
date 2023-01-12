package com.java.crud.domain.post;

import com.java.crud.common.dto.MessageDto;
import com.java.crud.common.dto.SearchDto;
import com.java.crud.paging.PagingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    //게시글 작성 페이지
    @GetMapping(value = "/post/write.do")
    public String openPostWrite(@RequestParam(value = "id", required = false)
                                final Long id, Model model) {
        if(id!=null) {
            PostResponse post = postService.findPostById(id);
            model.addAttribute("post", post);
        }
        return "post/write";
    }

    // 신규 게시글 생성
    @PostMapping(value = "/post/save.do")
    public String savePost(final PostRequest params, Model model) {
        postService.savePost(params);
        MessageDto message = new MessageDto("게시글 생성이 완료되었습니다." ,
                "/post/list.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    @GetMapping(value = "/post/list.do")
    public String openPostList(@ModelAttribute("params") final SearchDto params, Model model) {
        PagingResponse<PostResponse> response = postService.findAllPost(params);
        model.addAttribute("response", response);
        return "post/list";
    }

    @GetMapping(value = "/post/view.do")
    public String openPostView(@RequestParam final Long id, Model model) {
        PostResponse post = postService.findPostById(id);
        model.addAttribute("post", post);
        return "post/view";
    }

    @PostMapping(value = "/post/update.do")
    public String updatePost(final PostRequest params, Model model) {
        postService.updatePost(params);
        MessageDto message = new MessageDto("게시글 수정이 완료되었습니다." ,
                "/post/list.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    @PostMapping(value = "/post/delete.do")
    public String deletePost(@RequestParam final Long id, Model model) {
        postService.deletePost(id);
        MessageDto message = new MessageDto("게시글 삭제가 완료되었습니다." ,
                "/post/list.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    // 사용자에게 메시지를 전달하고 페이지를 리다이렉트 한다.
    private String showMessageAndRedirect(final MessageDto params, Model model){
        model.addAttribute("params", params);
        return "common/messageRedirect";
    }
}

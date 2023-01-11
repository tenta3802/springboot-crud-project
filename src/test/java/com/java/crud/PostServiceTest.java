package com.java.crud;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.java.crud.domain.post.PostRequest;
import com.java.crud.domain.post.PostResponse;
import com.java.crud.domain.post.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostServiceTest {

    @Autowired
    PostService postService;

    @Test
    void save() {
        PostRequest params = new PostRequest();
        params.setTitle("1번 게시글 제목");
        params.setContent("1번 게시글 내용");
        params.setWriter("테스터");
        params.setNoticeYn(false);
        Long id = postService.savePost(params);
        System.out.println("생성된 게시글 ID : " + id);
    }

    @Test
    void findById() {
        PostResponse postResponse = postService.findPostById(5L);
        try {
            String postJson = new ObjectMapper().registerModule(
                    new JavaTimeModule()).writeValueAsString(postResponse);
            System.out.println(postJson);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void update() {
        PostRequest params = new PostRequest();
        params.setId(6L);
        params.setTitle("1번 게시글 제목 수정");
        params.setContent("1번 게시글 내용 수정");
        params.setWriter("수정자");
        params.setNoticeYn(true);
        Long id = postService.updatePost(params);
        System.out.println("수정된 게시글 ID : " + id);
    }

//    @Test
//    void delete() {
//        System.out.println("삭제 전 게시글 수: " + postService.findAllPost().size());
//        postService.deletePost(3L);
//        System.out.println("삭제 후 게시글 수: " + postService.findAllPost().size());
//    }
}
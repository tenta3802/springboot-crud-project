package com.java.crud.domain.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequest {
// post 요청 클래스에서는 게시글을 작성할 때 입력 받아야할 목록을 작성

    private Long id; //pk
    private String title; //제목
    private String content; //내용
    private String writer; //작성자
    private Boolean noticeYn; //공지글 여부
}

package com.java.crud.domain.post;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponse {

    private Long id;
    private String title;
    private String content;
    private String writer;
    private int viewCnt;
    private boolean noticeYn;
    private boolean deleteYn;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}

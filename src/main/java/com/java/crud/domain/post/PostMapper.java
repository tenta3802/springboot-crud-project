package com.java.crud.domain.post;

public interface PostMapper {
    /**
     * 게시글 저장
     * @param params - 게시글 정보
     */
    void save(PostRequest params);

}

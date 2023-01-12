package com.java.crud.paging;

import com.java.crud.domain.post.PostResponse;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PagingResponse<T> {

    private List<T> list = new ArrayList<>();
    private Pagination pagination;

    public PagingResponse(List<T> list, Pagination pagination) {
        this.list = list;
        this. pagination = pagination;
    }
}

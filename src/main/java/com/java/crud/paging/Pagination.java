package com.java.crud.paging;

import com.java.crud.common.dto.SearchDto;
import lombok.Getter;

@Getter
public class Pagination {

    private int totalRecordCount;   //전체 데이터 수
    private int totalPageCount;     //전체 페이지 수
    private int startPage;          // 첫 페이지 번호
    private int endPage;            // 끝 페이지 번호
    private int limitStart;         // LIMIT 시작 위치
    private boolean existPrevPage;  // 이전 페이지 존재 여부
    private boolean existNextPage;  // 다음 페이지 존재 여부

    public Pagination(int totalRecordCount, SearchDto params) {
        if (totalRecordCount > 0) {
            this.totalRecordCount = totalRecordCount;

        }
    }

    private void calculation(SearchDto params) {

        // (전체 페이지 수 계산(총 데이터 수 - 1) / 페이지당 출력할 개수) + 1
        // -1을 하는 이유는 데이터가 100개면 페이지 10개가 필요한데 -1 안하면 11페이지 즉 빈 페이지가 생성된다.
        totalPageCount = ((totalRecordCount - 1) / params.getRecordSize()) + 1;

        // 현재 페이지 번호가 전체 페이지 수보다 큰 경우, 현재 페이지 번호에 전체 페이지 수 저장
        // 만약 현재 페이지가 11인데 전체 페이지가 10이다.그럼 현재 페이지를 전체 페이지와 동일하게 맞춰줘야한다.
        if (params.getPage() > totalPageCount) {
            params.setPage(totalPageCount);
        }

        // 첫 페이지 번호 계산
        // (현재페이지 - 1 / 화면 하단에 출력할 페이지 사이즈) * 화면 하단에 출력할 페이지 사이즈 + 1
        startPage = ((params.getPage() - 1) / params.getPageSize()) * params.getPageSize() + 1;

        // 끝 페이지 번호 계산
        endPage = startPage + params.getPageSize() - 1;

        // 끝 페이지가 전체 페이지 수보다 큰 경우, 끝 페이지 전체 페이지 수 저장
        if(endPage > totalPageCount) {
            endPage = totalPageCount;
        }

        // LIMIT 시작 위치 계산
        limitStart = (params.getPage() - 1) * params.getRecordSize();

        // 이전 페이지 존재 여부 확인
        // 만약 시작 페이지가 1이면 false 가 돼서 없다는 것으로 됨
        existPrevPage = startPage != 1;

        // 다음 페이지 존재 여부 확인
        existNextPage = (endPage * params.getRecordSize()) < totalRecordCount;
    }
}
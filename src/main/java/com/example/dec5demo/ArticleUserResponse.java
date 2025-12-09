package com.example.dec5demo;

import java.util.List;

// 对应整个 JSON 返回：page, total_pages, data
public class ArticleUserResponse {

    private int page;
    private int perPage;
    private int total;
    private int totalPages;
    private List<ArticleUser> data;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int total_pages) {
        this.totalPages = totalPages;
    }

    public List<ArticleUser> getData() {
        return data;
    }

    public void setData(List<ArticleUser> data) {
        this.data = data;
    }
}
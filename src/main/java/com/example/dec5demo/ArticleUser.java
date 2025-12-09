package com.example.dec5demo;

// 对应外部接口 data 数组里的每一个 user
public class ArticleUser {

    private int id;
    private String username;
    private String about;
    private int submission_count;
    private int comment_count;

    // getter / setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getSubmission_count() {
        return submission_count;
    }

    public void setSubmission_count(int submission_count) {
        this.submission_count = submission_count;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }
}


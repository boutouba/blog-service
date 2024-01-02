package com.blog.dto;

import lombok.Data;

@Data
public class PostRequest {

    private String title;
    private String content;
    private Long type;

    public PostRequest() {
    }

    public PostRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }


}

package com.blog.dto;

import com.blog.entity.Type;
import lombok.Data;

@Data
public class PostResponse {

    private String title;
    private String content;
    private Type type;

    public PostResponse() {
    }

    public PostResponse(String title, String content) {
        this.title = title;
        this.content = content;
    }

}

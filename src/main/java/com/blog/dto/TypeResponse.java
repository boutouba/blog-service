package com.blog.dto;

import lombok.Data;

@Data
public class TypeResponse {

    private String title;

    public TypeResponse() {
    }

    public TypeResponse(String title) {
        this.title = title;
    }

}

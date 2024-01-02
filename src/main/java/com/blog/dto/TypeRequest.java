package com.blog.dto;

import lombok.Data;

@Data
public class TypeRequest {

    private String title;

    public TypeRequest() {
    }

    public TypeRequest(String title) {
        this.title = title;
    }


}

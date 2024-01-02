package com.blog.service;

import com.blog.dto.PostRequest;
import com.blog.dto.TypeRequest;
import com.blog.entity.Post;
import com.blog.entity.Type;

import java.util.List;
import java.util.Optional;

public interface TypeService {

    public List<Type> getTypes();

    public Optional<Type> getType(Long id);

    public Type createType(TypeRequest type);

    public Type updateType(TypeRequest type, Long id) throws Exception;


    public Type deleteType(Long id) throws Exception;

}

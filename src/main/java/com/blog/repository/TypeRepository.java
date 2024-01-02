package com.blog.repository;

import com.blog.entity.Post;
import com.blog.entity.Type;
import com.fasterxml.jackson.databind.type.TypeParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
}

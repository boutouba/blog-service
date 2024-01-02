package com.blog.service.imp;

import com.blog.dto.PostRequest;
import com.blog.dto.TypeRequest;
import com.blog.entity.Post;
import com.blog.entity.Type;
import com.blog.repository.PostRepository;
import com.blog.repository.TypeRepository;
import com.blog.service.PostService;
import com.blog.service.TypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeServiceImpl implements TypeService {

    public TypeRepository typeRepository;

     public TypeServiceImpl(TypeRepository typeRepository) {
         this.typeRepository = typeRepository;
     }

    public List<Type> getTypes() {
        return typeRepository.findAll();
    }

    public Optional<Type> getType(Long id) {
         return typeRepository.findById(id);
    }

    public Type createType(TypeRequest type) {
         Type p = new Type();
         p.setTitle(type.getTitle());
         typeRepository.save(p);
         return p;
    }

    public Type updateType(TypeRequest type, Long id) throws Exception {
        Type p = typeRepository.findById(id).orElse(null);
        if (p == null) {
            throw new Exception("Post not found");
        }
        p.setTitle(type.getTitle());
        typeRepository.save(p);
        return p;
    }

    public Type deleteType(Long id) throws Exception {
        Type p = typeRepository.findById(id).orElse(null);
        if (p == null) {
            throw new Exception("Post not found");
        }
        typeRepository.delete(p);
        return p;
    }

}

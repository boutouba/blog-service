package com.blog.controller;


import com.blog.dto.PostRequest;
import com.blog.dto.TypeRequest;
import com.blog.entity.Post;
import com.blog.entity.Type;
import com.blog.service.PostService;
import com.blog.service.TypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TypeController {

    public TypeService typeService;
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @RequestMapping(path="/types", method = RequestMethod.GET)
    public ResponseEntity<List<Type>> getType() {
        return new ResponseEntity<>(typeService.getTypes(), HttpStatus.OK);
    }

    @RequestMapping(path="/type/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Type>> getPost(@PathVariable Long id) {
        return new ResponseEntity<>(typeService.getType(id), HttpStatus.OK);
    }

    @RequestMapping(path = "/type/add", method = RequestMethod.POST)
    public ResponseEntity<Type> createType(@RequestBody TypeRequest typeRequest) {
        Type type = typeService.createType(typeRequest);
        return new ResponseEntity<>(type, HttpStatus.OK);
    }

    @RequestMapping(path = "/type/edit/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Type> updateType(@RequestBody TypeRequest typeRequest, @PathVariable Long id) throws Exception {
        Type type = typeService.updateType(typeRequest, id);
        return new ResponseEntity<>(type, HttpStatus.OK);
    }

    @RequestMapping(path = "/type/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Type> updateType(@PathVariable Long id) throws Exception {
        Type type = typeService.deleteType(id);
        return new ResponseEntity<>(type, HttpStatus.OK);
    }
}

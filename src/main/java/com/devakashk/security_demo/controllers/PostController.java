package com.devakashk.security_demo.controllers;

import com.devakashk.security_demo.entities.Post;
import com.devakashk.security_demo.models.ResponseModel;
import com.devakashk.security_demo.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts")
public class PostController {


    @Autowired
    PostsRepository repository;

    @GetMapping("post")
    private List<Post> getAllPosts() {
        ResponseModel model = new ResponseModel("Success", repository.findAll());
        System.out.println(model);
        return repository.findAll();
    }

    @PostMapping("post")
    private ResponseEntity<?> createPost(@RequestBody Post post) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "Data success");
        return ResponseEntity.accepted().headers(headers).body(repository.save(post));
    }

}

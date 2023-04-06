package com.example.Lab1.controllers;

import com.example.Lab1.domain.dto.PostDto;
import com.example.Lab1.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PostDto> getAll(@RequestParam(value = "author", required = false) String author, @RequestHeader(value = "Api-Version", required = false) String apiVersion) {
        if("v2".equals(apiVersion)) {
            // do something else for V2
            System.out.println("VERSION 2");
            return author == null ? postService.findAll() : postService.findByAuthor(author);
        }
        return author == null ? postService.findAll() : postService.findByAuthor(author);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody PostDto p, @RequestHeader(value = "Api-Version", required = false) String apiVersion) {
        if("v2".equals(apiVersion)) {
            // do something else for V2
            System.out.println("VERSION 2");
            postService.save(p);
        }
        postService.save(p);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getById(@PathVariable int id, @RequestHeader(value = "Api-Version", required = false) String apiVersion) {
        if("v2".equals(apiVersion)) {
            // do something else for V2
            System.out.println("VERSION 2");
            var post = postService.getById(id);
            return ResponseEntity.ok(post);
        }
        var post = postService.getById(id);
        return ResponseEntity.ok(post);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "Api-Version", required = false) String apiVersion) {
        if("v2".equals(apiVersion)) {
            // do something else for V2
            System.out.println("VERSION 2");
            postService.delete(id);
        }
        postService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int postId, @RequestBody PostDto p, @RequestHeader(value = "Api-Version", required = false) String apiVersion) {
        if("v2".equals(apiVersion)) {
            // do something else for V2
            System.out.println("VERSION 2");
            postService.update(postId, p);
        }
        postService.update(postId, p);
    }

}

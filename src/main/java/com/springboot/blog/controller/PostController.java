package com.springboot.blog.controller;

import com.springboot.blog.playload.PostDto;
import com.springboot.blog.playload.PostResponse;
import com.springboot.blog.service.PostService;
import com.springboot.blog.utills.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

    /*must add @Valid annotation along with @RequestBody ,
     It enables the hibernate validation   */

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService service;


    // create blog post rest api
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto) {
        return new ResponseEntity<>(service.createPost(postDto), HttpStatus.CREATED);
    }

    //get All posts page wise  rest api
    /*http://localhost:8085/api/posts?pagNo=0&pageSize=5&sortBy=id&sortDir=dsc*/
    @GetMapping
    public PostResponse getAllPosts(@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                                    @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
                                    @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
                                    @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {

        return service.getAllPosts(pageNo, pageSize, sortBy, sortDir);
    }

    //get Post by using Id
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(service.getPostById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable(name = "id") Long id) {
        PostDto postResponse = service.updatePost(postDto, id);

        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable(name = "id") Long id) {
        service.deletePostById(id);
        return new ResponseEntity("Post entity deleted successfully", HttpStatus.OK);

    }


}

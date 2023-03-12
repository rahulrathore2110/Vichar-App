package com.vichar.controller;

import com.vichar.DTO.PostDTO;
import com.vichar.model.Post;
import com.vichar.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vichar/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/user/{userId}/cat/{catId}")
    public ResponseEntity<PostDTO> addPostHandler(@Valid @RequestBody PostDTO postDTO, @PathVariable Integer userId,
                                                  @PathVariable Integer catId) {
        PostDTO post = this.postService.addPost(postDTO, userId, catId);
        return new ResponseEntity<PostDTO>(post, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PostDTO>> getPostByUserHandler(@PathVariable Integer userId) {
        List<PostDTO> post = this.postService.getPostByUser(userId);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/category/{catId}")
    public ResponseEntity<List<PostDTO>> getPostByCategoryHandler(@PathVariable Integer catId) {
        List<PostDTO> post = this.postService.getPostByCategory(catId);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDTO> getPostByIdHandler(@PathVariable Integer postId) {
        PostDTO post = this.postService.getPostByIdPost(postId);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<PostDTO>> getAllPostHandler(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) Integer pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
        List<PostDTO> post = this.postService.getAllPost(pageNo, pageSize);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePostByIdHandler(@PathVariable Integer postId) {
        String post = this.postService.deletePost(postId);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<PostDTO> updatePostHandler(@Valid @RequestBody PostDTO postDTO) {
        PostDTO post = this.postService.updatePost(postDTO);
        return new ResponseEntity<PostDTO>(post, HttpStatus.CREATED);
    }

}

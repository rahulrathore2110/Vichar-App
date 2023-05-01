package com.vichar.controller;

import com.vichar.DTO.PostDTO;
import com.vichar.DTO.PostResponse;
import com.vichar.config.Constants;
import com.vichar.service.PostService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @GetMapping("/all")
    public ResponseEntity<PostResponse> getAllPostHandler(
            @RequestParam(value = "pageNo", defaultValue = Constants.PAGE_NUMBER, required = false) Integer pageNo,
            @RequestParam(value = "pageSize", defaultValue = Constants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = Constants.SORt_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = Constants.SORT_DIR, required = false) String sortDir) {
        PostResponse postResponse = this.postService.getAllPost(pageNo, pageSize, sortBy, sortDir);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
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

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<PostDTO>> searchPostHandler(@Valid @PathVariable String keyword) {
        List<PostDTO> post = this.postService.searchPost(keyword);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }


}

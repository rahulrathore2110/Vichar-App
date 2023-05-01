package com.vichar.controller;

import com.vichar.DTO.CommentDTO;
import com.vichar.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vichar/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/{postId}/{userId}")
    public ResponseEntity<CommentDTO> addCommentHandler(@RequestBody CommentDTO commentDTO, @PathVariable Integer postId, @PathVariable Integer userId) {
        CommentDTO commentDTO1 = this.commentService.addComment(commentDTO, postId, userId);
        return new ResponseEntity<>(commentDTO1, HttpStatus.CREATED);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteCommentHandler(@PathVariable Integer commentId) {
        String commentDTO1 = this.commentService.deleteComment(commentId);
        return new ResponseEntity<>(commentDTO1, HttpStatus.CREATED);
    }
}

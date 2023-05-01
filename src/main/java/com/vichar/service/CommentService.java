package com.vichar.service;

import com.vichar.DTO.CommentDTO;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {

    CommentDTO addComment(CommentDTO commentDTO, Integer postId, Integer userId);

    String deleteComment(Integer commentId);
}

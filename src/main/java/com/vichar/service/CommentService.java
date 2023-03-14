package com.vichar.service;

import com.vichar.DTO.CommentDTO;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {

    public CommentDTO addComment(CommentDTO commentDTO, Integer postId, Integer userId);

    public String deleteComment(Integer commentId);
}

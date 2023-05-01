package com.vichar.service;

import com.vichar.DTO.PostDTO;
import com.vichar.DTO.PostResponse;
import com.vichar.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    PostDTO addPost(PostDTO postDTO, Integer UserId, Integer catId);

    PostDTO updatePost(PostDTO postDTO);

    String deletePost(Integer postId);

    PostResponse getAllPost(Integer pageNo, Integer pageSize, String sortBy, String sortDir);

    PostDTO getPostByIdPost(Integer postId);

    List<PostDTO> getPostByCategory(Integer catId);

    List<PostDTO> getPostByUser(Integer userId);

    List<PostDTO> searchPost(String keyword);


}

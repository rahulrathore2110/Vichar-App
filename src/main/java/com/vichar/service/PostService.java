package com.vichar.service;

import com.vichar.DTO.PostDTO;
import com.vichar.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    public PostDTO addPost(PostDTO postDTO, Integer UserId, Integer catId);

    public PostDTO updatePost(PostDTO postDTO);

    public String deletePost(Integer postId);

    public List<PostDTO> getAllPost(Integer pageNo, Integer pageSize);

    public PostDTO getPostByIdPost(Integer postId);

    public List<PostDTO> getPostByCategory(Integer catId);

    public List<PostDTO> getPostByUser(Integer userId);

    public List<PostDTO> searchPost(String keyword);
}

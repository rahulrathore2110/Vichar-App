package com.vichar.serviceimpl;

import com.vichar.DTO.PostDTO;
import com.vichar.DTO.PostResponse;
import com.vichar.exception.CategotyException;
import com.vichar.exception.PostException;
import com.vichar.exception.UserException;
import com.vichar.model.Category;
import com.vichar.model.Post;
import com.vichar.model.User;
import com.vichar.repository.CategoryDao;
import com.vichar.repository.PostDao;
import com.vichar.repository.UserDao;
import com.vichar.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserDao userDao;

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public PostDTO addPost(PostDTO postDTO, Integer userId, Integer catId) {
        User user = this.userDao.findById(userId).orElseThrow(() -> new UserException("User not found with this Id : " + userId));

        Category category = this.categoryDao.findById(catId).orElseThrow(() -> new CategotyException("Category not " +
                "found with this id : " + catId));

        Post post = this.modelMapper.map(postDTO, Post.class);
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);
        Post post1 = this.postDao.save(post);
        return this.modelMapper.map(post1, PostDTO.class);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO) {
        Post post =
                this.postDao.findById(postDTO.getId()).orElseThrow(() -> new PostException("No post found with this " +
                        "id : " + postDTO.getId()));
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());

        Post post1 = this.postDao.save(post);
        return this.modelMapper.map(post, PostDTO.class);
    }

    @Override
    public String deletePost(Integer postId) {
        Post post =
                this.postDao.findById(postId).orElseThrow(() -> new PostException("No post found with this id : " + postId));
        this.postDao.delete(post);
        return "post delete successfully";
    }

    @Override
    public PostResponse getAllPost(Integer pageNo, Integer pageSize, String sortBy, String sortDir) {
        Sort sort = null;
        if (sortDir.equalsIgnoreCase("asc")) {
            sort = Sort.by(sortBy).ascending();
        } else {
            sort = Sort.by(sortBy).descending();
        }

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> pagePosts = this.postDao.findAll(pageable);
        List<Post> posts = pagePosts.getContent();
        List<PostDTO> postDTOS = posts.stream().map(post -> this.modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDTOS);
        postResponse.setPageNumber(pagePosts.getNumber());
        postResponse.setPageSize(pagePosts.getSize());
        postResponse.setTotalElements(pagePosts.getTotalElements());
        postResponse.setTotalPages(pagePosts.getTotalPages());
        postResponse.setLastPage(pagePosts.isLast());

        return postResponse;
    }

    @Override
    public PostDTO getPostByIdPost(Integer postId) {
        Post post =
                this.postDao.findById(postId).orElseThrow(() -> new PostException("No post found with this id : " + postId));
        return this.modelMapper.map(post, PostDTO.class);
    }

    @Override
    public List<PostDTO> getPostByCategory(Integer catId) {
        Category category = this.categoryDao.findById(catId).orElseThrow(() -> new CategotyException("Category not " +
                "found with this id : " + catId));
        List<Post> posts = this.postDao.findByCategory(category);

        List<PostDTO> postDTOS =
                posts.stream().map(post -> this.modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
        return postDTOS;
    }

    @Override
    public List<PostDTO> getPostByUser(Integer userId) {
        User user = this.userDao.findById(userId).orElseThrow(() -> new UserException("User not found with this Id : " + userId));
        List<Post> posts = this.postDao.findByUser(user);
        List<PostDTO> postDTOS = posts.stream().map(post -> this.modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
        return postDTOS;
    }

    @Override
    public List<PostDTO> searchPost(String keyword) {
        List<Post> posts = this.postDao.findByTitleContaining(keyword);
        List<PostDTO> postDTOS = posts.stream().map(post -> this.modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
        return postDTOS;
    }
}

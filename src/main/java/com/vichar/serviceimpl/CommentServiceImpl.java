package com.vichar.serviceimpl;

import com.vichar.DTO.CommentDTO;
import com.vichar.exception.CommentException;
import com.vichar.exception.PostException;
import com.vichar.exception.UserException;
import com.vichar.model.Comment;
import com.vichar.model.Post;
import com.vichar.model.User;
import com.vichar.repository.CommentDao;
import com.vichar.repository.PostDao;
import com.vichar.repository.UserDao;
import com.vichar.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private PostDao postDao;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CommentDTO addComment(CommentDTO commentDTO, Integer postId, Integer userId) {
        Post post = this.postDao.findById(postId).orElseThrow(() -> new PostException("Post not found with this id : " + postId));
        User user =
                this.userDao.findById(userId).orElseThrow(() -> new UserException("No user Found with this Id : " + userId));
        Comment comment = this.modelMapper.map(commentDTO, Comment.class);
        comment.setPost(post);
        comment.setUser(user);
        Comment comment1 = this.commentDao.save(comment);
        return this.modelMapper.map(comment1, CommentDTO.class);
    }

    @Override
    public String deleteComment(Integer commentId) {
        Comment comment = this.commentDao.findById(commentId).orElseThrow(() -> new CommentException("No Comment " +
                "found with this id : " + commentId));
        this.commentDao.delete(comment);
        return "Comment delete successfully";
    }
}

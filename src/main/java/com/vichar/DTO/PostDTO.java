package com.vichar.DTO;

import com.vichar.model.Category;
import com.vichar.model.Comment;
import com.vichar.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class PostDTO {
    private int id;
    private String title;
    private String content;
    private Date addedDate;
    private CategoryDTO category;
    private UserDTO user;
    private Set<CommentDTO> comments;
}

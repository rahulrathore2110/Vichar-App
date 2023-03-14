package com.vichar.DTO;

import com.vichar.model.Post;
import com.vichar.model.User;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {
    private int id;
    private String content;

}

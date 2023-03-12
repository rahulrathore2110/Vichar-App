package com.vichar.DTO;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CategoryDTO {
    private int id;
    @Size(min = 3, max = 150, message = "categoryTitle should be min 3 & max 150 character")
    private String categoryTitle;
    @Size(min = 15, max = 150, message = "categoryDescription should be min 3 max 150 character")
    private String categoryDescription;
}

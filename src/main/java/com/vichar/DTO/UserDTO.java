package com.vichar.DTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private int id;
    @NotNull
    @Size(min = 3, message = "Username should be min 3 character")
    private String name;
    @Email
    private String email;
    @NotNull
    @Size(min = 8, max = 12, message = "Password should be min 8 and max 12 characters")
    private String password;
    @NotNull
    @Size(min = 10, max = 150, message = "Password should be min 10 and max 150 characters")
    private String about;
}

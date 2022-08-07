package com.springboot.blog.playload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/*Lombok reduces the boilerplate code*/
@Data
public class CommentDto {
    private long id;

    @NotEmpty(message = "Name should not be empty or null")
    private String name;
    @NotEmpty(message = "Email should not be empty or null")
    @Email
    private String email;
    @NotEmpty
    @Size(min = 15, message = "Comments body should be minimum 15 characters")
    private String body;
}

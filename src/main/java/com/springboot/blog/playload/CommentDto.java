package com.springboot.blog.playload;

import lombok.Data;
/*Lombok reduces the boilerplate code*/
@Data
public class CommentDto {
    private long id;
    private String name;
    private String email;
    private String body;
}

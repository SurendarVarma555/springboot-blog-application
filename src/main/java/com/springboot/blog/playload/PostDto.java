package com.springboot.blog.playload;

import lombok.Data;

import java.util.Set;

/* We returning PostDto as response by getPostById and getAllPosts ,
* along with we need to return set of comments,
* Mapper will take care of Mapping Post comments with PostDto comments
*
* */

@Data
public class PostDto {
    private Long id;
    private String title;
    private String description;
    private String content;
    private Set<CommentDto> comments;
}

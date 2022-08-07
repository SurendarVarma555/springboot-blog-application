package com.springboot.blog.playload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

/* We returning PostDto as response by getPostById and getAllPosts ,
 * along with we need to return set of comments,
 * Mapper will take care of Mapping Post comments with PostDto comments
 * */

@Data
public class PostDto {
    private Long id;
    //title should not be null or empty
    //title should have at aleast 2 characters
    @NotEmpty
    @Size(min = 2, message = "Post title should have at least 2 characters")
    private String title;
    @Size(min = 6, message = "Post description should have at least 6 characters")
    private String description;
    //Post content should not be null or empty
    @NotEmpty
    private String content;
    private Set<CommentDto> comments;
}

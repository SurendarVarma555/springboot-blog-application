package com.springboot.blog.repository;

import com.springboot.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
/*
Spring Data Jpa internally provides all the crud operations to talk with database*/
public interface PostRepository extends JpaRepository<Post,Long> {
}

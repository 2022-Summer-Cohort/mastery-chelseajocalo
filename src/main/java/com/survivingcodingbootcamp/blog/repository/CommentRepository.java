package com.survivingcodingbootcamp.blog.repository;

import com.survivingcodingbootcamp.blog.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}

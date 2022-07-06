package com.survivingcodingbootcamp.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private long id;
    private String comment;

    @ManyToOne
    private Post post;

    public Comment(String comment, Post post) {
        this.comment = comment;
        this.post = post;
    }
    public Comment(){

    }
    public long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }
}

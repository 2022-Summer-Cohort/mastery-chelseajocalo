package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Comment;
import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.repository.CommentRepository;
import com.survivingcodingbootcamp.blog.repository.HashtagRepository;
import com.survivingcodingbootcamp.blog.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/posts")
public class PostController {
    private PostRepository postRepo;
    private HashtagRepository hashtagRepo;
    private CommentRepository commentRepo;

    public PostController(PostRepository postRepo, HashtagRepository hashtagRepo, CommentRepository commentRepo) {
        this.postRepo = postRepo;
        this.hashtagRepo = hashtagRepo;
        this.commentRepo = commentRepo;
    }

    @GetMapping("/{id}")
    public String displaySinglePost(@PathVariable long id, Model model) {
        model.addAttribute("post", postRepo.findById(id).get());
        return "single-post-template";
    }

    @PostMapping("/{id}/addHashtag")
    public String addHashtagToPost(@PathVariable Long id, @RequestParam String hashtag){
        Post post = postRepo.findById(id).get();
        Optional<Hashtag> hashtagOptional = hashtagRepo.findByName(hashtag);
        if(hashtagOptional.isPresent()){
            if(!post.getHashtags().contains(hashtagOptional.get())){
                post.addHashtag(hashtagOptional.get());
            }
        }
        else{
            Hashtag hashtag1 = new Hashtag(hashtag);
            hashtagRepo.save(hashtag1);
            post.addHashtag(hashtag1);
        }
        postRepo.save(post);

        return "redirect:/posts/" +id;
    }
    @PostMapping("/{id}/addComment")
    public String addCommentToPost(@PathVariable Long id, @RequestParam String comment){
        Post post = postRepo.findById(id).get();
        Comment comment1 = new Comment(comment, post);
        commentRepo.save(comment1);

        return "redirect:/posts/" +id;
    }
}

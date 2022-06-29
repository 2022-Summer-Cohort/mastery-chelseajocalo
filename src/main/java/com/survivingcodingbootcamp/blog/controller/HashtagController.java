package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.repository.HashtagRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller

public class HashtagController {
    private HashtagRepository hashtagRepo;

    public HashtagController(HashtagRepository hashtagRepo) {
        this.hashtagRepo = hashtagRepo;
    }
    @RequestMapping("/hashtags")
    public String displayAllHashtags(Model model){
        model.addAttribute("hashtags", hashtagRepo.findAll());
        return "all-hashtags-template";
    }
    @RequestMapping("/hashtags/{name}")
    public String displaySingleHashtag(Model model, @PathVariable String name) {
        model.addAttribute("hashtag", hashtagRepo.findByName(name).get());
        return "single-hashtag-template";
    }
    @PostMapping("/hashtags/addHashtag")
        public String addHashtagToSystem(@RequestParam String hashtag) {
            Optional<Hashtag> hashtagOptional = hashtagRepo.findByName(hashtag);
            if(!hashtagOptional.isPresent()){
                Hashtag hashtag1 = new Hashtag(hashtag);
                hashtagRepo.save(hashtag1);
            }

            return "redirect:/hashtags";
    }

    }


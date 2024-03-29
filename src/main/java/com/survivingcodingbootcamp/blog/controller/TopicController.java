package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.repository.PostRepository;
import com.survivingcodingbootcamp.blog.repository.TopicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
@RequestMapping("/topics")
public class TopicController {

    private TopicRepository topicRepo;
    private PostRepository postRepo;

    public TopicController(TopicRepository topicRepo, PostRepository postRepo) {
        this.topicRepo = topicRepo;
        this.postRepo = postRepo;
    }

    @GetMapping("/{id}")
    public String displaySingleTopic(@PathVariable long id, Model model) {
        model.addAttribute("topic", topicRepo.findById(id).get());
        return "single-topic-template";
    }
    @PostMapping("/{id}/addPost")
    public String addNewPostToTopic(@RequestParam String title, @RequestParam String author, @PathVariable long id, @RequestParam String content){
        Topic topic = topicRepo.findById(id).get();
        Post post = new Post(title,author,topic,content);
        postRepo.save(post);
        return "redirect:/topics/" +id;
    }

    @PostMapping("/addTopic")
        public String addTopicToHomePage(@RequestParam String topic) {
            Optional<Topic> topicOptional = topicRepo.findByNameIgnoreCase(topic);
            if(!topicOptional.isPresent()){
                Topic topic1 = new Topic(topic);
                topicRepo.save(topic1);
            }

            return "redirect:/";
        }

}

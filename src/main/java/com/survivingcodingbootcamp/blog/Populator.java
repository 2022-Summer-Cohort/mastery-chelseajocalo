package com.survivingcodingbootcamp.blog;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.repository.HashtagRepository;
import com.survivingcodingbootcamp.blog.repository.PostRepository;
import com.survivingcodingbootcamp.blog.repository.TopicRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {

    private TopicRepository topicRepo;
    private PostRepository postRepo;
    private HashtagRepository hashtagRepo;

    public Populator(TopicRepository topicRepo, PostRepository postRepo, HashtagRepository hashtagRepo) {
        this.topicRepo = topicRepo;
        this.postRepo = postRepo;
        this.hashtagRepo = hashtagRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Hashtag testing = new Hashtag("testing");
        hashtagRepo.save(testing);
        Hashtag basics = new Hashtag("basics");
        hashtagRepo.save(basics);
        Hashtag oop = new Hashtag("OOP");
        hashtagRepo.save(oop);
        Hashtag java = new Hashtag("Java");
        hashtagRepo.save(java);
        Hashtag tips = new Hashtag("tips");
        hashtagRepo.save(tips);

        Topic topic1 = new Topic("Learning TDD");
        topicRepo.save(topic1);

       Hashtag[] post1Hashtags = {testing, java};
        Post post1 = new Post("TDD For Fun and Profit",  "Grace Brown", topic1, "Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim" +
                " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis " +
                "aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id " +
                "est laborum.", post1Hashtags);
        postRepo.save(post1);
        Hashtag[] post2Hashtags = {testing, tips};
        Post post2 = new Post("Test the Fear Away", "Chelsea Jo Calo", topic1, "Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim" +
                " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis " +
                "aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id " +
                "est laborum.", post2Hashtags);
        postRepo.save(post2);
        Hashtag[] post3Hashtags = {testing, basics,tips, java};
        Post post3 = new Post("Unit Tests and You", "Chelsea Jo Calo",topic1, "Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim" +
                " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis " +
                "aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id " +
                "est laborum.", post3Hashtags);
        postRepo.save(post3);

        Topic topic2 = new Topic("Battling Imposter Syndrome");
        topicRepo.save(topic2);
        Topic topic3 = new Topic("Introductory Java");
        topicRepo.save(topic3);
        Topic topic4 = new Topic("Object Oriented Programming and You");
        topicRepo.save(topic4);

        testing.addPost(post1);
        testing.addPost(post3);
        testing.addPost(post2);
        hashtagRepo.save(testing);
//        Hashtag basics = new Hashtag("basics");
//        hashtagRepo.save(basics);
//        Hashtag oop = new Hashtag("OOP");
//        hashtagRepo.save(oop);
//        Hashtag java = new Hashtag("Java");
//        hashtagRepo.save(java);
//        Hashtag tips = new Hashtag("tips");
//        hashtagRepo.save(tips);

    }

}

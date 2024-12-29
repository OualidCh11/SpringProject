package Invincibles.gestionrh.controller;

import java.util.List;

import Invincibles.gestionrh.model.Post;
import Invincibles.gestionrh.service.PostService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public Post getPostById(@PathVariable int id) {
        return postService.getPostById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public Post addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public Post updatePost(@PathVariable int id, @RequestBody Post post) {
        return postService.updatePost(id, post);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('GESTIONNAIRERH')")
    public void deletePost(@PathVariable int id) {
        postService.deletePost(id);
    }
    
    @GetMapping("/count")
    public long countPosts() {
        return postService.countPosts();
    }
    

}


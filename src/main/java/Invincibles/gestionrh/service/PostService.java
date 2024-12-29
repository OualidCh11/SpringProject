package Invincibles.gestionrh.service;

import java.util.List;

import Invincibles.gestionrh.model.Post;
import Invincibles.gestionrh.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(int id) {
        return postRepository.findById(id).orElse(null);
    }

    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(int id, Post updatedPost) {
        Post existingPost = getPostById(id);

        // Mise à jour des attributs du poste existant avec les attributs du poste mis à jour
        existingPost.setNom_post(updatedPost.getNom_post());
        existingPost.setDescription_post(updatedPost.getDescription_post());
        // Vous pouvez mettre à jour d'autres attributs selon vos besoins

        return postRepository.save(existingPost);
    }

    public void deletePost(int id) {
        Post existingPost = getPostById(id);
        postRepository.delete(existingPost);
    }
    
    public long countPosts() {
        return postRepository.count();
    }
    

}


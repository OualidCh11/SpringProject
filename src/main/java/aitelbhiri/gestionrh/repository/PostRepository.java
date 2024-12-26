package aitelbhiri.gestionrh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aitelbhiri.gestionrh.model.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("SELECT p FROM Post p WHERE p.id = :id")
    Post getPostById(@Param("id") int id);

    @Query("SELECT p FROM Post p")
    List<Post> getAllPosts();
    
    long count();

    // Ajoutez ici d'autres méthodes spécifiques si nécessaire

}

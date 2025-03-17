package com.app.main_service.repositories;

import com.app.main_service.model.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    boolean existsByTitle(String title);
    Optional<Post> findByIdAndDeletedIsFalse(Integer id);
}

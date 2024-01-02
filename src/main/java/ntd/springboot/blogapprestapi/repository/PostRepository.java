package ntd.springboot.blogapprestapi.repository;

import ntd.springboot.blogapprestapi.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
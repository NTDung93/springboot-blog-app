package ntd.springboot.blogapprestapi.repository;

import ntd.springboot.blogapprestapi.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(long id);
}

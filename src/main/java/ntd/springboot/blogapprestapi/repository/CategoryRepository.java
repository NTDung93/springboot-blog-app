package ntd.springboot.blogapprestapi.repository;

import ntd.springboot.blogapprestapi.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}

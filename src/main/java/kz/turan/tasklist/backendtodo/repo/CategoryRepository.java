package kz.turan.tasklist.backendtodo.repo;

import kz.turan.tasklist.backendtodo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByOrderByTitleAsc();
}

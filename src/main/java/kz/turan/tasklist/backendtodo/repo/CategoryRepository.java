package kz.turan.tasklist.backendtodo.repo;

import kz.turan.tasklist.backendtodo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select c from Category c where" +
            "(:title is null or :title='' or lower(c.title) like lower(concat('%',:title,'%')))" +
            "order by c.title asc")
    List<Category> findByTitle(@Param("title") String title);

    List<Category> findAllByOrderByTitleAsc();
}

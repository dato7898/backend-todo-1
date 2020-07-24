package kz.turan.tasklist.backendtodo.repo;

import kz.turan.tasklist.backendtodo.entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PriorityRepository extends JpaRepository<Priority, Long> {

    @Query("select p from Priority as p where" +
            "(:title is null or :title='' or lower(p.title) like lower(concat('%',:title,'%')))" +
            "order by p.id asc ")
    List<Priority> findByTitle(@Param("title") String title);

    List<Priority> findAllByOrderByIdAsc();
}

package kz.turan.tasklist.backendtodo.repo;

import kz.turan.tasklist.backendtodo.entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriorityRepository extends JpaRepository<Priority, Long> {
    List<Priority> findAllByOrderByIdAsc();
}

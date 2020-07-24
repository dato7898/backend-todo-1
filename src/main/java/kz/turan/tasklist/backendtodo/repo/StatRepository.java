package kz.turan.tasklist.backendtodo.repo;

import kz.turan.tasklist.backendtodo.entity.Stat;
import org.springframework.data.repository.CrudRepository;

public interface StatRepository extends CrudRepository<Stat, Long> {
}

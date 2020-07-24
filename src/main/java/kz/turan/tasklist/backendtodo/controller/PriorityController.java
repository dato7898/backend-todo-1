package kz.turan.tasklist.backendtodo.controller;

import kz.turan.tasklist.backendtodo.entity.Priority;
import kz.turan.tasklist.backendtodo.repo.PriorityRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/priority")
public class PriorityController {

    private final PriorityRepository priorityRepository;

    public PriorityController(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @GetMapping("/test")
    public List<Priority> test() {
        return priorityRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Priority> add(@RequestBody Priority priority) {
        // проверка на обязательные параметры
        if (priority.getId() != null && priority.getId() != 0) {
            // id создается автоматически в БД (autoincrement), поэтому его передавать не нужно, иначе может быть конфликт уникальности значения
            return new ResponseEntity("redundant param: id MUST be null", HttpStatus.NOT_ACCEPTABLE);
        }
        // если передали пустое значение title
        if (priority.getTitle() == null || priority.getTitle().trim().length() == 0) {
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
        }
        if (priority.getColor() == null || priority.getColor().trim().length() == 0) {
            return new ResponseEntity("missed param: color", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(priorityRepository.save(priority));
    }

    @PutMapping("/update")
    public ResponseEntity<Priority> update(@RequestBody Priority priority) {
        if (priority.getId() == null || priority.getId() < 1) {
            return new ResponseEntity("missed param: id", HttpStatus.NOT_ACCEPTABLE);
        }
        if (priority.getTitle() == null || priority.getTitle().trim().length() == 0) {
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
        }
        if (priority.getColor() == null || priority.getColor().trim().length() == 0) {
            return new ResponseEntity("missed param: color", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(priorityRepository.save(priority));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Priority> findById(@PathVariable Long id) {
        Optional<Priority> candidate = priorityRepository.findById(id);
        if (!candidate.isPresent()) {
            return new ResponseEntity("id="+id+" not found", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(candidate.get());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        try {
            priorityRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (EmptyResultDataAccessException ex) {
            return new ResponseEntity("id="+id+" not found", HttpStatus.NOT_ACCEPTABLE);
        }
    }
}

package kz.turan.tasklist.backendtodo.controller;

import kz.turan.tasklist.backendtodo.entity.Stat;
import kz.turan.tasklist.backendtodo.service.StatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StatController {

    private final StatService statService;
    private final Long defaultId = 1L;

    public StatController(StatService statService) {
        this.statService = statService;
    }

    @GetMapping("/stat")
    public ResponseEntity<Stat> stat() {
        return ResponseEntity.ok(statService.findById(defaultId));
    }
}

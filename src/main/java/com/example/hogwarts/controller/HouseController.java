package com.example.hogwarts.controller;

import com.example.hogwarts.model.Faculty;
import com.example.hogwarts.service.HouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("faculty")
public class HouseController {


    private final HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Faculty> getFaculty(@PathVariable Long id) {
        Faculty faculty = houseService.getFaculty(id);
        if (faculty != null) {
            return ResponseEntity.ok(faculty);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Faculty>> getFacultyByColor(@RequestParam String color) {
        return ResponseEntity.ok(houseService.getFacultyByColor(color));
    }

    @PostMapping
    public ResponseEntity<String> addFaculty(@RequestBody Faculty faculty) {
        houseService.addFaculty(faculty);
        return ResponseEntity.ok("Факультет добавлен!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editFaculty(@PathVariable Long id, @RequestBody Faculty faculty) {
        Faculty newFaculty = houseService.editFaculty(id, faculty);
        if (newFaculty != null) {
            return ResponseEntity.ok("Факультет отредактирован");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFaculty(@PathVariable Long id) {
        if (houseService.getFaculty(id) != null) {
            houseService.deleteFaculty(id);
            return ResponseEntity.ok("Факультет удалён");
        }
        return ResponseEntity.notFound().build();
    }
}

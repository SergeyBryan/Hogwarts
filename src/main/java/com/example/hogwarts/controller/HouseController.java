package com.example.hogwarts.controller;

import com.example.hogwarts.model.Faculty;
import com.example.hogwarts.service.HouseServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("faculty")
public class HouseController {


    HouseServiceImpl houseService;

    public HouseController(HouseServiceImpl houseService) {
        this.houseService = houseService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Faculty> getFaculty(@PathVariable Long id) {
        if (houseService.getFaculty(id) != null) {
            return ResponseEntity.ok(houseService.getFaculty(id));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getByColor/{color}")
    public ResponseEntity<List<Faculty>> getFacultyByColor(@PathVariable String color) {
        if (houseService.getFacultyByColor(color) != null) {
            return ResponseEntity.ok(houseService.getFacultyByColor(color));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> addFaculty(@RequestBody Faculty faculty) {
        houseService.addFaculty(faculty);
        return ResponseEntity.ok("Факультет добавлен!");
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<String> editFaculty(@PathVariable Long id, @RequestBody Faculty faculty) {
        if (houseService.getFaculty(id) != null) {
            houseService.editFaculty(id, faculty);
            return ResponseEntity.ok("Факультет отредактирован");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFaculty(@PathVariable Long id) {
        if (houseService.getFaculty(id) != null) {
            houseService.deleteFaculty(id);
            return ResponseEntity.ok("Факультет удалён");
        }
        return ResponseEntity.notFound().build();
    }
}

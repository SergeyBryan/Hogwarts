package com.example.hogwarts.controller;

import com.example.hogwarts.model.Student;
import com.example.hogwarts.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = studentService.getStudent(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudentByAge(@RequestParam int age) {
        List<Student> list = studentService.getStudentByAge(age);
        if (!list.isEmpty()) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseEntity.ok("Студент внесён");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editStudent(@PathVariable Long id, @RequestBody Student student) {
        if (studentService.getStudent(id) != null) {
            studentService.editStudent(id, student);
            return ResponseEntity.ok("Студент был отредактирован");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        if (studentService.getStudent(id) != null) {
            studentService.deleteStudent(id);
            return ResponseEntity.ok("Студент удалён");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}



package com.example.hogwarts.controller;

import com.example.hogwarts.model.Student;
import com.example.hogwarts.service.StudentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        if (studentService.getStudent(id) != null) {
            return ResponseEntity.ok(studentService.getStudent(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getByAge/{age}")
    public ResponseEntity<List<Student>> getStudentByAge(@PathVariable int age) {
        if (studentService.getStudentByAge(age) != null) {
            return ResponseEntity.ok(studentService.getStudentByAge(age));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseEntity.ok("Студент внесён");
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<String> editStudent(@PathVariable Long id, @RequestBody Student student) {
        if (studentService.getStudent(id) != null) {
            studentService.editStudent(id, student);
            return ResponseEntity.ok("Студент был отредактирован");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        if (studentService.getStudent(id) != null) {
            studentService.deleteStudent(id);
            return ResponseEntity.ok("Студент удалён");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}



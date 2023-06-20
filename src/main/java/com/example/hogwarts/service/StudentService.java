package com.example.hogwarts.service;

import com.example.hogwarts.model.Student;

import java.util.List;

public interface StudentService {

    void addStudent(Student student);

    Student editStudent(Long id, Student student);

    void deleteStudent(Long id);

    Student getStudent(Long id);

    List<Student> getStudentByAge(int age);
}

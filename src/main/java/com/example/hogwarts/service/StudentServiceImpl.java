package com.example.hogwarts.service;

import com.example.hogwarts.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    HashMap<Long, Student> studentHashMap = new HashMap<>();
    Long counter = 1L;

    @Override
    public void addStudent(Student student) {
        counter++;
        studentHashMap.put(counter, student);
    }

    @Override
    public void editStudent(Long id, Student student) {
        studentHashMap.put(id, student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentHashMap.remove(id);
    }

    @Override
    public Student getStudent(Long id) {
        return studentHashMap.get(id);
    }

    @Override
    public List<Student> getStudentByAge(int age) {
        return studentHashMap.values().stream().filter(student -> student.getAge() == age).collect(Collectors.toList());
    }
}

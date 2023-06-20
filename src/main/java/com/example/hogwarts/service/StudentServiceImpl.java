package com.example.hogwarts.service;

import com.example.hogwarts.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final Map<Long, Student> studentHashMap = new HashMap<>();
    private Long counter = 1L;

    @Override
    public void addStudent(Student student) {
        counter++;
        studentHashMap.put(counter, student);
    }

    @Override
    public Student editStudent(Long id, Student student) {
        if (studentHashMap.containsKey(id)) {
            studentHashMap.replace(id, student);
            return studentHashMap.get(id);
        } else {
            return null;
        }
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

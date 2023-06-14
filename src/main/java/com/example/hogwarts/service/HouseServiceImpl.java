package com.example.hogwarts.service;

import com.example.hogwarts.model.Faculty;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HouseServiceImpl implements HouseService {

    private HashMap<Long, Faculty> facultyHashMap = new HashMap<>();
    private Long counter = 1L;

    @Override
    public void addFaculty(Faculty faculty) {
        counter++;
        facultyHashMap.put(counter, faculty);
    }

    @Override
    public void editFaculty(Long id, Faculty faculty) {
        facultyHashMap.put(id, faculty);
    }

    @Override
    public void deleteFaculty(Long id) {
        facultyHashMap.remove(id);
    }

    @Override
    public Faculty getFaculty(Long id) {
        return facultyHashMap.get(id);
    }

    @Override
    public List<Faculty> getFacultyByColor(String color) {
        return facultyHashMap.values().stream().filter(faculty -> faculty.getColor().equals(color)).collect(Collectors.toList());
    }
}
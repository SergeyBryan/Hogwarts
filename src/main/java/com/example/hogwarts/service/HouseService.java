package com.example.hogwarts.service;

import com.example.hogwarts.model.Faculty;

import java.util.List;

public interface HouseService {

    void addFaculty(Faculty faculty);

    Faculty editFaculty(Long id, Faculty faculty);

    void deleteFaculty(Long id);

    Faculty getFaculty(Long id);

    List<Faculty> getFacultyByColor(String color);
}

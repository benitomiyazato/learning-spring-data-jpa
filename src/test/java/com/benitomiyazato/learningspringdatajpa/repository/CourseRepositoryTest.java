package com.benitomiyazato.learningspringdatajpa.repository;

import com.benitomiyazato.learningspringdatajpa.entity.Course;
import com.benitomiyazato.learningspringdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    void printAllCourses() {
        List<Course> courseList = courseRepository.findAll();
        List<String> name = courseList.stream().map(Course::getCourseMaterial).collect(Collectors.toList()).stream().map(CourseMaterial::getUrl).collect(Collectors.toList());
        System.out.println("name = " + name);
    }

}
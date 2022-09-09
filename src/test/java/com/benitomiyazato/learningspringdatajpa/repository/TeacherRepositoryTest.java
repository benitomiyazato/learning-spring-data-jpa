package com.benitomiyazato.learningspringdatajpa.repository;

import com.benitomiyazato.learningspringdatajpa.entity.Course;
import com.benitomiyazato.learningspringdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    void saveTeacher(){
        Course courseSQL = Course.builder()
                .title("MySQL")
                .credit(8)
                .build();

        Course coursePython = Course.builder()
                .title("Python")
                .credit(11)
                .build();

        Teacher teacherToSave = Teacher.builder()
                .firstName("Eduardo")
                .lastName("Silva")
                .build();

        teacherRepository.save(teacherToSave);
    }
}
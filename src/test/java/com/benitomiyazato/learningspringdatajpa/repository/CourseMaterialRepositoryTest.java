package com.benitomiyazato.learningspringdatajpa.repository;

import com.benitomiyazato.learningspringdatajpa.entity.Course;
import com.benitomiyazato.learningspringdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void saveCourseMaterial() {
        Course courseToSave = Course.builder()
                .title("Spring Security")
                .credit(11)
                .build();


        CourseMaterial courseMaterialToSave = CourseMaterial.builder()
                .url("http://wikipedia.com")
                .course(courseToSave)
                .build();

        courseMaterialRepository.save(courseMaterialToSave);
    }
}
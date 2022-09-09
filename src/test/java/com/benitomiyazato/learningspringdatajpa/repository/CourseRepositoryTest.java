package com.benitomiyazato.learningspringdatajpa.repository;

import com.benitomiyazato.learningspringdatajpa.entity.Course;
import com.benitomiyazato.learningspringdatajpa.entity.CourseMaterial;
import com.benitomiyazato.learningspringdatajpa.entity.Student;
import com.benitomiyazato.learningspringdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    void printAllCourses() {
        List<Course> courseList = courseRepository.findAll();
        List<String> name = courseList.stream().map(Course::getCourseMaterial).collect(Collectors.toList()).stream().map(CourseMaterial::getUrl).collect(Collectors.toList());
        System.out.println("name = " + name);
    }

    @Test
    void saveCourseWithTeacher() {
        Teacher teacherToSave = Teacher.builder()
                .firstName("JAJAJA")
                .lastName("KAKAKA")
                .build();

        Course courseToSave = Course.builder()
                .title("Spring Data JPA")
                .credit(11)
                .teacher(teacherToSave)
                .build();

        courseRepository.save(courseToSave);
    }

    @Test
    void updateTitleByCourseId() {
        int updated = courseRepository.updateTitleByCourseId("Spring Security", 2L);
        System.out.printf("Updated: %s", updated > 0);
    }

    @Test
    void updateCourseTeacherByCourseId() {
        Teacher newTeacher = teacherRepository.findById(2L).get();

        courseRepository.updateTeacherByCourseId(newTeacher, 2L);
    }

    @Test
    void findCoursePageByNameContaining() {
        Pageable firstPageUpToTenRecords = PageRequest.of(0, 10);
        List<Course> courseList = courseRepository.findCourseByTitleContaining("s", firstPageUpToTenRecords).getContent();
        System.out.println("courseList = " + courseList);
    }

    @Test
    void saveCourseWithStudentAndTeacher(){
        Student student1 = Student.builder()
                .firstName("Fulano")
                .lastName("De Tal")
                .email("fulano.detal@gmail.com")
                .build();

        Student student2 = Student.builder()
                .firstName("Ciclano")
                .lastName("De Tal")
                .email("ciclano.detal@gmail.com")
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Gustavo")
                .lastName("Guanabara")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(11)
                .teacher(teacher)
                .students(List.of(student1, student2))
                .build();

        courseRepository.save(course);
    }
}
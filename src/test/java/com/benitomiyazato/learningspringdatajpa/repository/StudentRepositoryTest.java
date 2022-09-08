package com.benitomiyazato.learningspringdatajpa.repository;

import com.benitomiyazato.learningspringdatajpa.entity.Guardian;
import com.benitomiyazato.learningspringdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("Bills")
                .email("bills@gmail.com")
                .phone("91335-5678")
                .build();

        Student student = Student.builder()
                .firstName("Ciclano")
                .lastName("De Tal")
                .email("ciclano.detal@gmail.com")
                .guardian(guardian)
                .build();

        Student student2 = Student.builder()
                .firstName("Joao")
                .lastName("Silva")
                .email("joao.silva@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
        studentRepository.save(student2);
    }

    @Test
    public void printStudentByNameContaining() {
        List<Student> studentList = studentRepository.findStudentByFirstNameContaining("ano");
        List<String> studentFirstNameList =
                studentList
                        .stream()
                        .map(Student::getFirstName)
                        .collect(Collectors.toList());

        System.out.println("studentFirstNameList = " + studentFirstNameList);
    }

    @Test
    public void printStudentByNameIgnoreCase() {
        List<Student> studentList = studentRepository.findStudentByFirstNameIgnoreCase("joao");
        List<String> studentFirstNameList =
                studentList
                        .stream()
                        .map(Student::getFirstName)
                        .collect(Collectors.toList());

        System.out.println("studentFirstNameList = " + studentFirstNameList);
    }

    @Test
    public void getStudentByEmail() {
        Student student = studentRepository.getStudentByEmail("fulano.detal@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void getStudentFirstNameByEmail() {
        String studentFirstName = studentRepository.getStudentFirstNameByEmail("beltrano.detal@gmail.com");
        System.out.println("studentFirstName = " + studentFirstName);
    }

    @Test
    public void printStudentFirstNameByGuardianEmail() {
        studentRepository.getStudentByGuardianEmail("bills@gmail.com")
                .stream()
                .map(Student::getFirstName)
                .forEach(System.out::println);
    }

    @Test
    public void updateStudentFirstNameByEmail() {
        int updatedStudentId = studentRepository.updateStudentFirstNameByEmail("Jorge", "ciclddano.detal@gmail.com");
        String updated = updatedStudentId > 0 ? "true" : "false";
        System.out.printf("Updated: %s", updated);
    }
}

package com.benitomiyazato.learningspringdatajpa.repository;

import com.benitomiyazato.learningspringdatajpa.entity.Guardian;
import com.benitomiyazato.learningspringdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("Whis")
                .email("whis@gmail.com")
                .phone("91234-5678")
                .build();

        Student student = Student.builder()
                .firstName("Fulano")
                .lastName("De Tal")
                .email("fulano.detal@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }
}

package com.benitomiyazato.learningspringdatajpa.repository;

import com.benitomiyazato.learningspringdatajpa.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryDataJpaTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    private Student studentModel;
    private Long persistedStudentId;
    @BeforeEach
    void setUp() {
        studentModel = Student
                .builder()
                .firstName("Fulano")
                .lastName("De Tal")
                .email("fulano.detal@gmail.com")
                .build();

        persistedStudentId = (Long) testEntityManager.persistAndGetId(studentModel);
    }

    @Test
    @DisplayName("Return a Student when a valid ID is given")
    void findById_returnStudent_whenValidIdIsGiven(){
        Student fetchedStudent = studentRepository.findById(persistedStudentId).get();
        assertEquals(persistedStudentId, fetchedStudent.getStudentId());
    }
}
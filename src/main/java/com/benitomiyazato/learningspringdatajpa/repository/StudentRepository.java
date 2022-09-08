package com.benitomiyazato.learningspringdatajpa.repository;

import com.benitomiyazato.learningspringdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findStudentByFirstNameContaining(String name);

    List<Student> findStudentByFirstNameIgnoreCase(String joao);

    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Student getStudentByEmail(String email);

    @Query("SELECT s FROM Student s WHERE s.guardian.email = ?1")
    List<Student> getStudentByGuardianEmail(String email);

    @Query("SELECT s.firstName FROM Student s WHERE s.email = ?1")
    String getStudentFirstNameByEmail(String email);
}

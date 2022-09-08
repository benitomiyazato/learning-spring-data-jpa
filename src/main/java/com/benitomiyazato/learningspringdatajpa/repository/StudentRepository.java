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

    @Query("SELECT s FROM Student s WHERE s.email = :studentEmail")
    Student getStudentByEmail(String studentEmail);

    @Query("SELECT s FROM Student s WHERE s.guardian.email = :guardianEmail")
    List<Student> getStudentByGuardianEmail(String guardianEmail);

    @Query("SELECT s.firstName FROM Student s WHERE s.email = :studentEmail")
    String getStudentFirstNameByEmail(String studentEmail);
}

package com.benitomiyazato.learningspringdatajpa.repository;

import com.benitomiyazato.learningspringdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findStudentByFirstNameContaining(String name);

    List<Student> findStudentByFirstNameIgnoreCase(String joao);

    @Query("SELECT s FROM Student s WHERE s.email = :studentEmail")
    Student getStudentByEmail(@Param("studentEmail") String studentEmail);

    @Query("SELECT s FROM Student s WHERE s.guardian.email = :guardianEmail")
    List<Student> getStudentByGuardianEmail(@Param("guardianEmail") String guardianEmail);

    @Query("SELECT s.firstName FROM Student s WHERE s.email = :studentEmail")
    String getStudentFirstNameByEmail(@Param("studentEmail") String studentEmail);
}

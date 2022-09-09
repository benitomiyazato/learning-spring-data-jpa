package com.benitomiyazato.learningspringdatajpa.repository;

import com.benitomiyazato.learningspringdatajpa.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}

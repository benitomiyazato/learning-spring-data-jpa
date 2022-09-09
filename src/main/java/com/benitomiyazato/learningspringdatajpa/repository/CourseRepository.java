package com.benitomiyazato.learningspringdatajpa.repository;

import com.benitomiyazato.learningspringdatajpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("UPDATE Student s SET s.firstName = :newName WHERE s.studentId = :courseId")
    @Modifying
    @Transactional
    int updateCourseNameById(@Param("courseId")Long courseId, @Param("newName") String newName);

}

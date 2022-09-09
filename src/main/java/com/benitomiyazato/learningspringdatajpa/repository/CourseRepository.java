package com.benitomiyazato.learningspringdatajpa.repository;

import com.benitomiyazato.learningspringdatajpa.entity.Course;
import com.benitomiyazato.learningspringdatajpa.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Transactional
    @Modifying
    @Query("update Course c set c.title = :newTitle where c.courseId = :courseId")
    int updateTitleByCourseId(@Param("newTitle") String title, @Param("courseId") Long courseId);

    @Transactional
    @Modifying
    @Query("update Course c set c.teacher = ?1 where c.courseId = ?2")
    int updateTeacherByCourseId(Teacher teacher, Long courseId);

}

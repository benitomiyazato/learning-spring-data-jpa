package com.benitomiyazato.learningspringdatajpa.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseMaterialId;
    private String url;

    @OneToOne
    @JoinColumn(name = "course_id", referencedColumnName = "courseId")
    private Course course;
}

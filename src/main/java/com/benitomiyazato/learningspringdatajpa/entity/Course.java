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
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;
    private String title;
    private Integer credit;

    @OneToOne
    @JoinColumn(name = "course_material_id", referencedColumnName = "courseMaterialId")
    private CourseMaterial courseMaterial;
}

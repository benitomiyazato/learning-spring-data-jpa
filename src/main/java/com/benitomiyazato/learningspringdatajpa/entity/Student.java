package com.benitomiyazato.learningspringdatajpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(
        name = "student",
        uniqueConstraints = @UniqueConstraint(columnNames = "email_address")
)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;
    private String firstName;
    private String lastName;

    @Column(name = "email_address", nullable = false)
    private String email;

    @Embedded
    private Guardian guardian;
}

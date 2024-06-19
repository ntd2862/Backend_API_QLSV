package com.example.studentmanagement.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String fullName;

    @Column(nullable = false)
    private LocalDate birthday;

    @Column(nullable = false, length = 50)
    private String className;

    @Column(nullable = false, length = 50)
    private String major;

    @Column(nullable = false, length = 50)
    private String hometown;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false, precision = 4, scale = 2)
    private double averageMark;

    public enum Gender {
        Nam,
        Nữ,
        Khác,
    }
}

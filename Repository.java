package com.example.studentmanagement.repository;

import com.example.studentmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFullNameIgnoreCaseContaining(String fullName);
    List<Student> findByBirthdayBetween(LocalDate startDate, LocalDate endDate);
    List<Student> findByGender(Student.Gender gender);
    List<Student> findByHometownIgnoreCaseContaining(String hometown);
    List<Student> findByClassNameIgnoreCaseContaining(String className);
    List<Student> findByMajorIgnoreCaseContaining(String major);
    List<Student> findByAverageMarkBetween(double minMark, double maxMark);
}

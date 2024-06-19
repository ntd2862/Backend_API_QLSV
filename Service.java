package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        // Validate thông tin
        validateStudent(student);
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        // Update thông tin
        student.setFullName(studentDetails.getFullName());
        student.setBirthday(studentDetails.getBirthday());
        student.setClassName(studentDetails.getClassName());
        student.setMajor(studentDetails.getMajor());
        student.setHometown(studentDetails.getHometown());
        student.setGender(studentDetails.getGender());
        student.setAverageMark(studentDetails.getAverageMark());
        validateStudent(student);
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> searchStudents(String fullName, LocalDate startDate, LocalDate endDate, Student.Gender gender, String hometown, String className, String major, Double minMark, Double maxMark) {
        // Implement tìm kiếm theo tiêu chí
        return studentRepository.findAll(); // Chỉ là ví dụ, cần implement logic tìm kiếm cụ thể
    }

    public List<Student> getStudentsWithBirthdayToday() {
        LocalDate today = LocalDate.now();
        return studentRepository.findByBirthday(today);
    }

    private void validateStudent(Student student) {
        // Validate thông tin sinh viên
        if (student.getFullName() == null || student.getFullName().isEmpty()) {
            throw new RuntimeException("Full name is required");
        }
        if (student.getFullName().length() > 50) {
            throw new RuntimeException("Full name must be less than 50 characters");
        }
        if (student.getAverageMark() < 0 || student.getAverageMark() > 10) {
            throw new RuntimeException("Average mark must be between 0 and 10");
        }
        // Thêm các validate khác
    }
}

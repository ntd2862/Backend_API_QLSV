package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        return studentService.updateStudent(id, studentDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping
    public List<Student> searchStudents(@RequestParam(required = false) String fullName,
                                        @RequestParam(required = false) LocalDate startDate,
                                        @RequestParam(required = false) LocalDate endDate,
                                        @RequestParam(required = false) Student.Gender gender,
                                        @RequestParam(required = false) String hometown,
                                        @RequestParam(required = false) String className,
                                        @RequestParam(required = false) String major,
                                        @RequestParam(required = false) Double minMark,
                                        @RequestParam(required = false) Double maxMark) {
        return studentService.searchStudents(fullName, startDate, endDate, gender, hometown, className, major, minMark, maxMark);
    }

    @GetMapping("/birthdays")
    public List<Student> getStudentsWithBirthdayToday() {
        return studentService.getStudentsWithBirthdayToday();
    }
}

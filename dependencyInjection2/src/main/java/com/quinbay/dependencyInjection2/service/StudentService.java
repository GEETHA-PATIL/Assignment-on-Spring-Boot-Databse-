package com.quinbay.dependencyInjection2.service;

import com.quinbay.dependencyInjection2.dto.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();


    void addStudent(int test, Student student);
    Student updateStudent(Student student1);
    void  deleteStudent(int test,Long id);


}

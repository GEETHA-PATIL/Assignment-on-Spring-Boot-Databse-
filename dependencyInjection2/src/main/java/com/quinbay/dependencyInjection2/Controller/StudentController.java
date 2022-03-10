package com.quinbay.dependencyInjection2.Controller;

import com.quinbay.dependencyInjection2.dto.Student;
import com.quinbay.dependencyInjection2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("Student")
public class StudentController {

    @Autowired
    StudentService studentService;


    @GetMapping("/studentlist")
    public List<Student> display() {
        return studentService.getAllStudents();
    }


    @PostMapping
    public void addStudent(@RequestParam int test,@RequestBody Student student){


        studentService.addStudent(test,student);

    }

    @PutMapping("/update")
    public void updateStudent(@RequestBody Student student1) {


        studentService.updateStudent(student1);}


    @DeleteMapping()
            public void deleteStudent(@RequestParam int test,@RequestParam Long id)
    {
        studentService.deleteStudent(test,id);
    }
}

package com.quinbay.dependencyInjection2.repository;

import com.quinbay.dependencyInjection2.dto.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class Studentdb {

    public static List<Student> mylist1 = new ArrayList<Student>();

    public List<Student> getMylist() {
        return mylist1;
    }

    public List<Student> getStudentList(){

//        mylist1.add(new Student(1, "Geetha", "Patil", "EC"));
//        mylist1.add(new Student(2, "A1", "A2", "EC"));
//        mylist1.add(new Student(3, "B1", "B2", "EC"));
//        mylist1.add(new Student(4, "C1", "C2", "EC"));

        return mylist1;
    }
}

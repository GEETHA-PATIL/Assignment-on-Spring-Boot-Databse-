package com.quinbay.dependencyInjection2.service;

import com.quinbay.dependencyInjection2.dto.Student;

import com.quinbay.dependencyInjection2.entity.StudentEntity;

import com.quinbay.dependencyInjection2.repository.StudentMongoRepository;
import com.quinbay.dependencyInjection2.repository.StudentRedisRepository;
import com.quinbay.dependencyInjection2.repository.StudentRepository;
import com.quinbay.dependencyInjection2.repository.Studentdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.quinbay.dependencyInjection2.repository.StudentRedisRepository.save;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    Studentdb studentdb;
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentRedisRepository studentRedisRepository;

    @Autowired
    StudentMongoRepository studentMongoRepository;

    @Override
    public List<Student> getAllStudents() {

//ListDb
        List<Student> newlist = new ArrayList<>();
        newlist.addAll(studentdb.getStudentList());
//PostgreSQL
        List<Student> mylist1 = new ArrayList<>();
        Iterable<StudentEntity> studententityList = studentRepository.findAll();
        for (StudentEntity st : studententityList) {
            mylist1.add(new Student(st.getId(), st.getFirstName(), st.getLastName(), st.getBranch()));
        }
        newlist.addAll(mylist1);
//REDIS
        newlist.addAll(studentRedisRepository.findAll());
//MongoDb
        List<Student> list = new ArrayList<Student>();
        studentMongoRepository.findAll().forEach(list::add);


        newlist.addAll(list);

        return newlist;

    }







    @Override
    public void addStudent(int test, Student student) {

        {
            //ListDb
            if (test == 1) {

                studentdb.getStudentList().add(new Student(student.getId(), student.getFirstName(), student.getLastName(), student.getBranch()));
            }
//PostgreSQL
            else if (test == 2) {


                StudentEntity studentEntity=new StudentEntity();
                studentEntity.setId(student.getId());
                studentEntity.setFirstName(student.getFirstName());
                studentEntity.setLastName(student.getLastName());
                studentEntity.setBranch(student.getBranch());


                studentRepository.save(studentEntity);


            }
            //REDIS

            else if (test == 3) {
                StudentRedisRepository.insert(student);
            }
//MongoDb
            else
            {
                System.out.println(studentMongoRepository.save(new Student(student.getId(), student.getFirstName(),student.getLastName(),student.getBranch())));

            }


        }
    }


    public Student updateStudent(Student student) {
//ListDb
        for (Student st : studentdb.getStudentList()) {
            if (st.getId().equals(student.getId())) {
                studentdb.getStudentList().remove(st);
                studentdb.getStudentList().add(new Student(student.getId(), student.getFirstName(), student.getLastName(), student.getBranch()));
            }
        }
//PostgreSQL
        for (StudentEntity studentEntity : studentRepository.findAll()) {
            if (studentEntity.getId().equals(student.getId())) {

                studentEntity.setId(student.getId());
                studentEntity.setFirstName(student.getFirstName());
                studentEntity.setLastName(student.getLastName());
                studentEntity.setBranch(student.getBranch());
                studentRepository.save(studentEntity);


            }
        }
//REDIS
        StudentRedisRepository.save(student);


        //MongoDb
        for (Student stu : studentMongoRepository.findAll()) {
            if (student.getId().equals(stu.getId()))
                studentMongoRepository.save(new Student(student.getId(), student.getFirstName(), student.getLastName(), student.getBranch()));

        }


        return student;


    }



    public void deleteStudent(int n,Long id) {
//ListDb
        if (n == 1) {

            for (Student st : studentdb.getStudentList()) {
                if (st.getId().equals(id)) {
                    studentdb.mylist1.remove(st);
                }

            }
        }
        //PostgreSQL
        else if (n == 2) {
            for (StudentEntity studentEntity : studentRepository.findAll()) {

                if (studentEntity.getId().equals(id)) {
                    studentRepository.delete(studentEntity);
                }
            }


//REDIS

        } else if (n == 3) {
            List<Student> mylist3 = studentRedisRepository.findAll();
            for (Student st : mylist3) {
                if (st.getId().equals(id)) {
                    studentRedisRepository.delete(st);
                }
            }


        }

        //MongoDb
        else
            for (Student stu : studentMongoRepository.findAll()) {
                if (stu.getId().equals(id))

                    studentMongoRepository.delete(stu);
            }
    }
}








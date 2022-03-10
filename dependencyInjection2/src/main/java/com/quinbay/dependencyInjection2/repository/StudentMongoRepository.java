package com.quinbay.dependencyInjection2.repository;


import com.quinbay.dependencyInjection2.dto.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentMongoRepository extends MongoRepository<Student, String>{}

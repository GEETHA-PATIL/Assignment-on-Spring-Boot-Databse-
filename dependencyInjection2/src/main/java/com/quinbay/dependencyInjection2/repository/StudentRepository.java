package com.quinbay.dependencyInjection2.repository;

import com.quinbay.dependencyInjection2.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StudentRepository  extends CrudRepository<StudentEntity,Long> {




}

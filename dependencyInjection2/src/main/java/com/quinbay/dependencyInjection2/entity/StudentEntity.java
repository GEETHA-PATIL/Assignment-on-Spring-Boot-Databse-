package com.quinbay.dependencyInjection2.entity;

import org.hibernate.annotations.Table;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
//@Table(name="Student")
@javax.persistence.Table(name = "Student")
public class StudentEntity {

    public StudentEntity(String firstName) {
        this.firstName = firstName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // @NotBlank(message = "Student name cannot be empty")
    private String firstName;
    private String lastName;
    private String branch;


    public StudentEntity() {
    }

    public StudentEntity(Long id, String firstName, String lastName, String branch) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.branch = branch;

    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}


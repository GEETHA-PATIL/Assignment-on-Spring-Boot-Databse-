package com.quinbay.dependencyInjection2.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Student implements Serializable {

//    @NotNull
    public Long id;

//    @NotBlank(message="Student name cannot be empty")
    public String firstName;
    public String lastName;
    public String branch;

    public Student( Long id,String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public Student() {
        Long id;
        String firstName;
        String lastName;
         String branch;

    }

    public Student(Long id, String firstName, String lastName, String branch) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.branch = branch;
    }

    public static void main(String[] args) {
        // write your code here
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


//    public void setBranch(List<DepartmentDb> branch) {
//        this.branch = branch;
//    }

    @Override
    public String toString() {
        return ("Student" + "firstName" + " " + firstName + " " +
                "lastName" + " " + lastName + " " +
                "Id" + " " + id
        );
    }



}

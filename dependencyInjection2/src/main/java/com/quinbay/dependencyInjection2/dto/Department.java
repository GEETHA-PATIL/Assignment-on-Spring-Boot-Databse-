package com.quinbay.dependencyInjection2.dto;

public class Department {


    public String  departmentId;
    public String departmentName;
    public String professorName ;





    public Department(){
     String  departmentId;
     String departmentName;
     String professorName ;

    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public Department(String  departmentId, String departmentName, String professorName) {

        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.professorName = professorName;
    }

    @Override
    public String toString() {
        return ("Department id" + " " + departmentId + " " +
                "Department Name" + " " + departmentName + " " +
                "Professor name" + " " + professorName
        );

    }
}


package com.quinbay.dependencyInjection2.repository;
import com.quinbay.dependencyInjection2.dto.Department;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentDb {





        private static List<Department> mylist = new ArrayList<Department>();

        public List<Department> getMylist() {
            return mylist;
        }

        public List<Department> getDepartmentList(){


            mylist.add(new Department("01EC", "EC", "EcProfessor"));
            mylist.add(new Department("02CS", "CS", "CsProfessor"));
            mylist.add(new Department("03IS", "IS", "ISProfessor"));
            mylist.add(new Department("04EE", "EE", "EEProfessor"));

            return mylist;
        }
    }


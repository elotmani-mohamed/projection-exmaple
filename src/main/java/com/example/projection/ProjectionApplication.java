package com.example.projection;

import com.example.projection.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProjectionApplication implements CommandLineRunner {

    @Autowired
    private EmployeeRepo employeeRepo;

    public static void main(String[] args) {
        SpringApplication.run(ProjectionApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Alex Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Tomas Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Teriza Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Karin Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Obama Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Samuel Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Luaratin Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Alan Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        employeeRepo.saveAll(employeeList);


        //fetcing data using projection interface
        EmployeeDTO employee =
                employeeRepo.getEmployeeNameAndDepartement("Alex Brein",
                                                               "HR");

        System.err.println("name of employee is ---> "+employee.getName());
        System.err.println("name of departement is ---> "+employee.getDepartment());


    }
}

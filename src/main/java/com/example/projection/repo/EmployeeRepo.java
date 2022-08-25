package com.example.projection.repo;

import com.example.projection.Employee;
import com.example.projection.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {




    @Query(value = "select * from employee e where e.name=?1 and e.department=?2",nativeQuery = true)
     EmployeeDTO getEmployeeNameAndDepartement(String name,String department);
    
    @Query(value = "select e.name as name,e.department as department  from Employee e where e.name=:name and e.department=:department")
    EmployeeDTO getEmployeeNameAndDepartementJPQL(String name,String department);

    EmployeeDTO findEmployeeByNameAndDepartment(String name, String department);

}

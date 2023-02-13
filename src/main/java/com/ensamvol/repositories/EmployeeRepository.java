package com.ensamvol.repositories;

import com.ensamvol.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    void deleteEmployeeByIdEmployee(Integer idEmployee);

}

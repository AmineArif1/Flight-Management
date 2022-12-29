package com.ensamvol.repositories;

import com.ensamvol.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    void deleteEmployeeByIdEmployee(Long idEmployee);

}

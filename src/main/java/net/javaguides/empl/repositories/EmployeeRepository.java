package net.javaguides.empl.repositories;

import net.javaguides.empl.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //all crud database methods

}

package net.javaguides.empl.service;


import net.javaguides.empl.model.Employee;
import net.javaguides.empl.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository =employeeRepository;
    }
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id).orElseThrow();
    }

    public Employee addEmployee(Employee e1) throws IllegalStateException{
        List<Employee> employees = employeeRepository.findAll();
        int i=0;
        while(i<employees.size()){
            if(employees.get(i).equals(e1)){
                throw new IllegalStateException("Employee already exists");
            }
            i++;
        }
        return employeeRepository.save(e1);
    }
    //Update an event
    public Employee updateEmployee(Employee employee ,Long id) throws IllegalStateException{
        Employee e=employeeRepository.findById(id).orElseThrow();
        e.setFirstName(employee.getFirstName());
        e.setLastName(employee.getLastName());
        e.setEmailId(employee.getEmailId());
        return employeeRepository.save(e);
    }
    //Delete an event
    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
}

package net.javaguides.empl.controller;


import net.javaguides.empl.model.Employee;
import net.javaguides.empl.repositories.EmployeeRepository;
import net.javaguides.empl.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employee")
    public Employee addEmployee(@Valid Employee employee){
        return employeeService.addEmployee(employee);
    }
    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable Long id,@RequestBody @Valid Employee employee){
        return employeeService.updateEmployee(employee,id);
    }
    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }

}


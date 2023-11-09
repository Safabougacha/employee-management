package net.javaguides.empl;

import net.javaguides.empl.model.Employee;
import net.javaguides.empl.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmplManagementApplication  {

	public static void main(String[] args) {
		SpringApplication.run(EmplManagementApplication.class, args);
	}

}

package com.spring.university.backenduniversity;

import com.spring.university.backenduniversity.dao.EmployeeDAO;
import com.spring.university.backenduniversity.persistence.entity.Address;
import com.spring.university.backenduniversity.persistence.entity.Employee;
import com.spring.university.backenduniversity.persistence.entity.EmployeeType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class EmployeeCommands implements CommandLineRunner {
    private final EmployeeDAO employeeService;

    public EmployeeCommands(EmployeeDAO employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        Employee employee = new Employee(null, "Juan", "Perez", "dfresdw4",
                new Address("Calle 5", "998", "54321", null, null, "México"),
                new BigDecimal(26000), EmployeeType.ADMINISTRATIVE);
        employeeService.save(employee);
    }
}

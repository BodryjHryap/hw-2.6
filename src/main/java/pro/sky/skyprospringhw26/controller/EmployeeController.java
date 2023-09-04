package pro.sky.skyprospringhw26.controller;

import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringhw26.model.Employee;
import pro.sky.skyprospringhw26.service.EmployeeService;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}

package pro.sky.skyprospringhw26.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.skyprospringhw26.model.Employee;
import pro.sky.skyprospringhw26.service.EmployeeService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @ExceptionHandler(RuntimeException.class)
    public String handleException(RuntimeException e) {
        return e.getMessage();
    }

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.add(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.remove(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.find(firstName, lastName);
    }

    @GetMapping("/getAllEmployees")
    public Collection<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}

package pro.sky.skyprospringhw26.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringhw26.exceptions.EmployeeAlreadyAddedException;
import pro.sky.skyprospringhw26.exceptions.EmployeeNotFoundException;
import pro.sky.skyprospringhw26.exceptions.EmployeeStorageIsFullException;
import pro.sky.skyprospringhw26.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final int maxSize = 9;
    private final List<Employee> employees = new ArrayList<>();

    public Employee add(String firstName, String lastName) {

        if (employees.size() >= maxSize) {
            throw new EmployeeStorageIsFullException("Достигнут лимит на добавление сотрудников!");
        }
        Employee employeeAdded = new Employee(firstName, lastName);
        if (employees.contains(employeeAdded)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже был добавлен!");
        }


        employees.add(employeeAdded);
        return employeeAdded;
    }

    public Employee remove(String firstName, String lastName) {
        Employee employeeRemoved = new Employee(firstName, lastName);
        if (!employees.contains(employeeRemoved)) {
            throw new EmployeeNotFoundException("Удаляемого Вами сотрудника не существует!");
        }
        employees.remove(employeeRemoved);
        return employeeRemoved;
    }

    public Employee find(String firstName, String lastName) {
        Employee employeeFinded = new Employee(firstName, lastName);

        if (!employees.contains(employeeFinded)) {
            throw new EmployeeNotFoundException("Искомого Вами сотрудника не существует!");
        }

        for (Employee employee : employees) {
            if (employee.equals(employeeFinded)) {
                return employee;
            }
        }
        return null;
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }
}

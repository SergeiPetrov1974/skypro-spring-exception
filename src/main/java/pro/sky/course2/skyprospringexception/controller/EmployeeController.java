package pro.sky.course2.skyprospringexception.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course2.skyprospringexception.data.Employee;
import pro.sky.course2.skyprospringexception.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public  class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String add(@RequestParam String firstName, @RequestParam String secondName) {
        return employeeService.add(firstName, secondName);
    }

    @GetMapping("/remove")
    public String remove(@RequestParam String firstName, @RequestParam String secondName) {
        return employeeService.remove(firstName, secondName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String secondName) {
        return employeeService.find(firstName, secondName);
    }
}

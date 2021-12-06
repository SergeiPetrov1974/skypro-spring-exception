package pro.sky.course2.skyprospringexception.ServiceImpl;

import org.springframework.stereotype.Service;
import pro.sky.course2.skyprospringexception.data.Employee;
import pro.sky.course2.skyprospringexception.exceptions.EmployeeBooksIsOverLoaded;
import pro.sky.course2.skyprospringexception.exceptions.EmployeeNotFound;
import pro.sky.course2.skyprospringexception.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final Employee[] employees = new Employee[10];

    @Override
    public String add(String firstName, String secondName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(firstName, secondName);
                return "Сотрудник " + employees[i].getFullName() + " добавлен";
            }
        }
        throw new EmployeeBooksIsOverLoaded();
    }

    @Override
    public String remove(String firstName, String secondName) {
        Employee employeeRemove = new Employee(firstName, secondName);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].equals(employeeRemove)) {
                employees[i] = null;
                return "Сотрудник " + employeeRemove.getFullName() + " удалён";
            }
        }
        throw new EmployeeNotFound();
    }
    @Override
    public Employee find(String firstName, String secondName) {
        Employee employeeFind = new Employee(firstName, secondName);
        for (Employee employee : employees) {
            if (employee != null && employee.equals(employeeFind)) {
                return employee;
            }
        }
        throw new EmployeeNotFound();
    }
}

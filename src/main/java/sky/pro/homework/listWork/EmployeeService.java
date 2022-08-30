package sky.pro.homework.listWork;
import org.springframework.stereotype.Service;
import sky.pro.homework.listWork.Exception.EmployeeAlreadyAddedException;
import sky.pro.homework.listWork.Exception.EmployeeNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    List<Employee> employees = new ArrayList<>();

    public void addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if(employees.contains(employee)){
            employees.add(employee);
        } else {
            throw new EmployeeAlreadyAddedException("Сотрудник уже есть в листе");
        }
    }


    public void deleteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)){
            throw new EmployeeNotFoundException("Сотрудник не найден");
        } else {
            employees.remove(employee);
        }

    }


    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new RuntimeException("Сотрудник не найден");
    }
}





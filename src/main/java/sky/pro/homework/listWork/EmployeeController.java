package sky.pro.homework.listWork;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/find")
    public String find(@RequestParam(name = "firstName") String firstName,
                         @RequestParam(name = "lastname") String lastName) {
         employeeService.findEmployee(firstName,lastName);
        return "Сотрудник с именем и фамилией"+" "+firstName+" "+lastName+" найден";
    }

    @GetMapping("/add")
    public String add(@RequestParam(name = "firstName") String firstName,
                    @RequestParam(name = "lastname") String lastName) {
        employeeService.addEmployee(firstName, lastName);
        return "Сотрудник с именем и фамилией"+" "+firstName+" "+lastName+" добавлен";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "firstName") String firstName,
                       @RequestParam(name = "lastname") String lastName) {
        employeeService.deleteEmployee(firstName, lastName);
        return "Сотрудник с именем и фамилией"+" "+firstName+" "+lastName+" удален";
    }
}

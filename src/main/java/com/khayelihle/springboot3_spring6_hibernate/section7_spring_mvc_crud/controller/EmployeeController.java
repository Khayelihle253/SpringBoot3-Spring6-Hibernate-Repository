package com.khayelihle.springboot3_spring6_hibernate.section7_spring_mvc_crud.controller;

import com.khayelihle.springboot3_spring6_hibernate.section5_rest_api_security_using_spring_data_jpa.entity.Employee1;
import com.khayelihle.springboot3_spring6_hibernate.section5_rest_api_security_using_spring_data_jpa.service.EmployeeService1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService1 employeeService1;

    //employee service 1 injection, no need for @Autowired annotation since we have only one dependency in this class
    public EmployeeController(EmployeeService1 employeeService1) {
        this.employeeService1 = employeeService1;
    }

    @GetMapping("/list")
    public String getEmployees(Model theModel){

        //get the list of employees from the database and put it in the model
        theModel.addAttribute("employees", employeeService1.findAll());

        return "employees/list-employees";

    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        //create model attribute to bind the form data
        Employee1 theEmployee = new Employee1();

        theModel.addAttribute("employee", theEmployee);

        return "employees/employee-form";

    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee1 theEmployee){  //form data is passed in ("employee" using data binding - th:object)

        //save the employee
        employeeService1.save(theEmployee);

        //use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";

    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){

        //get the employee from the service
        Employee1 theEmployee = employeeService1.findById(theId);

        //set employee in the model to prepopulate the form
        theModel.addAttribute("employee", theEmployee);

        //send over to the form

        return "employees/employee-form";
    }
}

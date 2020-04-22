package edu.hotelManage.controller;


import edu.hotelManage.entity.Employee;
import edu.hotelManage.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping( "/employee" )
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @CrossOrigin
    @GetMapping( "/findAll" )
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping( "/findById/{id}" )
    public Employee findById(@PathVariable( "id" ) Integer id) {
        /**
         * 测试能否正常取出时间
         */
//        Employee employee=employeeService.findById(id);
//        Date date= employee.getInDate();
//        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(simpleDateFormat.format(date));
        return employeeService.findById(id);
    }

    @GetMapping( "/findByPhone/{phoneNumber}" )
    public List<Employee> findByPhone(@PathVariable( "phoneNumber" ) String phoneNumber) {
        return employeeService.findByPhone(phoneNumber);
    }

    @GetMapping( "/findByName/{name}" )
    public List<Employee> findByName(@PathVariable( "name" ) String name) {
        return employeeService.findByName(name);
    }

    @PostMapping( {"/addEmployee", "/save"} )
    public void save(@RequestBody Employee employee) {
        employeeService.save(employee);
    }

    @PostMapping( "/updatePhoneNumber/{id}/{phoneNumber}" )
    public void updatePhoneNumber(@PathVariable( "id" ) Integer id, @PathVariable( "phoneNumber" ) String PhoneNumber) {
        employeeService.updatePhoneNumber(id, PhoneNumber);
    }

    @PostMapping( "/updateSalary/{id}/{salary}" )
    public void updateSalary(@PathVariable( "id" ) Integer id, @PathVariable( "salary" ) int salary) {
        employeeService.updateSalary(id, salary);
    }

}

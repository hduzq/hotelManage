package edu.hotelManage.service;

import edu.hotelManage.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(Integer id);

    List<Employee> findByPhone(String phoneNumber);

    List<Employee> findByName(String name);

    void save(Employee employee);//这个就是用来增加员工的！不用再写insert了！

    void updatePhoneNumber(Integer id, String PhoneNumber);

    void updateSalary(Integer id, int salary);

}

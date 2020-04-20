package edu.hotelManage.service.impl;

import edu.hotelManage.entity.Employee;
import edu.hotelManage.repository.EmployeeMapper;
import edu.hotelManage.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> findAll() {
        return employeeMapper.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return employeeMapper.findById(id);
    }

    @Override
    public List<Employee> findByPhone(String phoneNumber) {
        return employeeMapper.findByPhone(phoneNumber);
    }

    @Override
    public List<Employee> findByName(String name) {
        return employeeMapper.findByName(name);
    }

    @Override
    public void save(Employee employee) {
        employeeMapper.save(employee);
    }

    @Override
    public void updatePhoneNumber(Integer id, String PhoneNumber) {
        Employee employeeTemp = employeeMapper.findById(id);
        employeeTemp.setPhoneNumber(PhoneNumber);
        employeeMapper.update(employeeTemp);
    }

    @Override
    public void updateSalary(Integer id, int salary) {
        Employee employeeTemp = employeeMapper.findById(id);
        employeeTemp.setSalary(salary);
        employeeMapper.update(employeeTemp);
    }


}

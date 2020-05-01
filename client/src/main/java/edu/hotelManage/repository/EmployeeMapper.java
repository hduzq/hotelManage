package edu.hotelManage.repository;

import edu.hotelManage.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper {
    List<Employee> findAll();

    Employee findById(Integer id);

    List<Employee> findByPhone(String phoneNumber);

    List<Employee> findByName(String name);

    void save(Employee employee);

    void update(Employee employee);

}

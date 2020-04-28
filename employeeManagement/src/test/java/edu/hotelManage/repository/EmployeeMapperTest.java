package edu.hotelManage.repository;

import edu.hotelManage.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    void findAll() {
        List<Employee> list = employeeMapper.findAll();
        int i = 0;
    }


    @Test
    void findById() {
    }

    @Test
    void findByPhone() {
    }

    @Test
    void findByName() {
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }
}

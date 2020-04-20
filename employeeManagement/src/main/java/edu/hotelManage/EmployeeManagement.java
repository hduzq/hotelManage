package edu.hotelManage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan( "edu.hotelManage.repository" )
public class EmployeeManagement {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagement.class, args);
    }
}

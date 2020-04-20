package edu.hotelManage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan( "edu.hotelManage.repository" )
public class RoomManagement {
    public static void main(String[] args) {
        SpringApplication.run(RoomManagement.class, args);
    }
}

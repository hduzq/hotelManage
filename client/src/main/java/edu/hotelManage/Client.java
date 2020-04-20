package edu.hotelManage;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan( "edu.hotelManage.repository" )
public class Client {
    public static void main(String[] args) {
        SpringApplication.run(Client.class, args);
    }
}

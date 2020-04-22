package edu.hotelManage.controller;

import edu.hotelManage.entity.Room;
import edu.hotelManage.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "/room" )
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping( "/findAll" )
    public List<Room> findAll() {
        List<Room> rooms = roomService.findAll();
        for (Room room :
                rooms) {
            System.out.println(room);
        }
        return roomService.findAll();
    }
}

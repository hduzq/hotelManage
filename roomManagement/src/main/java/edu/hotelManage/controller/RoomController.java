package edu.hotelManage.controller;

import edu.hotelManage.entity.Room;
import edu.hotelManage.entity.RoomType;
import edu.hotelManage.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @GetMapping("/findAllEmptyRoom")
    public List<Room> findAllEmptyRoom(){
        List<Room> rooms = roomService.findAll();
        return roomService.findAllEmptyRoom();
    }
    @PostMapping("/disableRoom/{id}")
    public boolean disableRoom(@PathVariable("id") Long id){
        return roomService.disableRoom(id);
    }
    @PostMapping("/enableRoom/{id}")
    public boolean enableRoom(@PathVariable("id") Long id){
        return roomService.enableRoom(id);
    }
    @PostMapping("/disableRoomWithDate/{begin}/{end}")
    public boolean disableRoomWithDate(@PathVariable("begin")String begin,
                                       @PathVariable("end") String end){
        SimpleDateFormat beginF = new SimpleDateFormat("yyyy-MM-dd:mm:ss");
        SimpleDateFormat endF = new SimpleDateFormat("yyyy-MM-dd:mm:ss");
        try {
            Date beginDate = beginF.parse(begin);
            Date endDate = endF.parse(end);
            return roomService.disableRoomWithDate(beginDate,endDate);
        } catch (ParseException e) {

            e.printStackTrace();
            return false;
        }
    }
    @PostMapping("/addRoomType")
    public boolean addRoomType(@RequestBody RoomType roomType){
        if(roomType!=null&&roomType.getId()!=null)
        return roomService.addRoomType(roomType);
        else return false;
    }
}

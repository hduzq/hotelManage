package edu.hotelManage.controller;

import edu.hotelManage.VO.InsertVO;
import edu.hotelManage.VO.RoomVO;
import edu.hotelManage.entity.Room;
import edu.hotelManage.entity.RoomType;
import edu.hotelManage.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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
        return roomService.findAll();
    }

    /**
     * 1.	显示当前空房
     * 2.	预设某段时间某房间不可用
     * 3.	设置某房间不可用
     * 4.	提前结束某房间的不可用状态
     * 5.	查看所有房间信息
     * 6.	增加新的房间信息(主要面向初次使用系统)
     */
    @GetMapping( "/findEmptyRoom" )
    List<Room> findEmptyRoom() {
        return roomService.findEmptyRoom();
    }

    /**
     * 办理入住操作
     *
     * @param rid   房间对应的id
     * @param phone 客户手机号
     * @return 一个反馈视图
     */
    @GetMapping( "/inRoom/{rid}/{phone}" )
    public RoomVO inRoom(@PathVariable Integer rid, @PathVariable String phone) {
        return roomService.inRoom(rid, phone);
    }

    /**
     * 办理离店手续
     *
     * @param rid    房间对应的id
     * @param price3 退还的押金
     * @return 一个反馈视图
     */
    @GetMapping( "/outRoom/{rid}/{price3}/{eid}" )
    public RoomVO outRoom(@PathVariable Integer rid, @PathVariable BigDecimal price3, @PathVariable Integer eid) {
        return roomService.outRoom(rid, price3, eid);
    }

    @GetMapping( "/insertNewRoom" )
    public InsertVO insertNewRoom(@RequestBody Room room) {
        return roomService.insertNewRoom(room);
    }
}

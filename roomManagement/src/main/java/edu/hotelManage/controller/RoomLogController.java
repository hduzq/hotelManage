package edu.hotelManage.controller;

import edu.hotelManage.entity.RoomLog;
import edu.hotelManage.repository.RoomLogRepository;
import edu.hotelManage.service.RoomLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "/roomLog" )
public class RoomLogController {
    @Autowired
    private RoomLogService roomLogService;

    @GetMapping( "/findAll" )
    public List<RoomLog> findAll() {
        return roomLogService.findAll();
    }

    /**
     * 本功能面向管理者:
     * 1.每天生成一份日志，包括各个时间房间入住情况以及对应的旅客信息情况。
     * 2. 按照房间，每个房间每天生成一份日志，包括该房间近期的入住情况。
     */
    @GetMapping( "/findByInTime/{inTime}" )
    public List<RoomLog> findByInTime(@PathVariable String inTime) {
        return roomLogService.findByInTime(inTime);
    }

    @GetMapping( "/findByOutTime/{outTime}" )
    public List<RoomLog> findByOutTime(@PathVariable String outTime) {
        return roomLogService.findByOutTime(outTime);
    }

    @GetMapping( "/findByRid/{rid}" )
    public List<RoomLog> findByRid(@PathVariable Integer rid) {
        return roomLogService.findByRid(rid);
    }
}

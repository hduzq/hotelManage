package edu.hotelManage.controller;

import edu.hotelManage.entity.SuppliesInLog;
import edu.hotelManage.service.SuppliesInLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "/suppliesInLog" )
public class SuppliesInLogController {
    @Autowired
    private SuppliesInLogService suppliesInLogService;

    @GetMapping( "/findAll" )
    public List<SuppliesInLog> findAll() {
        return suppliesInLogService.findAll();
    }

    @GetMapping( "/findBySid/{sid}" )
    public List<SuppliesInLog> findBySid(@PathVariable Integer sid) {
        return suppliesInLogService.findBySid(sid);
    }

    @GetMapping( "/findByTime/{time}" )
    public List<SuppliesInLog> findByTime(@PathVariable String time) {
        return suppliesInLogService.findByTime(time);
    }

    @GetMapping( "/findByTimeAndSid/{time}/{sid}" )
    public List<SuppliesInLog> findByTimeAndSid(@PathVariable String time, @PathVariable Integer sid) {
        return suppliesInLogService.findByTimeAndSid(time, sid);
    }
}

package edu.hotelManage.controller;

import edu.hotelManage.VO.SuppliesLogNamedVO;
import edu.hotelManage.entity.SuppliesLog;
import edu.hotelManage.service.SuppliesLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 销售日志
 */
@RestController
@RequestMapping( "/suppliesLog" )
public class SuppliesLogController {
    @Autowired
    private SuppliesLogService suppliesLogService;

    @GetMapping( "/findAll" )
    public List<SuppliesLog> findAll() {
        return suppliesLogService.findAll();
    }

    @GetMapping( "/findByName/{name}" )
    public SuppliesLogNamedVO findByName(@PathVariable String name) {
        return suppliesLogService.findByName(name);
    }

    @GetMapping( "/findByTime/{time}" )
    public List<SuppliesLog> findByTime(@PathVariable String time) {
        return suppliesLogService.findByTime(time);
    }

    @GetMapping( "/findBySid/{sid}" )
    public List<SuppliesLog> findBySid(@PathVariable Integer sid) {
        return suppliesLogService.findBySId(sid);
    }

    @GetMapping( "/findByTimeAndSid/{time}/{sid}" )
    public List<SuppliesLog> findByTimeAndSid(@PathVariable String time, @PathVariable Integer sid) {
        return suppliesLogService.findByTimeAndSid(time, sid);
    }
}

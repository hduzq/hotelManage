package edu.hotelManage.controller;

import edu.hotelManage.VO.SuppliesLogNamedVO;
import edu.hotelManage.service.SuppliesLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/suppliesLog" )
public class SuppliesLogController {
    @Autowired
    private SuppliesLogService suppliesLogService;

    @GetMapping( "/findByName/{name}" )
    public SuppliesLogNamedVO findByName(@PathVariable String name) {
        return suppliesLogService.findByName(name);
    }
}

package edu.hotelManage.controller;

import edu.hotelManage.VO.RoomTypeVO;
import edu.hotelManage.VO.UpdatePriceVO;
import edu.hotelManage.entity.RoomType;
import edu.hotelManage.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping( "/roomType" )
public class RoomTypeController {
    @Autowired
    private RoomTypeService roomTypeService;

    @GetMapping( "/findAll" )
    public List<RoomType> findAll() {
        return roomTypeService.findAll();
    }

    /**
     * 本功能面向管理者（不支持议价）：
     * 1.	修改房间钟点房价格
     * 2.	修改房间包天价格
     */
    @GetMapping( "/updatePrice1/{type}/{price1}" )
    public UpdatePriceVO updatePrice1(@PathVariable Integer type, @PathVariable BigDecimal price1) {
        return roomTypeService.updatePrice1(type, price1);
    }

    @GetMapping( "/updatePrice2/{type}/{price2}" )
    UpdatePriceVO updatePrice2(@PathVariable Integer type, @PathVariable BigDecimal price2) {
        return roomTypeService.updatePrice2(type, price2);
    }

    @GetMapping( "/updateRoomType" )
    public RoomTypeVO updateRoomType(@RequestBody RoomType roomType) {
        return roomTypeService.updateRoomType(roomType);
    }

    @GetMapping( "/addRoomType" )
    public RoomTypeVO addRoomType(@RequestBody RoomType roomType) {
        return roomTypeService.addRoomType(roomType);
    }
}

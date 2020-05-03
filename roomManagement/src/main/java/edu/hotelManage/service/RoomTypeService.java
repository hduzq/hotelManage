package edu.hotelManage.service;

import edu.hotelManage.entity.RoomType;

import java.math.BigDecimal;
import java.util.List;

public interface RoomTypeService {
    List<RoomType> findAll();

    /**
     * 本功能面向管理者（不支持议价）：
     * 1.	修改房间钟点房价格
     * 2.	修改房间包天价格
     */
    void updatePrice1(Integer type, BigDecimal price1);//type是房间类型 price1 是钟点价格

    void updatePrice2(Integer type, BigDecimal price2);//price2是房间全天价格
}

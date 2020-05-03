package edu.hotelManage.service;

import edu.hotelManage.entity.Room;
import edu.hotelManage.entity.RoomType;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface RoomService {
    List<Room> findAll();

    /**
     * 1.	显示当前空房
     * 2.	预设某段时间某房间不可用
     * 3.	设置某房间不可用
     * 4.	提前结束某房间的不可用状态
     * 5.	查看所有房间信息
     * 6.	增加新的房间信息(主要面向初次使用系统)
     */
    void findEmptyRoom();

    void inRoom(Integer rid, String phone);

    void outRoom(BigDecimal price3);//离开房间时退还的押金

    void insertNewRoom(Room room);//增加新房间

}

package edu.hotelManage.service.impl;

import edu.hotelManage.entity.Room;

import java.util.List;

/**
 * 在不启动SpringBoot服务时不可用
 */
public class Test {
    public static void main(String[] args) {
        RoomServiceImpl roomService = new RoomServiceImpl();
        List<Room> roomList = roomService.findAll();
        for (Room room :
                roomList) {
            System.out.println(room);
        }
    }
}

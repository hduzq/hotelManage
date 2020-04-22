package edu.hotelManage.service;

import edu.hotelManage.entity.Room;
import edu.hotelManage.entity.RoomType;

import java.util.Date;
import java.util.List;

public interface RoomService {
    List<Room> findAll();
    List<Room> findAllEmptyRoom();
    boolean disableRoom(Long id);
    boolean enableRoom(Long id);
    boolean disableRoomWithDate(Date start, Date end);
    boolean addRoomType(RoomType roomType);
}

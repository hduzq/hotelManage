package edu.hotelManage.service.impl;

import edu.hotelManage.entity.Room;
import edu.hotelManage.entity.RoomType;
import edu.hotelManage.repository.RoomMapper;
import edu.hotelManage.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public List<Room> findAll() {
        return roomMapper.findAll();
    }

    @Override
    public List<Room> findAllEmptyRoom() {
        return roomMapper.findAllEmptyRoom();
    }

    @Override
    public boolean disableRoom(Long id) {
        return roomMapper.disableRoom(id);
    }

    @Override
    public boolean enableRoom(Long id) {
        return roomMapper.enableRoom(id);
    }

    @Override
    public boolean disableRoomWithDate(Date start, Date end) {
        return roomMapper.disableRoomWithDate(start,end);
    }

    @Override
    public boolean addRoomType(RoomType roomType) {
        return roomMapper.addRoomType(roomType);
    }

}

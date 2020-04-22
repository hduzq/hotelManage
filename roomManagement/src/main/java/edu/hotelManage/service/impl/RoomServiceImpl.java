package edu.hotelManage.service.impl;

import edu.hotelManage.entity.Room;
import edu.hotelManage.repository.RoomMapper;
import edu.hotelManage.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public List<Room> findAll() {
        return roomMapper.findAll();
    }
}

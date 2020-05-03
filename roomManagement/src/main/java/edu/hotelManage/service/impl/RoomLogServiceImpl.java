package edu.hotelManage.service.impl;

import edu.hotelManage.entity.RoomLog;
import edu.hotelManage.repository.RoomLogRepository;
import edu.hotelManage.service.RoomLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomLogServiceImpl implements RoomLogService {
    @Autowired
    private RoomLogRepository roomLogRepository;

    @Override
    public List<RoomLog> findAll() {
        return roomLogRepository.findAll();
    }

    @Override
    public List<RoomLog> findByInTime(String inTime) {
        return roomLogRepository.findByInTime(inTime);
    }

    @Override
    public List<RoomLog> findByOutTime(String outTime) {
        return roomLogRepository.findByOutTime(outTime);
    }

    @Override
    public List<RoomLog> findByRid(Integer rid) {
        return roomLogRepository.findByRid(rid);
    }
}

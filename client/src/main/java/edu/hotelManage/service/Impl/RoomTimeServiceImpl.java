package edu.hotelManage.service.Impl;

import edu.hotelManage.entity.RoomTime;
import edu.hotelManage.repository.RoomTimeRepository;
import edu.hotelManage.service.RoomTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTimeServiceImpl implements RoomTimeService {
    @Autowired
    private RoomTimeRepository roomTimeRepository;

    @Override
    public List<RoomTime> findAll() {
        return roomTimeRepository.findAll();
    }

    @Override
    public List<RoomTime> findAllNeed() {
        return roomTimeRepository.findAllNeed();
    }

    /**
     * 打开叫醒服务
     *
     * @param rid  房间对应编号
     * @param time 需要叫醒的时刻
     * @return
     */
    @Override
    public int updateOn(Integer rid, String time) {
        RoomTime roomTime = new RoomTime();
        roomTime.setRid(rid);
        roomTime.setTime(time);
        roomTime.setPass(0);
        return roomTimeRepository.update(roomTime);
    }

    /**
     * 关闭叫醒服务
     *
     * @param rid 房间对应编号
     * @return
     */
    @Override
    public int updateOff(Integer rid) {
        RoomTime roomTime = roomTimeRepository.findByRid(rid);
        roomTime.setPass(1);
        return roomTimeRepository.update(roomTime);
    }
}

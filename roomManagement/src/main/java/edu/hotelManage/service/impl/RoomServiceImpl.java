package edu.hotelManage.service.impl;

import edu.hotelManage.VO.InsertVO;
import edu.hotelManage.VO.RoomVO;
import edu.hotelManage.entity.Room;
import edu.hotelManage.entity.RoomLog;
import edu.hotelManage.entity.RoomType;
import edu.hotelManage.repository.RoomLogRepository;
import edu.hotelManage.repository.RoomMapper;
import edu.hotelManage.repository.RoomTypeRepository;
import edu.hotelManage.service.RoomService;
import edu.hotelManage.util.CalendarUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private RoomTypeRepository roomTypeRepository;
    @Autowired
    private RoomLogRepository roomLogRepository;

    @Override
    public List<Room> findAll() {
        return roomMapper.findAll();
    }

    @Override
    public List<Room> findEmptyRoom() {
        return roomMapper.findByState(0);
    }

    @Override
    public RoomVO inRoom(Integer rid, String phone) {
        RoomVO roomVO = new RoomVO();
        Room room = roomMapper.findById(rid);
        String inTime = CalendarUtil.createNow();
        if (room.getState() == 0) {//如果房间为空
            room.setState(1);   //设置入住状态
            room.setPhone(phone);
            room.setInTime(inTime);
            roomMapper.update(room);
            /**
             * 设置视图的押金信息
             */
            Integer type = room.getType();
            RoomType roomType = roomTypeRepository.findById(type);
            roomVO.setPrice3(roomType.getPrice3());
            /**
             * 处理日志相关操作
             * 插入一条入住信息
             * 入住时room表中就有记录 仅需在离店时 插入日志
             */

        } else {
            roomVO.setCode(1);
            roomVO.setMsg("当前房间已有人 不能入住此房间");
        }
        return roomVO;
    }

    @Override
    public RoomVO outRoom(Integer rid, BigDecimal price3, Integer eid) {
        RoomVO roomVO = new RoomVO();
        Room room = roomMapper.findById(rid);
        String outTime = CalendarUtil.createNow();//离店时间 退房时间
        if (room.getState() == 1) {//如果房间有人说明可以退房
            room.setState(0);
            room.setOutTime(outTime);
            String phone = room.getPhone();//将用户手机号取出
            room.setPhone(null);
            roomMapper.update(room);
            /**
             *
             */
            Integer type = room.getType();
            String inTime = room.getInTime();
            RoomType roomType = roomTypeRepository.findById(type);
            BigDecimal price2 = roomType.getPrice2();
            Long days = CalendarUtil.compareTwoDay(inTime, outTime);

            RoomLog roomLog = new RoomLog();
            roomLog.setRid(rid);
            roomLog.setPhone(phone);
            roomLog.setInTime(inTime);
            roomLog.setOutTime(outTime);
            roomLog.setEid(eid);
            if (days > 0) {
                BigDecimal daysTemp = new BigDecimal(days);
                BigDecimal income = price2.multiply(daysTemp);
                BigDecimal price3AC = roomType.getPrice3().subtract(price3);//实际赚取的押金
                income = income.add(price3AC);
                roomLog.setIncome(income);
                roomLogRepository.insert(roomLog);
            } else {
                //设置收益income为钟点房的收益
                BigDecimal income = roomType.getPrice1();
                BigDecimal price3AC = roomType.getPrice3().subtract(price3);//实际赚取的押金
                income = income.add(price3AC);
                roomLog.setIncome(income);
                roomLogRepository.insert(roomLog);
            }
            roomVO.setPrice3(price3);
        } else {
            roomVO.setPrice3(null);
            roomVO.setMsg("房间无人 退房操作失败");
            roomVO.setCode(1);
        }
        return roomVO;
    }

    @Override
    public InsertVO insertNewRoom(Room room) {
        InsertVO insertVO = new InsertVO();
        Integer type = room.getType();

        if (roomMapper.insert(room) != 1 || roomTypeRepository.findById(type) == null) {
            insertVO.setCode(1);
            insertVO.setMsg("操作失败");
        } else {
            insertVO.setRid(room.getId());
            insertVO.setType(room.getType());
        }
        return insertVO;
    }
}

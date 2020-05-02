package edu.hotelManage.service;

import edu.hotelManage.entity.RoomTime;

import java.util.List;

public interface RoomTimeService {
    /**
     * 显示所有room_time表
     *
     * @return
     */
    List<RoomTime> findAll();

    /**
     * 选择pass为0 还未被叫醒的房间
     *
     * @return
     */
    List<RoomTime> findAllNeed();

    /**
     * 选择叫醒服务功能
     *
     * @param rid  房间对应编号
     * @param time 需要叫醒的时刻
     * @return 0表示失败 1表示成功
     */
    int updateOn(Integer rid, String time);

    /**
     * 取消叫醒服务
     *
     * @param rid 房间对应编号
     * @return 0表示失败 1表示成功
     */
    int updateOff(Integer rid);
}

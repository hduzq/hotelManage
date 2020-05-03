package edu.hotelManage.service;

import edu.hotelManage.entity.RoomLog;

import java.util.List;

public interface RoomLogService {
    List<RoomLog> findAll();

    /**
     * 本功能面向管理者:
     * 1.每天生成一份日志，包括各个时间房间入住情况以及对应的旅客信息情况。
     * 2. 按照房间，每个房间每天生成一份日志，包括该房间近期的入住情况。
     */
    void findByInTime(String inTime);

    void findByOutTime(String outTime);

    void findByRid(Integer rid);
}

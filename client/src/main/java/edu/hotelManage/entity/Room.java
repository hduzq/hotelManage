package edu.hotelManage.entity;

import lombok.Data;

@Data
public class Room {
    /**
     * 房间id 房间编号
     */
    private Integer id;
    /**
     * 房间类型id 与room_type表的id进行关联
     */
    private Integer type;
    /**
     * 房间当前状态 state 1表示空房
     * 2表示当前有人入住
     */
    private short state;
    /**
     * 入住该房间入住时间
     */
    private String inTime;
    /**
     * 该房间顾客理论退出时间
     */
    private String outTime;
    /**
     * 对应的房间类型
     */
    private RoomType roomType;
}

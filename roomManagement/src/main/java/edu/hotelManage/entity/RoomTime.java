package edu.hotelManage.entity;

import lombok.Data;

@Data
public class RoomTime {
    /**
     * 需要叫醒服务的房间id
     */
    private Integer rid;
    /**
     * 需要叫醒服务的时间
     */
    private String time;
    /**
     * 是否已经叫醒 0表示未进行叫醒
     * 1表示已经叫醒
     */
    private Integer pass;
}

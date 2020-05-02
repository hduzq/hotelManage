package edu.hotelManage.entity;

import lombok.Data;

@Data
public class RoomLog {
    /**
     * 日志的id
     */
    private Integer id;
    /**
     * 该条日志对应的房间id
     */
    private Integer rid;
    /**
     * 房客入住的时间
     */
    private String inTime;
    /**
     * 房客退房离店的时间
     */
    private String outTime;
    /**
     * 该条日志入住的客户姓名
     */
    private String cname;
    /**
     * 该条日志客户的联系方式
     */
    private String phone;
    /**
     * 房间带来的收益
     */
    private Integer income;
    /**
     * 这条入住信息由哪一个员工负责
     * eg: rid 1  eid 5
     * 五号 员工负责服务 一号 房间
     */
    private Integer eid;
}

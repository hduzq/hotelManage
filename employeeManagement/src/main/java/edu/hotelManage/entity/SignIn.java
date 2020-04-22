package edu.hotelManage.entity;

import lombok.Data;

@Data
public class SignIn {
    private Integer id;
    /**
     * 签到表对应员工编号
     */
    private Integer eid;
    /**
     * 签到时间
     */
    private String time;
}

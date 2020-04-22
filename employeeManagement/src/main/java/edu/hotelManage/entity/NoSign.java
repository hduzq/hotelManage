package edu.hotelManage.entity;

import lombok.Data;

@Data
public class NoSign {
    private Integer id;
    /**
     * 未签到表中员工的编号
     */
    private Integer eid;
    /**
     * 未签到理由
     */
    private String reason;
    /**
     * 未签到或请假的时间
     */
    private String time;
    /**
     * 请假或未出勤时间
     */
    private Integer day;
    /**
     * 管理者意见
     */
    private String opinion;
    /**
     * 管理者是否已经阅读该条记录
     */
    private short pass;
}

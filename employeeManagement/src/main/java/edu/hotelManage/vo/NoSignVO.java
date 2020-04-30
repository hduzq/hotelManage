package edu.hotelManage.vo;

import lombok.Data;

/**
 * 请假 视图 反馈 VO
 */
@Data
public class NoSignVO {
    private String msg = "申请已发出";
    private Integer eid;
    private String name;
    /**
     * 请假的天数
     */
    private Integer day;
    /**
     * 需要请假的开始时间
     */
    private String time;

    private String reason;
}

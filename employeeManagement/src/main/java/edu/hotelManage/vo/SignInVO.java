package edu.hotelManage.vo;

import lombok.Data;

/**
 * 签到反馈VO表
 */
@Data
public class SignInVO {
    private int code = 0;
    private String msg = "签到成功";
    /**
     * Employee实体类对应的eid
     */
    private Integer eid;
    /**
     * Employee实体类对应的名称
     */
    private String name;
}

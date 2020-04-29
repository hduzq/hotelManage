package edu.hotelManage.entity;

import lombok.Data;

@Data
public class FeedBack {
    private Integer id;
    private Integer eid;
    private Integer rid;
    private String comment;
    /**
     * 管理者对这个房间的答复意见
     */
    private String opinion;
    private Integer pass;
    private String phone;
    private String time;
}

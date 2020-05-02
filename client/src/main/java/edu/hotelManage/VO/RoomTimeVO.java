package edu.hotelManage.VO;

import lombok.Data;

@Data
public class RoomTimeVO {
    private Integer code = 0;
    private String msg = "操作成功";
    private Integer rid;
    private String time;
}

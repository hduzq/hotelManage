package edu.hotelManage.VO;

import lombok.Data;

@Data
public class InsertVO {
    private Integer code = 0;
    private String msg = "操作成功";
    private Integer rid;//插入的房间id
    private Integer type;//插入的房间类型id
}

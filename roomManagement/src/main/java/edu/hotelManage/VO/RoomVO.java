package edu.hotelManage.VO;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 办理入住和离店反馈信息类
 */
@Data
public class RoomVO {
    private Integer code = 0;
    private String msg = "操作成功";
    private BigDecimal price3;//押金
}

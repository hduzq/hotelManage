package edu.hotelManage.VO;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 更新价格反馈视图
 */
@Data
public class UpdatePriceVO {
    private Integer code = 0;
    private Integer type;
    private String msg = "操作成功 更改后的价格如下";
    private BigDecimal price1;
    private BigDecimal price2;
}

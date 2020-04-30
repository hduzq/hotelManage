package edu.hotelManage.VO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdatePriceVO {
    private Integer code = 0;
    private String msg = "修改价格成功 进价price1 售价price2";
    /**
     * 进价
     */
    private BigDecimal price1;
    /**
     * 售价
     */
    private BigDecimal price2;
}

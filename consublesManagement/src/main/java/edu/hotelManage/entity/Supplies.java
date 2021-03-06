package edu.hotelManage.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Supplies {
    private Integer id;

    private String name;

    private Integer quantity;

    /**
     * 进价
     */
    private BigDecimal price1;
    /**
     * 售价
     */
    private BigDecimal price2;


}

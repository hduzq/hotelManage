package edu.hotelManage.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RoomType {
    /**
     * 类型id编号
     */
    private Integer id;
    /**
     * 房间类型的文字描述
     */

    private Integer nums;
    /**
     * 该类型房间总数
     * Add By iYmz
     */


    private String roomType;
    /**
     * 房间类型简介 abstract 缩写abstr
     */
    private String abstr;
    /**
     * 该类房间钟点房价格
     */
    private BigDecimal price1;
    /**
     * 该类房间一天的价格
     */
    private BigDecimal price2;
    /**
     * 该类房间的押金价格
     */
    private BigDecimal price3;
}

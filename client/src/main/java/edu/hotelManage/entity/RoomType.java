package edu.hotelManage.entity;

import lombok.Data;

/**
 * 从这里开始完善
 */
@Data
public class RoomType {
    /**
     * 类型id编号
     */
    private Integer id;
    /**
     * 房间类型的文字描述
     */
    private String roomType;
    /**
     * 房间类型简介 abstract 缩写abstr
     */
    private String abstr;
    /**
     * 该类房间钟点房价格
     */
    private Integer price1;
    /**
     * 该类房间一天的价格
     */
    private Integer price2;
    /**
     * 该类房间的押金价格
     */
    private Integer price3;
}
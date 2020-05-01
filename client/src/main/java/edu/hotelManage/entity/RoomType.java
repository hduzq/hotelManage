package edu.hotelManage.entity;

import lombok.Data;

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
     *
     * @AddBy iYmz
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getAbstr() {
        return abstr;
    }

    public void setAbstr(String abstr) {
        this.abstr = abstr;
    }

    public Integer getPrice1() {
        return price1;
    }

    public void setPrice1(Integer price1) {
        this.price1 = price1;
    }

    public Integer getPrice2() {
        return price2;
    }

    public void setPrice2(Integer price2) {
        this.price2 = price2;
    }

    public Integer getPrice3() {
        return price3;
    }

    public void setPrice3(Integer price3) {
        this.price3 = price3;
    }

    public RoomType() {
    }

    public RoomType(Integer id, Integer nums, String roomType, String abstr, Integer price1, Integer price2, Integer price3) {
        this.id = id;
        this.nums = nums;
        this.roomType = roomType;
        this.abstr = abstr;
        this.price1 = price1;
        this.price2 = price2;
        this.price3 = price3;
    }
}

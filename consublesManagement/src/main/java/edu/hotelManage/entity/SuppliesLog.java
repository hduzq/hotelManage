package edu.hotelManage.entity;

import lombok.Data;


import java.util.Date;

@Data
public class SuppliesLog {
    private Integer id;

    private Integer sid;

    private Integer quantity;

    private Date time;


}

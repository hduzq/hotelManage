package edu.hotelManage.VO;

import edu.hotelManage.entity.RoomType;
import lombok.Data;

@Data
public class RoomTypeVO {
    private Integer code = 0;
    private String msg = "操作成功";
    private RoomType roomType;
}

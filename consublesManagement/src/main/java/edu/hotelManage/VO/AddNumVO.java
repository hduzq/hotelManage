package edu.hotelManage.VO;

import lombok.Data;

/**
 * 增加某商品数量的反馈 VO
 */
@Data
public class AddNumVO {
    private Integer code = 0;
    private String msg = "添加数量成功 添加后的数量如下:";
    private Integer id;
    /**
     * 消耗品名称
     */
    private String name;
    private Integer quantity;
}

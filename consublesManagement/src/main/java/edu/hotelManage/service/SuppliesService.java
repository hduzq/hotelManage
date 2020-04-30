package edu.hotelManage.service;

import edu.hotelManage.VO.AddNumVO;
import edu.hotelManage.VO.AddSuppliesVO;
import edu.hotelManage.VO.SuppliesVO;
import edu.hotelManage.VO.UpdatePriceVO;
import edu.hotelManage.entity.Supplies;

import java.math.BigDecimal;
import java.util.List;

public interface SuppliesService {
    /**
     * 已经包含了存量
     *
     * @return
     */
    List<Supplies> findAll();

    /**
     * @param id 消耗品对应id
     * @return 返回该消耗品情况
     */
    Supplies findById(Integer id);

    /**
     * 增加消耗品 种类
     *
     * @param supplies 要添加的消耗品
     * @return 返回一个添加信息
     */
    AddSuppliesVO addSupplies(Supplies supplies);

    /**
     * 给某种消耗品 增加 add 数量
     *
     * @param id       消耗品对应id
     * @param quantity 增加的数量
     * @return AddNumVO
     */
    AddNumVO addNum(Integer id, Integer quantity);

    /**
     * @param id     消耗品对应id
     * @param price1 修改后的进价价格
     * @return
     */
    UpdatePriceVO updatePrice1(Integer id, BigDecimal price1);

    /**
     * @param id     消耗品对应id
     * @param price2 修改后的售价价格
     * @return
     */
    UpdatePriceVO updatePrice2(Integer id, BigDecimal price2);

}

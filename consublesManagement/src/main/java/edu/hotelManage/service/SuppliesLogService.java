package edu.hotelManage.service;

import edu.hotelManage.VO.SuppliesLogNamedVO;
import edu.hotelManage.entity.SuppliesLog;

import java.util.List;

public interface SuppliesLogService {
    /**
     * 销售日志  查询所有消耗日志
     *
     * @return
     */
    List<SuppliesLog> findAll();

    /**
     * 根据时间查询消耗日志
     *
     * @param time
     * @return
     */
    List<SuppliesLog> findByTime(String time);

    /**
     * 根据消耗品的id 查询记录
     *
     * @param sid
     * @return
     */
    List<SuppliesLog> findBySId(Integer sid);

    /**
     * 根据消耗品名称查询消耗日志
     *
     * @param name
     * @return
     */
    SuppliesLogNamedVO findByName(String name);

    /**
     * 根据时间和名称查看 消耗品日志
     *
     * @param time
     * @param sid
     * @return
     */
    List<SuppliesLog> findByTimeAndSid(String time, Integer sid);

}

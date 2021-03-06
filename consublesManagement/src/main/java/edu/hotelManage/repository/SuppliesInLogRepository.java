package edu.hotelManage.repository;


import edu.hotelManage.entity.Supplies;
import edu.hotelManage.entity.SuppliesInLog;
import edu.hotelManage.entity.SuppliesLog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuppliesInLogRepository {
    /**
     * 查询所有进货记录
     *
     * @return List<SuppliesInLog>
     */
    List<SuppliesInLog> findAll();

    /**
     * 根据类型查询进货日志
     *
     * @param sid
     * @return List<SuppliesInLog> 订单列表
     */
    List<SuppliesInLog> findBySid(Integer sid);

    List<SuppliesInLog> findByTime(String time);

    List<SuppliesInLog> findByTimeAndSid(String time, Integer sid);

    /**
     * 插入一条进货记录
     *
     * @param suppliesInLog 类型
     * @return 返回1表示成功插入
     */
    int insert(SuppliesInLog suppliesInLog);

    /**
     * 更新进货记录
     *
     * @param suppliesInLog
     * @return 返回更新的行数
     */
    int update(SuppliesInLog suppliesInLog);

}

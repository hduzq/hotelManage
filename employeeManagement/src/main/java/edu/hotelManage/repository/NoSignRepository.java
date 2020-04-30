package edu.hotelManage.repository;

import edu.hotelManage.entity.NoSign;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoSignRepository {
    /**
     * @return 返回所有未签到的表格
     */
    List<NoSign> findAll();

    /**
     * @param eid
     * @return 返回eid对应的员工未签到信息
     */
    List<NoSign> findByEid(Integer eid);

    /**
     * 返回某天请假信息
     *
     * @param time yyyy-MM-dd
     * @return 返回请假/未签到的信息
     */
    List<NoSign> findByTime(String time);

    /**
     * 根据假条id返回请假信息
     *
     * @param id
     * @return 返回NoSign信息
     */
    NoSign findById(Integer id);

    /**
     * 插入一条NoSign信息
     *
     * @param noSign
     * @return 返回插入影响行数
     */
    int insert(NoSign noSign);

    /**
     * 更新请假原因等
     *
     * @param noSign
     * @return 返回更新的行数
     */
    int update(NoSign noSign);

    /**
     * 根据 假条id 删除某条请假记录
     *
     * @param id
     * @return 注意不是删除某个员工的请假信息
     */
    int delete(Integer id);
}

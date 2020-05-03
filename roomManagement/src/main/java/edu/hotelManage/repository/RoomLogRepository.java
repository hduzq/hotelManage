package edu.hotelManage.repository;

import edu.hotelManage.entity.Room;
import edu.hotelManage.entity.RoomLog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomLogRepository {
    List<RoomLog> findAll();

    RoomLog findById(Integer id);

    /**
     * 根据房间id查询房间日志
     *
     * @param rid 房间对应的rid 那个房间
     * @return
     */
    List<RoomLog> findByRid(Integer rid);

    List<RoomLog> findByInTime(String inTime);

    List<RoomLog> findByOutTime(String outTime);

    /**
     * 根据客户名称查询房间日志
     *
     * @param cname 客户名称
     * @return
     */
    List<RoomLog> findByCname(String cname);

    /**
     * 根据客户手机号查询客房日志
     *
     * @param phone
     * @return
     */
    List<RoomLog> findByPhone(String phone);

    /**
     * 根据员工eid查询 房间日志
     *
     * @param eid
     * @return
     */
    List<RoomLog> findByEid(Integer eid);

    int insert(RoomLog roomLog);

    int update(RoomLog roomLog);
}

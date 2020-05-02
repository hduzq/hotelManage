package edu.hotelManage.repository;

import edu.hotelManage.entity.RoomTime;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomTimeRepository {
    List<RoomTime> findAll();

    RoomTime findByRid(Integer rid);

    /**
     * 选择出所有未被叫醒的房间
     *
     * @return
     */
    List<RoomTime> findAllNeed();

    int update(RoomTime roomTime);
}

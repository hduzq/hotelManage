package edu.hotelManage.repository;

import edu.hotelManage.entity.RoomType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomTypeRepository {
    List<RoomType> findAll();

    /**
     * @param id 房间类型对应的id
     * @return
     */
    RoomType findById(Integer id);

    int update(RoomType roomType);

    int insert(RoomType roomType);
}

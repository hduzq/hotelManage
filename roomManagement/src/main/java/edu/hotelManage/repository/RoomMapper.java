package edu.hotelManage.repository;

import edu.hotelManage.entity.Room;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RoomMapper {
    List<Room> findAll();

    Room findById(Integer id);

    List<Room> findByState(Integer state);

    List<Room> findByType(Integer type);

    List<Room> findByStateAndType(Integer state, Integer type);

    /**
     * 通用更新
     *
     * @param room 房间类
     * @return 返回1表示更新成功
     */
    int update(Room room);

    /**
     * 插入房间增加房间信息 (几乎不用)
     *
     * @param room
     * @return
     */
    int insert(Room room);
}

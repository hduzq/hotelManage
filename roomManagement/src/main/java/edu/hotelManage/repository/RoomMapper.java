package edu.hotelManage.repository;

import edu.hotelManage.entity.Room;
import edu.hotelManage.entity.RoomType;
import org.springframework.stereotype.Repository;


import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Repository
public interface RoomMapper {
    List<Room> findAll();
    List<Room> findAllEmptyRoom();
    boolean disableRoom(Long id);
    boolean enableRoom(Long id);
    boolean disableRoomWithDate(Date start, Date end);
    boolean addRoomType(RoomType roomType);

}

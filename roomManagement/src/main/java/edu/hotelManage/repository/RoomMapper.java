package edu.hotelManage.repository;

import edu.hotelManage.entity.Room;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface RoomMapper {
    List<Room> findAll();

}

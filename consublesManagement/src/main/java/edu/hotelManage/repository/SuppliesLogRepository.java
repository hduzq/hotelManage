package edu.hotelManage.repository;

import edu.hotelManage.entity.SuppliesLog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuppliesLogRepository {
    List<SuppliesLog> findAll();

    List<SuppliesLog> findBySid(Integer sid);

    List<SuppliesLog> findByTime(String time);

    List<SuppliesLog> findByTimeAndSid(String time, Integer sid);

    SuppliesLog findById(Integer id);

    int insert(SuppliesLog suppliesLog);

    int update(SuppliesLog suppliesLog);
}

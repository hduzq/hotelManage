package edu.hotelManage.service;

import edu.hotelManage.entity.SuppliesInLog;

import java.util.List;

public interface SuppliesInLogService {

    List<SuppliesInLog> findAll();

    List<SuppliesInLog> findBySid(Integer sid);

    List<SuppliesInLog> findByTime(String time);

    List<SuppliesInLog> findByTimeAndSid(String time, Integer sid);
}

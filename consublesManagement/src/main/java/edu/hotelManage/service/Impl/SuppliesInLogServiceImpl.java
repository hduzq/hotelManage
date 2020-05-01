package edu.hotelManage.service.Impl;

import edu.hotelManage.entity.SuppliesInLog;
import edu.hotelManage.repository.SuppliesInLogRepository;
import edu.hotelManage.service.SuppliesInLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuppliesInLogServiceImpl implements SuppliesInLogService {
    @Autowired
    private SuppliesInLogRepository suppliesInLogRepository;

    @Override
    public List<SuppliesInLog> findAll() {
        return suppliesInLogRepository.findAll();
    }

    @Override
    public List<SuppliesInLog> findBySid(Integer sid) {
        return suppliesInLogRepository.findBySid(sid);
    }

    @Override
    public List<SuppliesInLog> findByTime(String time) {
        return suppliesInLogRepository.findByTime(time);
    }

    @Override
    public List<SuppliesInLog> findByTimeAndSid(String time, Integer sid) {
        return suppliesInLogRepository.findByTimeAndSid(time, sid);
    }
}

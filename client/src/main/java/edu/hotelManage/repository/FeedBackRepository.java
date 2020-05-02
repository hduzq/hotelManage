package edu.hotelManage.repository;

import edu.hotelManage.entity.FeedBack;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedBackRepository {
    List<FeedBack> findAll();

    FeedBack findById(Integer id);

    List<FeedBack> findByEid(Integer eid);

    List<FeedBack> findByRid(Integer rid);

    List<FeedBack> findByPhone(String phone);

    List<FeedBack> findByPhoneAndTime(String phone, String time);

    List<FeedBack> findByTime(String time);

    int insert(FeedBack feedBack);

    int update(FeedBack feedBack);
}

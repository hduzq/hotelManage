package edu.hotelManage.service;

import edu.hotelManage.entity.NoSign;
import edu.hotelManage.vo.NoSignVO;

import java.util.List;

public interface NoSignService {
    NoSignVO doNoSign(Integer eid, Integer day, String reason, String time);

    /**
     * 查询自己的请假记录
     */
    List<NoSign> findNoSignListByEid(Integer eid);

    /**
     * 查询所有员工请假记录
     */
    List<NoSign> findAll();

    /**
     * 管理者对请假信息给出评价意见
     */
    void doOpinion(NoSign noSign);
}

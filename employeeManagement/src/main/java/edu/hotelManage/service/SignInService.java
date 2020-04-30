package edu.hotelManage.service;

import edu.hotelManage.vo.SignInVO;
import edu.hotelManage.vo.SignVO;


/**
 * 签到接口服务类
 */
public interface SignInService {
    /**
     * 查询eid对应的考勤情况
     *
     * @param eid 员工id
     * @return 签到视图
     */
    SignVO findByEid(Integer eid);

    /**
     * @param time yyyy-MM-dd
     * @return 根据签到时间返回某天的签到情况
     */
    SignVO findByTime(String time);

    /**
     * 员工完成签到
     *
     * @param eid 员工对应id
     * @return 返回签到反馈VO表
     */
    SignInVO doSign(Integer eid);


}

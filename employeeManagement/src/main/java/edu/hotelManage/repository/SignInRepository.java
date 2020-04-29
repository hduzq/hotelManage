package edu.hotelManage.repository;

import edu.hotelManage.entity.SignIn;

import java.util.List;

public interface SignInRepository {
    List<SignIn> findAll();

    /**
     * 根据员工id查询签到信息
     *
     * @param eid 员工id
     * @return 返回eid员工对应的签到信息
     */
    List<SignIn> findByEid(Integer eid);

    /**
     * 根据签到时间查询签到信息
     *
     * @param time 签到时间 ‘yyyy-MM-dd ’根据某一天
     * @return 返回某一天的请假记录
     */
    List<SignIn> findByTime(String time);

    /**
     * 根据签到id返回签到记录
     *
     * @param id 签到id
     * @return 返回一条签到信息
     */
    SignIn findById(Integer id);

    /**
     * @param signIn 插入的信息
     * @return 返回受影响行数
     */
    int insert(SignIn signIn);

    /**
     * @param signIn 更新的信息
     * @return 返回受影响的行数
     */
    int update(SignIn signIn);

}

package edu.hotelManage.service;

import edu.hotelManage.VO.CommentVO;
import edu.hotelManage.entity.FeedBack;

import java.util.List;

public interface FeedBackService {
    /**
     * 1.	顾客给某个房间写出反馈信息
     * 2.	顾客给某个员工写出意见
     * 3.	员工查看顾客意见
     * 4.	管理者查看顾客给出的意见反馈
     */
    /**
     * @param rid     房间id
     * @param comment 对该房间的评价
     * @param phone   添加提交评论的联系方式
     * @return 是否成功的VO
     */
    CommentVO addCommentToRoom(Integer rid, String comment, String phone);

    CommentVO addCommentToEid(Integer eid, String comment, String phone);

    /**
     * 查询所有意见表
     *
     * @return
     */
    List<FeedBack> findAll();

    FeedBack findById(Integer id);

    List<FeedBack> findByEid(Integer eid);

    List<FeedBack> findByRid(Integer rid);

    List<FeedBack> findByPhone(String phone);

    List<FeedBack> findByTime(String time);

    List<FeedBack> findByPhoneAndTime(String phone, String time);

    /**
     * 管理者写出评论
     *
     * @param id      评论记录的id
     * @param opinion 需要填写的意见
     * @return
     */
    CommentVO doOpinion(Integer id, String opinion);
}

package edu.hotelManage.service.Impl;

import edu.hotelManage.VO.CommentVO;
import edu.hotelManage.entity.FeedBack;
import edu.hotelManage.repository.FeedBackRepository;
import edu.hotelManage.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedBackServiceImpl implements FeedBackService {
    @Autowired
    private FeedBackRepository feedBackRepository;

    @Override
    public CommentVO addCommentToRoom(Integer rid, String comment, String phone) {
        CommentVO commentVO = new CommentVO();
        FeedBack feedBack = new FeedBack();
        feedBack.setRid(rid);
        feedBack.setPhone(phone);
        feedBack.setComment(comment);
        if (feedBackRepository.insert(feedBack) == 1) {
            commentVO.setPhone(phone);
        }
        ;
        return commentVO;
    }

    @Override
    public CommentVO addCommentToEid(Integer eid, String comment, String phone) {
        CommentVO commentVO = new CommentVO();
        FeedBack feedBack = new FeedBack();
        feedBack.setRid(eid);
        feedBack.setPhone(phone);
        feedBack.setComment(comment);
        if (feedBackRepository.insert(feedBack) == 1) {
            commentVO.setPhone(phone);
        }
        ;
        return commentVO;
    }

    @Override
    public List<FeedBack> findAll() {
        return null;
    }

    @Override
    public List<FeedBack> findByEid(Integer eid) {
        return null;
    }

    @Override
    public List<FeedBack> findByRid(Integer rid) {
        return null;
    }

    @Override
    public List<FeedBack> findByPhone(String phone) {
        return null;
    }

    @Override
    public List<FeedBack> findByTime(String time) {
        return null;
    }

    @Override
    public FeedBack findByPhoneAndTime(String phone, String time) {
        return null;
    }

    @Override
    public CommentVO doOpinion(Integer id, String opinion) {
        return null;
    }
}

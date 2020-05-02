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
        feedBack.setPass(0);
        if (feedBackRepository.insert(feedBack) == 1) {
            commentVO.setPhone(phone);
        } else {
            commentVO.setCode(1);
            commentVO.setMsg("评价出错请填写正确信息");
        }
        return commentVO;
    }

    @Override
    public CommentVO addCommentToEid(Integer eid, String comment, String phone) {
        CommentVO commentVO = new CommentVO();
        FeedBack feedBack = new FeedBack();
        feedBack.setEid(eid);
        feedBack.setPhone(phone);
        feedBack.setComment(comment);
        feedBack.setPass(0);
        if (feedBackRepository.insert(feedBack) == 1) {
            commentVO.setPhone(phone);
        } else {
            commentVO.setCode(1);
            commentVO.setMsg("评价出错请填写正确信息");
        }
        return commentVO;
    }

    @Override
    public List<FeedBack> findAll() {
        return feedBackRepository.findAll();
    }

    @Override
    public FeedBack findById(Integer id) {
        return feedBackRepository.findById(id);
    }

    @Override
    public List<FeedBack> findByEid(Integer eid) {
        return feedBackRepository.findByEid(eid);
    }

    @Override
    public List<FeedBack> findByRid(Integer rid) {
        return feedBackRepository.findByRid(rid);
    }

    @Override
    public List<FeedBack> findByPhone(String phone) {
        return feedBackRepository.findByPhone(phone);
    }

    @Override
    public List<FeedBack> findByTime(String time) {
        return feedBackRepository.findByTime(time);
    }

    @Override
    public List<FeedBack> findByPhoneAndTime(String phone, String time) {
        return feedBackRepository.findByPhoneAndTime(phone, time);
    }

    @Override
    public CommentVO doOpinion(Integer id, String opinion) {
        CommentVO commentVO = new CommentVO();
        FeedBack feedBack = feedBackRepository.findById(id);
        if (feedBack != null) {
            feedBack.setOpinion(opinion);
            feedBack.setPass(1);
            feedBackRepository.update(feedBack);
        } else {
            commentVO.setMsg("opinion过程出错");
            commentVO.setCode(1);
            commentVO.setPhone("出错了！评论所属id不存在");
        }
        return commentVO;
    }
}

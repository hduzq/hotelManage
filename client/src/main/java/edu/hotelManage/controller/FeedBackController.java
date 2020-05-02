package edu.hotelManage.controller;

import edu.hotelManage.VO.CommentVO;
import edu.hotelManage.entity.FeedBack;
import edu.hotelManage.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "feedback" )
public class FeedBackController {
    @Autowired
    private FeedBackService feedBackService;

    @GetMapping( "/commentToRoom/{rid}/{comment}/{phone}" )
    public CommentVO addCommentToRoom(@PathVariable Integer rid, @PathVariable String comment, @PathVariable String phone) {
        return feedBackService.addCommentToRoom(rid, comment, phone);
    }

    @GetMapping( "/commentToEid/{eid}/{comment}/{phone}" )
    public CommentVO addCommentToEid(@PathVariable Integer eid, @PathVariable String comment, @PathVariable String phone) {

        return feedBackService.addCommentToEid(eid, comment, phone);
    }


    @GetMapping( "/findAll" )
    public List<FeedBack> findAll() {
        return feedBackService.findAll();
    }

    @GetMapping( "/findById/{id}" )
    public FeedBack findById(@PathVariable Integer id) {
        return feedBackService.findById(id);
    }

    @GetMapping( "/findByEid/{eid}" )
    public List<FeedBack> findByEid(@PathVariable Integer eid) {
        return feedBackService.findByEid(eid);
    }

    @GetMapping( "/findByRid/{rid}" )
    public List<FeedBack> findByRid(@PathVariable Integer rid) {
        return feedBackService.findByRid(rid);
    }

    @GetMapping( "/findByPhone/{phone}" )
    public List<FeedBack> findByPhone(@PathVariable String phone) {
        return feedBackService.findByPhone(phone);
    }

    @GetMapping( "/findByTime/{time}" )
    public List<FeedBack> findByTime(@PathVariable String time) {
        return feedBackService.findByTime(time);
    }

    @GetMapping( "/findByPhoneAndTime/{phone}/{time}" )
    public List<FeedBack> findByPhoneAndTime(@PathVariable String phone, @PathVariable String time) {
        return feedBackService.findByPhoneAndTime(phone, time);
    }

    /**
     * 管理者写出评论
     *
     * @param id      评论记录的id
     * @param opinion 需要填写的意见
     * @return
     */
    @GetMapping( "/doOpinion/{id}/{opinion}" )
    public CommentVO doOpinion(@PathVariable Integer id, @PathVariable String opinion) {
        return feedBackService.doOpinion(id, opinion);
    }
}

package edu.hotelManage.controller;

import edu.hotelManage.VO.RoomTimeVO;
import edu.hotelManage.entity.RoomTime;
import edu.hotelManage.service.RoomTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "/roomTime" )
public class RoomTimeController {
    @Autowired
    private RoomTimeService roomTimeService;

    @GetMapping( "/findAll" )
    public List<RoomTime> findAll() {
        return roomTimeService.findAll();
    }

    @GetMapping( "/findAllNeed" )
    public List<RoomTime> findAllNeed() {
        return roomTimeService.findAllNeed();
    }

    /**
     * 打开叫醒服务
     *
     * @param rid  房间对应编号
     * @param time 需要叫醒的时刻
     * @return
     */
    @GetMapping( "/updateOn/{rid}/{time}" )
    public RoomTimeVO updateOn(@PathVariable Integer rid, @PathVariable String time) {
        RoomTimeVO roomTimeVO = new RoomTimeVO();
        if (roomTimeService.updateOn(rid, time) != 0) {
            roomTimeVO.setMsg("选择叫醒服务成功时间为");
            roomTimeVO.setRid(rid);
            roomTimeVO.setTime(time);
        }
        return roomTimeVO;
    }

    /**
     * 关闭叫醒服务
     *
     * @param rid 房间对应编号
     * @return 1
     */
    @GetMapping( "/updateOff/{rid}" )
    public RoomTimeVO updateOff(@PathVariable Integer rid) {
        RoomTimeVO roomTimeVO = new RoomTimeVO();
        if (roomTimeService.updateOff(rid) != 0) {
            roomTimeVO.setMsg("取消叫醒服务成功");
            roomTimeVO.setRid(rid);
        }
        return roomTimeVO;
    }
}

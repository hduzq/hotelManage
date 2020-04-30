package edu.hotelManage.controller;

import edu.hotelManage.service.SignInService;
import edu.hotelManage.vo.SignInVO;
import edu.hotelManage.vo.SignVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/sign" )
public class SignController {
    @Autowired
    private SignInService signInService;

    /**
     * 显示eid对应员工的签到情况
     * /sign/show/2
     *
     * @param eid 员工id
     * @return 返回签到视图
     */
    @GetMapping( "/show/{eid}" )
    public SignVO showSignList(@PathVariable Integer eid) {
        return signInService.findByEid(eid);
    }

    @GetMapping( "/showByTime/{time}" )
    public SignVO showByTime(@PathVariable String time) {
        return signInService.findByTime(time);
    }

    @GetMapping( "/doSign/{eid}" )
    public SignInVO doSign(@PathVariable Integer eid) {
        return signInService.doSign(eid);
    }
}

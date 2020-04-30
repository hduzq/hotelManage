package edu.hotelManage.controller;

import edu.hotelManage.entity.NoSign;
import edu.hotelManage.service.NoSignService;
import edu.hotelManage.vo.NoSignVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/noSign" )
public class NoSignController {
    @Autowired
    private NoSignService noSignService;

    @GetMapping( "/doNoSign" )
    public NoSignVO doNoSign(@RequestBody NoSign noSign) {
        NoSignVO noSignVO = noSignService.doNoSign(noSign.getEid(),
                noSign.getDay(),
                noSign.getReason(),
                noSign.getTime());
        return noSignVO;
    }

    @GetMapping( "/findByEid/{eid}" )
    public List<NoSign> findNoSignListByEid(@PathVariable Integer eid) {
        return noSignService.findNoSignListByEid(eid);
    }

    @GetMapping( "/findAll" )
    public List<NoSign> findAll() {
        return noSignService.findAll();
    }

    @GetMapping( "/doOpinion" )
    public void doOpinion(@RequestBody NoSign noSign) {
        noSignService.doOpinion(noSign);
    }
}

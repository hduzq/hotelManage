package edu.hotelManage.controller;

import edu.hotelManage.VO.AddNumVO;
import edu.hotelManage.VO.AddSuppliesVO;
import edu.hotelManage.VO.UpdatePriceVO;
import edu.hotelManage.entity.Supplies;
import edu.hotelManage.service.SuppliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping( "/supplies" )
public class SuppliesController {
    @Autowired
    private SuppliesService suppliesService;

    @GetMapping( "/findAll" )
    public List<Supplies> findAll() {
        return suppliesService.findAll();
    }

    @GetMapping( "/findById/{id}" )
    public Supplies findById(@PathVariable Integer id) {
        return suppliesService.findById(id);
    }

    /**
     * 增加新的货品种类
     *
     * @param supplies
     * @return
     */
    @GetMapping( "/add" )
    public AddSuppliesVO addSuppliesVO(@RequestBody Supplies supplies) {
        return suppliesService.addSupplies(supplies);
    }

    /**
     * @param id       货物id
     * @param quantity 上货数量
     * @return
     */
    @GetMapping( "/addNum/{id}/{quantity}" )
    public AddNumVO addNumVO(@PathVariable Integer id, @PathVariable Integer quantity) {
        return suppliesService.addNum(id, quantity);
    }

    @GetMapping( "/subNum/{id}/{quantity}" )
    public AddNumVO subNum(@PathVariable Integer id, @PathVariable Integer quantity) {
        return suppliesService.subNum(id, quantity);
    }

    /**
     * 修改进价
     *
     * @param id
     * @param price1
     * @return
     */
    @GetMapping( "/update1/{id}/{price1}" )
    public UpdatePriceVO updatePriceVO(@PathVariable Integer id, @PathVariable BigDecimal price1) {
        return suppliesService.updatePrice1(id, price1);
    }

    /**
     * 修改售价
     *
     * @param id
     * @param price2
     * @return
     */
    @GetMapping( "/update2/{id}/{price2}" )
    public UpdatePriceVO updatePriceVO2(@PathVariable Integer id, @PathVariable BigDecimal price2) {
        return suppliesService.updatePrice1(id, price2);
    }
}

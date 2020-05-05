package edu.hotelManage.service.Impl;

import edu.hotelManage.VO.AddNumVO;
import edu.hotelManage.VO.AddSuppliesVO;
import edu.hotelManage.VO.SuppliesVO;
import edu.hotelManage.VO.UpdatePriceVO;
import edu.hotelManage.entity.Supplies;
import edu.hotelManage.entity.SuppliesInLog;
import edu.hotelManage.entity.SuppliesLog;
import edu.hotelManage.repository.SuppliesInLogRepository;
import edu.hotelManage.repository.SuppliesLogRepository;
import edu.hotelManage.repository.SuppliesRepository;
import edu.hotelManage.service.SuppliesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SuppliesServiceImpl implements SuppliesService {
    @Autowired
    private SuppliesRepository suppliesRepository;
    @Autowired
    private SuppliesLogRepository suppliesLogRepository;
    @Autowired
    private SuppliesInLogRepository suppliesInLogRepository;

    @Override
    public List<Supplies> findAll() {
        return suppliesRepository.findAll();
    }

    @Override
    public Supplies findById(Integer id) {
        return suppliesRepository.findById(id);
    }

    /**
     * 增加消耗品种类
     *
     * @param supplies 要添加的消耗品
     * @return
     */
    @Override
    public AddSuppliesVO addSupplies(Supplies supplies) {
        String name = supplies.getName();
        List<Supplies> temp = suppliesRepository.findByName(name);
        AddSuppliesVO addSuppliesVO = new AddSuppliesVO();
        if (temp.size() == 0) {
            suppliesRepository.insert(supplies);
            addSuppliesVO.setName(name);
        } else {
            addSuppliesVO.setCode(1);
            addSuppliesVO.setMsg("无需重复添加");
        }
        return addSuppliesVO;
    }

    /**
     * 上货功能
     *
     * @param id       消耗品对应id
     * @param quantity 增加的数量
     * @return
     */
    @Override
    public AddNumVO addNum(Integer id, Integer quantity) {
        AddNumVO addNumVO = new AddNumVO();
        SuppliesInLog suppliesInLog = new SuppliesInLog();
        Supplies supplies = suppliesRepository.findById(id);
        if (supplies != null) {
            //向进货日志中添加信息
            suppliesInLog.setSid(id);
            suppliesInLog.setQuantity(quantity);
            suppliesInLogRepository.insert(suppliesInLog);
            //增加库存
            supplies.setQuantity(supplies.getQuantity() + quantity);
            //更新supplies表
            suppliesRepository.update(supplies);
            //处理addNum视图
            BeanUtils.copyProperties(supplies, addNumVO);
        } else {//如果没有对应的商品
            addNumVO.setCode(1);
            addNumVO.setMsg("请先添加该消耗品(商品)");
            addNumVO.setId(-1);
            addNumVO.setQuantity(-1);
            addNumVO.setName("商品不存在");
        }
        return addNumVO;
    }

    /**
     * 卖货功能
     *
     * @param id       消耗品对应id
     * @param quantity 出售的数量
     * @return
     */
    @Override
    public AddNumVO subNum(Integer id, Integer quantity) {
        AddNumVO addNumVO = new AddNumVO();
        Supplies supplies = suppliesRepository.findById(id);
        SuppliesLog suppliesLog = new SuppliesLog();
        if (supplies != null) {
            //得到现在库存数量
            Integer stock = supplies.getQuantity();
            if (quantity > stock) {
                addNumVO.setCode(1);
                addNumVO.setMsg("库存不足");
                BeanUtils.copyProperties(supplies, addNumVO);
                return addNumVO;
            }
            stock = stock - quantity;
            supplies.setQuantity(stock);
            suppliesRepository.update(supplies);

            suppliesLog.setSid(id);
            suppliesLog.setQuantity(quantity);
            suppliesLogRepository.insert(suppliesLog);

            addNumVO.setCode(0);
            addNumVO.setMsg("销售成功 销售后的数量如下");
            BeanUtils.copyProperties(supplies, addNumVO);
        } else {
            addNumVO.setCode(1);
            addNumVO.setMsg("所购买的商品不存在");
            addNumVO.setId(-1);
            addNumVO.setQuantity(-1);
            addNumVO.setName("商品不存在");
        }
        return addNumVO;
    }

    /**
     * 修改进价
     *
     * @param id     消耗品对应id
     * @param price1 修改后的进价价格
     * @return
     */
    @Override
    public UpdatePriceVO updatePrice1(Integer id, BigDecimal price1) {
        Supplies supplies = suppliesRepository.findById(id);
        UpdatePriceVO updatePriceVO = new UpdatePriceVO();
        if (supplies != null) {
            supplies.setPrice1(price1);
            suppliesRepository.update(supplies);
            BeanUtils.copyProperties(supplies, updatePriceVO);
        } else {
            updatePriceVO.setCode(1);
            updatePriceVO.setMsg("修改进价失败这个商品不存在");
        }
        return updatePriceVO;
    }

    /**
     * 修改售价
     *
     * @param id     消耗品对应id
     * @param price2 修改后的售价价格
     * @return
     */
    @Override
    public UpdatePriceVO updatePrice2(Integer id, BigDecimal price2) {
        Supplies supplies = suppliesRepository.findById(id);
        UpdatePriceVO updatePriceVO = new UpdatePriceVO();
        if (supplies != null) {
            supplies.setPrice2(price2);
            suppliesRepository.update(supplies);
            BeanUtils.copyProperties(supplies, updatePriceVO);
        } else {
            updatePriceVO.setCode(1);
            updatePriceVO.setMsg("修改售价失败这个商品不存在");
        }
        return updatePriceVO;
    }
}

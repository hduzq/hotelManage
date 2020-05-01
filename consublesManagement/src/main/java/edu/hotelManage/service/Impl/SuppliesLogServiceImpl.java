package edu.hotelManage.service.Impl;

import edu.hotelManage.VO.SuppliesLogNamedVO;
import edu.hotelManage.VO.SuppliesLogVO;
import edu.hotelManage.entity.Supplies;
import edu.hotelManage.entity.SuppliesLog;
import edu.hotelManage.repository.SuppliesLogRepository;
import edu.hotelManage.repository.SuppliesRepository;
import edu.hotelManage.service.SuppliesLogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SuppliesLogServiceImpl implements SuppliesLogService {
    @Autowired
    private SuppliesLogRepository suppliesLogRepository;
    @Autowired
    private SuppliesRepository suppliesRepository;

    @Override
    public List<SuppliesLog> findAll() {
        return suppliesLogRepository.findAll();
    }

    @Override
    public List<SuppliesLog> findByTime(String time) {
        return suppliesLogRepository.findByTime(time);
    }

    @Override
    public List<SuppliesLog> findBySId(Integer sid) {
        return suppliesLogRepository.findBySid(sid);
    }

    /**
     * 根据 消耗品名称 搜索相关消耗记录
     *
     * @param name
     * @return
     */
    @Override
    public SuppliesLogNamedVO findByName(String name) {
        /**
         * 根据名称模糊查出一个 Supplies 表  Supplies类包含name属性
         */
        List<Supplies> suppliesList = suppliesRepository.findByName(name);

        SuppliesLogNamedVO suppliesLogNamedVO = new SuppliesLogNamedVO();

        List<List<SuppliesLogVO>> list = new ArrayList<>();

        /**
         * List<>中添加的东西需要每次new 否则会丢失数据
         */
        for (Supplies supplies :
                suppliesList) {
            List<SuppliesLogVO> suppliesLogVOList = new ArrayList<>();

            List<SuppliesLog> suppliesLogList = suppliesLogRepository.findBySid(supplies.getId());
            for (SuppliesLog suppliesLog :
                    suppliesLogList) {
                /**
                 * SuppliesLogVO 相比 SuppliesLog多了一个name属性 此name和传入的name不同为精确name
                 */
                SuppliesLogVO suppliesLogVO = new SuppliesLogVO();
                suppliesLogVO.setName(supplies.getName());
                BeanUtils.copyProperties(suppliesLog, suppliesLogVO);
                suppliesLogVOList.add(suppliesLogVO);
            }

            list.add(suppliesLogVOList);
        }//完成对suppliesLogVO的name 和 sid复制

        suppliesLogNamedVO.setSuppliesLogByName(list);
        return suppliesLogNamedVO;
    }

    @Override
    public List<SuppliesLog> findByTimeAndSid(String time, Integer sid) {
        return suppliesLogRepository.findByTimeAndSid(time, sid);
    }
}

package edu.hotelManage.service.impl;

import edu.hotelManage.entity.Employee;
import edu.hotelManage.entity.NoSign;
import edu.hotelManage.repository.EmployeeMapper;
import edu.hotelManage.repository.NoSignRepository;
import edu.hotelManage.service.NoSignService;
import edu.hotelManage.vo.NoSignVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoSignServiceImpl implements NoSignService {
    @Autowired
    private NoSignRepository noSignRepository;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public NoSignVO doNoSign(Integer eid, Integer day, String reason, String time) {
        NoSign noSign = new NoSign();
        NoSignVO noSignVO = new NoSignVO();
        noSign.setEid(eid);
        noSign.setDay(day);
        noSign.setReason(reason);
        noSign.setTime(time);
        noSignRepository.insert(noSign);
        //获取员工姓名
        Employee employee = employeeMapper.findById(eid);
        BeanUtils.copyProperties(noSign, noSignVO);
        BeanUtils.copyProperties(employee, noSignVO);

        return noSignVO;
    }

    @Override
    public List<NoSign> findNoSignListByEid(Integer eid) {
        return noSignRepository.findByEid(eid);
    }

    @Override
    public List<NoSign> findAll() {
        return noSignRepository.findAll();
    }

    @Override
    public void doOpinion(NoSign noSign) {
        noSignRepository.update(noSign);
    }
}

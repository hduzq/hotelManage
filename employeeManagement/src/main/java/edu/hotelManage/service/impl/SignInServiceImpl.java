package edu.hotelManage.service.impl;

import edu.hotelManage.entity.Employee;
import edu.hotelManage.entity.NoSign;
import edu.hotelManage.entity.SignIn;
import edu.hotelManage.repository.EmployeeMapper;
import edu.hotelManage.repository.NoSignRepository;
import edu.hotelManage.repository.SignInRepository;
import edu.hotelManage.service.SignInService;
import edu.hotelManage.vo.SignInVO;
import edu.hotelManage.vo.SignVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class SignInServiceImpl implements SignInService {
    @Autowired
    private SignInRepository signInRepository;
    @Autowired
    private NoSignRepository noSignRepository;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override

    public SignVO findByEid(Integer eid) {
        List<SignIn> signInList = signInRepository.findByEid(eid);
        List<NoSign> noSignList = noSignRepository.findByEid(eid);
        SignVO signVO = new SignVO();
        signVO.setSignInList(signInList);
        signVO.setNoSignList(noSignList);
        return signVO;
    }

    @Override
    public SignVO findByTime(String time) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy");
        try {
            simpleDateFormat.parse(time);
            List<SignIn> signInList = signInRepository.findByTime(time);
            List<NoSign> noSignList = noSignRepository.findByTime(time);
            SignVO signVO = new SignVO();
            signVO.setSignInList(signInList);
            signVO.setNoSignList(noSignList);
            return signVO;
        } catch (ParseException e) {
            try {
                //第一次匹配失败
                simpleDateFormat2.parse(time);
                List<SignIn> signInList = signInRepository.findByTime(time);
                List<NoSign> noSignList = noSignRepository.findByTime(time);
                SignVO signVO = new SignVO();
                signVO.setSignInList(signInList);
                signVO.setNoSignList(noSignList);
                return signVO;
            } catch (Exception exception) {
                try {
                    simpleDateFormat3.parse(time);
                    List<SignIn> signInList = signInRepository.findByTime(time);
                    List<NoSign> noSignList = noSignRepository.findByTime(time);
                    SignVO signVO = new SignVO();
                    signVO.setSignInList(signInList);
                    signVO.setNoSignList(noSignList);

                    return signVO;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        }
        return null;
    }

    /**
     * @param eid 员工对应id
     * @return 返回一个签到反馈的视图
     */
    @Override
    public SignInVO doSign(Integer eid) {
        SignInVO signInVO = new SignInVO();
        Employee employee = employeeMapper.findById(eid);
        BeanUtils.copyProperties(employee, signInVO);

        /**
         *  获取当前日期 yyyy-MM-dd形式 一天签到一次
         */
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String time = simpleDateFormat.format(calendar.getTime());

        //由于设置一天可以签到数次 所以此返回结果可能是List<>
        List<SignIn> signInList = signInRepository.findByTimeAndEid(time, eid);
        SignIn signIn = new SignIn();
        if (signInList.size() == 0) {//表示当天还未签到
            signIn.setEid(eid);
            signInRepository.insert(signIn);
            signInVO.setEid(eid);
            signInVO.setName(employee.getName());
        } else {
            signInVO.setCode(1);
            signInVO.setMsg("已经签到 不用重复签到");
            signInVO.setEid(eid);
            signInVO.setName(employee.getName());
        }

        return signInVO;
    }
}

package edu.hotelManage.vo;

import edu.hotelManage.entity.NoSign;
import edu.hotelManage.entity.SignIn;
import lombok.Data;

import java.util.List;

/**
 * 用于查询签到情况的 View Object
 */
@Data
public class SignVO {
    private List<SignIn> SignInList;
    private List<NoSign> NoSignList;
}

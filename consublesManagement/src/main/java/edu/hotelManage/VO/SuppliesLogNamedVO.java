package edu.hotelManage.VO;

import edu.hotelManage.entity.SuppliesLog;
import lombok.Data;

import java.util.List;

/**
 * 通过 findByName(String name)查询到的消耗品日志
 * VO
 */
@Data
public class SuppliesLogNamedVO {
    private List<List<SuppliesLogVO>> SuppliesLogByName;
}

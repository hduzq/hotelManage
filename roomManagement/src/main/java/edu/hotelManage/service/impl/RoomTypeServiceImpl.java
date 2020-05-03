package edu.hotelManage.service.impl;

import edu.hotelManage.VO.RoomTypeVO;
import edu.hotelManage.VO.UpdatePriceVO;
import edu.hotelManage.entity.RoomType;
import edu.hotelManage.repository.RoomTypeRepository;
import edu.hotelManage.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {
    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Override
    public List<RoomType> findAll() {
        return roomTypeRepository.findAll();
    }

    @Override
    public UpdatePriceVO updatePrice1(Integer type, BigDecimal price1) {
        UpdatePriceVO updatePriceVO = new UpdatePriceVO();

        RoomType roomType = roomTypeRepository.findById(type);
        if (roomType == null) {
            updatePriceVO.setCode(1);
            updatePriceVO.setMsg("操作失败 房间类型不存在");
            return updatePriceVO;
        }
        roomType.setPrice1(price1);
        int flag = roomTypeRepository.update(roomType);
        if (flag == 1) {
            updatePriceVO.setType(type);
            updatePriceVO.setPrice1(price1);
            updatePriceVO.setPrice2(roomType.getPrice2());
        } else {
            updatePriceVO.setCode(1);
            updatePriceVO.setMsg("操作失败");
        }
        return updatePriceVO;
    }

    @Override
    public UpdatePriceVO updatePrice2(Integer type, BigDecimal price2) {
        UpdatePriceVO updatePriceVO = new UpdatePriceVO();

        RoomType roomType = roomTypeRepository.findById(type);
        if (roomType == null) {
            updatePriceVO.setCode(1);
            updatePriceVO.setMsg("操作失败 房间类型不存在");
            return updatePriceVO;
        }
        roomType.setPrice2(price2);
        int flag = roomTypeRepository.update(roomType);
        if (flag == 1) {
            updatePriceVO.setType(type);
            updatePriceVO.setPrice1(roomType.getPrice1());
            updatePriceVO.setPrice2(price2);
        } else {
            updatePriceVO.setCode(1);
            updatePriceVO.setMsg("操作失败");
        }
        return updatePriceVO;
    }

    @Override
    public RoomTypeVO updateRoomType(RoomType roomType) {
        RoomTypeVO roomTypeVO = new RoomTypeVO();
        int flag = roomTypeRepository.update(roomType);
        if (flag == 1) {
            roomTypeVO.setRoomType(roomType);
            return roomTypeVO;
        } else {
            roomTypeVO.setCode(1);
            roomTypeVO.setMsg("更新类型失败 操作失败");
        }
        return roomTypeVO;
    }

    @Override
    public RoomTypeVO addRoomType(RoomType roomType) {
        RoomTypeVO roomTypeVO = new RoomTypeVO();
        int flag = roomTypeRepository.insert(roomType);
        if (flag == 1) {
            roomTypeVO.setRoomType(roomType);
            return roomTypeVO;
        } else {
            roomTypeVO.setCode(1);
            roomTypeVO.setMsg("增加类型失败操作失败");
        }
        return roomTypeVO;
    }
}

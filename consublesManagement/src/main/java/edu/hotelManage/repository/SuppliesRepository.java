package edu.hotelManage.repository;

import edu.hotelManage.entity.Supplies;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuppliesRepository {
    List<Supplies> findAll();

    int insert(Supplies supplies);

    int update(Supplies supplies);

    Supplies findById(Integer id);

    List<Supplies> findByName(String name);
}

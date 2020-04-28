package edu.hotelManage.repository;

import edu.hotelManage.entity.Supplies;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuppliesRepository {
    List<Supplies> findAll();

    void insert(Supplies supplies);

    void update(Supplies supplies);

    Supplies findById(Integer id);

    Supplies findByName(String name);
}

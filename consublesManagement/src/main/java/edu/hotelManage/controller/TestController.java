package edu.hotelManage.controller;

import edu.hotelManage.entity.Supplies;
import edu.hotelManage.repository.SuppliesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/supplies" )
public class TestController {
    @Autowired
    private SuppliesRepository suppliesRepository;

    @GetMapping( "/findAll" )
    public List<Supplies> findAll() {
        return suppliesRepository.findAll();
    }

    @PostMapping( "/update" )
    public int update(@RequestBody Supplies supplies) {
        return suppliesRepository.update(supplies);
    }

    @PostMapping( "/insert" )
    public int insert(@RequestBody Supplies supplies) {
        return suppliesRepository.insert(supplies);
    }

    @GetMapping( "/findById/{id}" )
    public Supplies findById(@PathVariable Integer id) {
        return suppliesRepository.findById(id);
    }

    @GetMapping( "/findByName/{name}" )
    public Supplies findByName(@PathVariable( "name" ) String name) {
        return suppliesRepository.findByName(name);
    }
}

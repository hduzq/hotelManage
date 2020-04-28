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
    public void update(@RequestBody Supplies supplies) {
        suppliesRepository.update(supplies);
    }

    @PostMapping( "/insert" )
    public void insert(@RequestBody Supplies supplies) {
        suppliesRepository.insert(supplies);
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

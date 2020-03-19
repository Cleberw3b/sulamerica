package com.sulamerica.demo.controller;

import java.util.List;

import com.sulamerica.demo.model.Cargo;
import com.sulamerica.demo.service.CargoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CargoController {

    @Autowired
    CargoService cargoService;

    @GetMapping("/cargos")
    private List<Cargo> getAllCargos() {
        return cargoService.getAllCargos();
    }

    @GetMapping("/cargos/{id}")
    private Cargo getUser(@PathVariable("id") Integer id) {
        return cargoService.getCargoById(id);
    }

    @DeleteMapping("/cargos/{id}")
    private void deleteUser(@PathVariable("id") Integer id) {
        cargoService.delete(id);
    }

    @PostMapping("/cargos")
    private int saveUser(@RequestBody Cargo cargo) {
        cargoService.saveOrUpdate(cargo);
        return cargo.getId();
    }
}
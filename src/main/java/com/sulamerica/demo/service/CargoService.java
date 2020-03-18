package com.sulamerica.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.sulamerica.demo.model.Cargo;
import com.sulamerica.demo.repository.CargoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargoService {

    @Autowired
    CargoRepository cargoRepository;

    public List<Cargo> getAllCargos() {
        List<Cargo> cargos = new ArrayList<Cargo>();
        cargoRepository.findAll().forEach(cargo -> cargos.add(cargo));
        return cargos;
    }

    public Cargo getCargoById(int id) {
        return cargoRepository.findById(id).get();
    }

    public void saveOrUpdate(Cargo cargo) {
        cargoRepository.save(cargo);
    }

    public void delete(int id) {
        cargoRepository.deleteById(id);
    }
}
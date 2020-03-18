package com.sulamerica.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.sulamerica.demo.model.Cargo;
import com.sulamerica.demo.repository.CargoRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargoService {

    private static final Logger log = LoggerFactory.getLogger(CargoService.class);

    @Autowired
    CargoRepository cargoRepository;

    public List<Cargo> getAllCargos() {
        log.info("Listando cargos...");
        List<Cargo> cargos = new ArrayList<Cargo>();
        cargoRepository.findAll().forEach(cargo -> cargos.add(cargo));
        cargos.forEach(cargo -> log.info(cargos.toString()));
        return cargos;
    }

    public Cargo getCargoById(int id) {
        Cargo cargo = cargoRepository.findById(id).get();
        log.info("Cargo recuperado" + System.lineSeparator() + cargo.toString());
        return cargo;
    }

    public void saveOrUpdate(Cargo cargo) {
        log.info("Salvando cargo" + System.lineSeparator() + cargo.toString());
        cargoRepository.save(cargo);
    }

    public void delete(int id) {
        log.info("Delentando cargo com ID=" + id);
        cargoRepository.deleteById(id);
    }
}
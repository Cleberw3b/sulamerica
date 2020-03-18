package com.sulamerica.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.sulamerica.demo.model.Perfil;
import com.sulamerica.demo.repository.PerfilRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {

    @Autowired
    PerfilRepository perfilRepository;

    public List<Perfil> getAllPerfis() {
        List<Perfil> perfis = new ArrayList<Perfil>();
        perfilRepository.findAll().forEach(perfil -> perfis.add(perfil));
        return perfis;
    }

    public Perfil getPerfilById(int id) {
        return perfilRepository.findById(id).get();
    }

    public void saveOrUpdate(Perfil cargo) {
        perfilRepository.save(cargo);
    }

    public void delete(int id) {
        perfilRepository.deleteById(id);
    }
}
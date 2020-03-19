package com.sulamerica.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.sulamerica.demo.model.Perfil;
import com.sulamerica.demo.repository.PerfilRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {

    private static final Logger log = LoggerFactory.getLogger(PerfilService.class);

    @Autowired
    PerfilRepository perfilRepository;

    public List<Perfil> getAllPerfis() {
        log.info("Listando perfis...");
        List<Perfil> perfis = new ArrayList<Perfil>();
        perfilRepository.findAll().forEach(perfil -> perfis.add(perfil));
        perfis.forEach(perfil -> log.info(perfil.toString()));
        return perfis;
    }

    public Perfil getPerfilById(Integer id) {
        Perfil perfil = perfilRepository.findById(id).get();
        log.info("Perfil recuperado" + System.lineSeparator() + perfil.toString());
        return perfil;
    }

    public void saveOrUpdate(Perfil perfil) {
        log.info("Salvando perfil" + System.lineSeparator() + perfil.toString());
        perfilRepository.save(perfil);
    }

    public void delete(Integer id) {
        log.info("Delentando perfil com ID=" + id);
        perfilRepository.deleteById(id);
    }
}
package com.sulamerica.demo.controller;

import java.util.List;

import com.sulamerica.demo.model.Perfil;
import com.sulamerica.demo.service.PerfilService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PerfilController {

    @Autowired
    PerfilService perfilService;

    @GetMapping("/perfis")
    private List<Perfil> getAllPerfis() {
        return perfilService.getAllPerfis();
    }

    @GetMapping("/perfis/{id}")
    private Perfil getUser(@PathVariable("id") Integer id) {
        return perfilService.getPerfilById(id);
    }

    @DeleteMapping("/perfis/{id}")
    private void deleteUser(@PathVariable("id") Integer id) {
        perfilService.delete(id);
    }

    @PostMapping("/perfis")
    private int saveUser(@RequestBody Perfil perfil) {
        perfilService.saveOrUpdate(perfil);
        return perfil.getId();
    }
}
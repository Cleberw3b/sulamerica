package com.sulamerica.demo.repository;

import java.util.List;

import com.sulamerica.demo.model.Cargo;
import com.sulamerica.demo.model.Perfil;
import com.sulamerica.demo.model.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    // Deve ser possível realizar buscas por nome, CPF, cargo, perfil ou/e status.
    public User findByNome(String nome);

    public User findByCpf(String cpf);

    public List<User> findAllByCargo(Cargo cargo);

    public List<User> findAllByPerfil(Perfil perfil);

    public List<User> findAllByActive(Boolean isActive);

}

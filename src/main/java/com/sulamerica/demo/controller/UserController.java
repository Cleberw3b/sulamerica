package com.sulamerica.demo.controller;

import java.util.List;

import javax.validation.Valid;

import com.sulamerica.demo.model.Cargo;
import com.sulamerica.demo.model.Perfil;
import com.sulamerica.demo.model.User;
import com.sulamerica.demo.service.UserService;
import com.sulamerica.demo.util.enums.Status;
import com.sulamerica.demo.util.validators.UserValidation;
import com.sulamerica.demo.util.validators.UserValidationResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    private List<User> getAllUser(@RequestParam(required = false) Cargo cargo,
            @RequestParam(required = false) Perfil perfil, @RequestParam(required = false) Status ativo) {
        if (cargo != null)
            return userService.getUsersByCargo(cargo);
        if (perfil != null)
            return userService.getUsersByPerfil(perfil);
        if (ativo == Status.ATIVO)
            return userService.getUsersByStatus(true);
        if (ativo == Status.DESATIVO)
            return userService.getUsersByStatus(false);
        return userService.getAllUsers();
    }

    @GetMapping("/user")
    private User getUser(@RequestParam(required = false) Integer id, @RequestParam(required = false) String nome,
            @RequestParam(required = false) String cpf) {
        if (id != null)
            return userService.getUserById(id);
        if (nome != null && !nome.isEmpty())
            return userService.getUserByNome(nome);
        if (cpf != null && !cpf.isEmpty())
            return userService.getUserByCPF(cpf);
        return null;
    }

    @DeleteMapping("/users/{id}")
    private void deleteUser(@PathVariable("id") Integer id) {
        userService.delete(id);
    }

    @PostMapping("/users")
    private String addUser(@Valid @RequestBody User user) {
        // Não será permitido o cadastro de usuários com o mesmo CPF e Nome.
        if (userService.getUserByNome(user.getNome()) != null || userService.getUserByCPF(user.getCpf()) != null)
            return "Usuário já existe em nosso sistema";

        // Ao cadastrar, todos os dados de usuários são obrigatórios.
        // Verificar se é um CPF válido.
        UserValidationResult userValidationResult = UserValidation.isUserValid(user);
        if (!userValidationResult.isValid) {
            StringBuilder errors = new StringBuilder();
            userValidationResult.errors.forEach(error -> {
                errors.append(error);
                errors.append(", ");
            });
            return errors.substring(0, errors.length() - 3);
        }

        userService.saveOrUpdate(user);
        return "Usuário salvo com sucesso - ID=" + user.getId();
    }

    @PutMapping(value = "/users/{id}")
    public Integer updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
        userService.saveOrUpdate(user);
        return user.getId();
    }
}
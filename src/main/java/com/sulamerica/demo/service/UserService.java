package com.sulamerica.demo.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import com.sulamerica.demo.model.Cargo;
import com.sulamerica.demo.model.Perfil;
import com.sulamerica.demo.model.User;
import com.sulamerica.demo.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getAllUsers() {
        log.info("Listando usuários...");
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(user -> users.add(user));
        if (users.isEmpty())
            log.info("Nenhum usuário encontrado");
        else
            users.forEach(user -> log.info(user.toString()));
        return users;
    }

    public User getUserById(Integer id) {
        User user = userRepository.findById(id).get();
        if (user != null)
            log.info("Usuário recuperado" + System.lineSeparator() + user.toString());
        else
            log.info("Usuário não encontrado");
        return user;
    }

    public User getUserByNome(String nome) {
        User user = userRepository.findByNome(nome);
        if (user != null)
            log.info("Usuário recuperado" + System.lineSeparator() + user.toString());
        else
            log.info("Usuário não encontrado");
        return user;
    }

    public User getUserByCPF(String cpf) {
        User user = userRepository.findByCpf(cpf);
        if (user != null)
            log.info("Usuário recuperado" + System.lineSeparator() + user.toString());
        else
            log.info("Usuário não encontrado");
        return user;
    }

    public List<User> getUsersByCargo(Cargo cargo) {
        log.info("Listando usuários com " + cargo.toString());
        List<User> users = new ArrayList<User>();
        userRepository.findAllByCargo(cargo).forEach(user -> users.add(user));
        if (users.isEmpty())
            log.info("Nenhum usuário encontrado");
        else
            users.forEach(user -> log.info(user.toString()));
        return users;
    }

    public List<User> getUsersByPerfil(Perfil perfil) {
        log.info("Listando usuários com " + perfil.toString());
        List<User> users = new ArrayList<User>();
        userRepository.findAllByPerfil(perfil).forEach(user -> users.add(user));
        if (users.isEmpty())
            log.info("Nenhum usuário encontrado");
        else
            users.forEach(user -> log.info(user.toString()));
        return users;
    }

    public List<User> getUsersByStatus(Boolean isActive) {
        log.info("Listando usuários com status " + isActive);
        List<User> users = new ArrayList<User>();
        userRepository.findAllByActive(isActive).forEach(user -> users.add(user));
        if (users.isEmpty())
            log.info("Nenhum usuário encontrado");
        else
            users.forEach(user -> log.info(user.toString()));
        return users;
    }

    public void saveOrUpdate(User user) {
        log.info("Salvando usuário" + System.lineSeparator() + user.toString());
        if (!user.isActive())
            if (userRepository.findById(user.getId()).get().isActive())
                log.info("Inativando usuário ativo");
        userRepository.save(user);
    }

    public void delete(Integer id) {
        log.info("Delentando usuário com ID=" + id);
        userRepository.deleteById(id);
    }

    // Crie um serviço para inativar os usuários ativos.•
    public void inactiveUsers() {
        // List<User> usersActive = getUsersByStatus(true);
        // usersActive.forEach(user -> {
        // log.info("Inativando usuário " + user.toString());
        // user.setActive(false);
        // saveOrUpdate(user);
        // });
        log.info("Inativando usuários ativos");
        String sql = "UPDATE USER SET active = 0 WHERE active = 1";
        jdbcTemplate.update(sql);
    }

    // Crie um serviço que retorne os usuários do sexo feminino
    // e que sejam maiores de 18 anos
    public List<User> usersFemaleAgeGreaterThan18() {
        log.info("Listando usuários do sexo feminino maiores de 18 anos");
        List<User> usersFemaleAgeGreaterThan18 = new ArrayList<User>();
        userRepository.findAll().forEach(user -> {
            Period period = Period.between(user.getDataDeNascimento(), LocalDate.now());
            if (user.getSexo().equalsIgnoreCase("feminino") && period.getYears() >= 18)
                usersFemaleAgeGreaterThan18.add(user);
        });
        return usersFemaleAgeGreaterThan18;
    }

    // Crie um serviço que retorne os CPF’s que iniciem com dígito zero.
    public List<User> usersThatCpfBeginsWithZero() {
        log.info("Listando usuários com CPF iniados com digito zero");
        List<User> usersThatCpfBeginsWithZero = new ArrayList<User>();
        getAllUsers().forEach(user -> {
            if (user.getCpf().substring(0, 1).equalsIgnoreCase("0"))
                usersThatCpfBeginsWithZero.add(user);
        });
        String sql = "SELECT * FROM USER WHERE LEFT(cpf, 1) = ?";
        jdbcTemplate
                .query(sql, new Object[] { '0' },
                        (rs, rowNum) -> new User(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"),
                                rs.getString("sexo"),
                                rs.getDate("DATA_DE_NASCIMENTO").toInstant().atZone(ZoneId.systemDefault())
                                        .toLocalDate(),
                                rs.getObject("cargo", Cargo.class), rs.getObject("perfil", Perfil.class),
                                rs.getBoolean("active")))
                .forEach(user -> usersThatCpfBeginsWithZero.add(user));

        return usersThatCpfBeginsWithZero;
    }
}
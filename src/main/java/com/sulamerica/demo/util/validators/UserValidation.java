package com.sulamerica.demo.util.validators;

import java.time.LocalDate;
import java.time.Period;
import java.util.InputMismatchException;

import com.sulamerica.demo.model.User;

public class UserValidation {
    public static UserValidationResult isUserValid(User user) {

        UserValidationResult result = new UserValidationResult();
        result.isValid = false;
        try {
            if (user.getNome() == null || user.getNome().isEmpty()) {
                result.errors.add("Nome não informado");
            }
            if (user.getCpf() == null || user.getCpf().isEmpty()) {
                result.errors.add("CPF não informado");
            }
            if (!isCPFValid(user.getCpf())) {
                result.errors.add("CPF inválido");
            }
            if (user.getSexo() == null || user.getSexo().isEmpty()) {
                result.errors.add("Sexo não informado");
            }
            if (user.getDataDeNascimento() == null
                    || Period.between(user.getDataDeNascimento(), LocalDate.now()).getDays() < 1) {
                result.errors.add("Data de Nascimento invalida");
            }
            if (user.getCargo() == null || user.getCargo().getNome().isEmpty()) {
                result.errors.add("Cargo não informado");
            }
            if (user.getPerfil() == null || user.getPerfil().getNome().isEmpty()) {
                result.errors.add("Perfil não informado");
            }

            if (result.errors.isEmpty()) {
                result.isValid = true;
            }
            return result;
        } catch (Exception e) {
            result.isValid = false;
            result.errors.add(e.getLocalizedMessage());
            return result;
        }
    }

    public static boolean isCPFValid(String cpf) {

        cpf = cpf.replace('.', ' ');
        cpf = cpf.replace('-', ' ');
        cpf = cpf.replace("/", "");
        cpf = cpf.replaceAll(" ", "");

        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
                || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
                || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
                || cpf.equals("99999999999") || (cpf.length() != 11))
            return false;

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else
                dig11 = (char) (r + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
                return true;
            else
                return false;
        } catch (InputMismatchException erro) {
            return false;
        }
    }
}
package com.example.testeJunior.util;

public class ValidadorCPF {

    public static boolean CPFValido(String cpf) {
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF possui 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos são iguais
        if (cpf.chars().distinct().count() == 1) {
            return false;
        }

        // Validação dos dígitos verificadores
        int[] pesos1 = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] pesos2 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

        // Calcula o primeiro dígito verificador
        int soma1 = 0;
        for (int i = 0; i < 9; i++) {
            soma1 += (cpf.charAt(i) - '0') * pesos1[i];
        }
        int digito1 = (soma1 * 10) % 11;
        if (digito1 == 10) digito1 = 0;

        // Calcula o segundo dígito verificador
        int soma2 = 0;
        for (int i = 0; i < 10; i++) {
            soma2 += (cpf.charAt(i) - '0') * pesos2[i];
        }
        int digito2 = (soma2 * 10) % 11;
        if (digito2 == 10) digito2 = 0;

        // Verifica se os dígitos verificadores são iguais aos fornecidos
        return cpf.charAt(9) == digito1 + '0' && cpf.charAt(10) == digito2 + '0';
    }
}

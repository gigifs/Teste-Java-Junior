package com.example.testeJunior.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Endereco {

    @Pattern(regexp = "\\d{5}-\\d{3}", message = "CEP inválido")
    private String cep;

    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;

    @Pattern(regexp = "^[A-Z]{2}$", message = "UF inválido")
    private String uf;
}

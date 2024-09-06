package com.example.testeJunior.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Sobrenome é obrigatório")
    private String sobrenome;

    @Min(18)
    @Max(100)
    private int idade;

    @Pattern(regexp = "^(\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2})$", message = "CPF inválido")
    private String cpf;

    @Pattern(regexp = "^\\(\\d{2}\\)\\s?\\d{4,5}\\-?\\d{4}$", message = "Telefone inválido")
    private String telefone;

    @Email(message = "Email inválido")
    private String email;

    @Embedded
    private Endereco endereco;

}

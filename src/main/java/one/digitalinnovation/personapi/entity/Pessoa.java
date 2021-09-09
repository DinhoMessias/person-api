package one.digitalinnovation.personapi.entity;

import lombok.Data;

@Data
public class Pessoa {
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
}

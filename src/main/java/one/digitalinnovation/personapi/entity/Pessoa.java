package one.digitalinnovation.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    private Long id;
    private String nome;
    private String cpf;
    private List<Telefone> telefones;
}

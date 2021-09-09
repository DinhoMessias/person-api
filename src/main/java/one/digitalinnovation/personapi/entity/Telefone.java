package one.digitalinnovation.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.enums.TipoTelefone;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Telefone {

    private Long id;
    private Integer numero;
    private TipoTelefone tipoTelefone;
}

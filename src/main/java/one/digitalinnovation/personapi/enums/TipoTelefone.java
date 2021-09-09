package one.digitalinnovation.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoTelefone {
    PESSOAL("Pessoal"),
    COMERCIAL("Comercial"),
    RECADO("Recado");

    private final String tipo;
}

package one.digitalinnovation.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoTelefone {
    PESSOAL("Pessoal"),
    COMERCIAL("Comercial"),
    CELULAR("Recado");

    private final String tipo;
}

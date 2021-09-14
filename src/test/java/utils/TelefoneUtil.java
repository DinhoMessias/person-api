package utils;

import one.digitalinnovation.personapi.dto.request.TelefoneDTO;
import one.digitalinnovation.personapi.entity.Telefone;
import one.digitalinnovation.personapi.enums.TipoTelefone;

public class TelefoneUtil {

    private static final Long ID = 1L;
    private static final String NUMERO = "997267898";
    private static final TipoTelefone TIPOTELEFONE = TipoTelefone.CELULAR;


    public static TelefoneDTO createFakeDTO() {
        return TelefoneDTO.builder()
                .numero(NUMERO)
                .tipoTelefone(TIPOTELEFONE)
                .build();
    }

    public static Telefone createFakeTelefone(){
        return Telefone.builder()
                .id(ID)
                .numero(NUMERO)
                .tipoTelefone(TIPOTELEFONE)
                .build();
    }
}

package utils;

import one.digitalinnovation.personapi.dto.request.PessoaCreateRequestDTO;
import one.digitalinnovation.personapi.entity.Pessoa;

import java.util.Collections;

public class PessoaUtil {

    private static final Long ID = 1L;

    private static final String NOME = "Dinho Soares";

    private static final String CPF = "126.753.437-06";

    public static PessoaCreateRequestDTO createFakeDTO(){
        return PessoaCreateRequestDTO.builder()
                .nome(NOME)
                .cpf(CPF)
                .telefones(Collections.singletonList(TelefoneUtil.createFakeDTO()))
                .build();
    }

    public static Pessoa createFakePessoa(){
        return Pessoa.builder()
                .id(ID)
                .nome(NOME)
                .cpf(CPF)
                .telefones(Collections.singletonList(TelefoneUtil.createFakeTelefone()))
                .build();
    }



}

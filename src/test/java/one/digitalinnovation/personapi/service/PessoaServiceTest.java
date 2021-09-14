package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.request.PessoaCreateRequestDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Pessoa;
import one.digitalinnovation.personapi.repository.PessoaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import utils.PessoaUtil;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static utils.PessoaUtil.*;

@ExtendWith(MockitoExtension.class)
class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaService pessoaService;

    @Test
    void testGivenPessoaDTOThenReturnSaveMessage() {
        PessoaCreateRequestDTO pessoaFakeDTO = createFakeDTO();
        Pessoa expectedPessoaSaved = createFakePessoa();

        Mockito.when(pessoaRepository.save(any(Pessoa.class))).
                thenReturn(expectedPessoaSaved);

        MessageResponseDTO expectedMessageResponseDTO = getMessageResponseDTO("Pessoa criada com id: ", expectedPessoaSaved.getId());
        MessageResponseDTO messageResponseDTO = pessoaService.createPessoa(pessoaFakeDTO);

        assertEquals(expectedMessageResponseDTO, messageResponseDTO);
    }

    private MessageResponseDTO getMessageResponseDTO(String message, Long id) {
        return MessageResponseDTO.builder()
                .message(message + id)
                .build();
    }
}
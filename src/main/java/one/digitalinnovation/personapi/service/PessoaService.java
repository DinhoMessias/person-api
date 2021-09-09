package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Pessoa;
import one.digitalinnovation.personapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public MessageResponseDTO createPessoa(Pessoa pessoa) {
        Pessoa savePessoa = pessoaRepository.save(pessoa);
        return MessageResponseDTO.builder()
                .message("Pessoa criada com id: " + savePessoa.getId())
                .build();
    }
}

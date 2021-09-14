package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.request.PessoaDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Pessoa;
import one.digitalinnovation.personapi.mapper.PessoaMapper;
import one.digitalinnovation.personapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    private final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;

    public MessageResponseDTO createPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoaToSave = pessoaMapper.toEntity(pessoaDTO);
        Pessoa savedPessoa = pessoaRepository.save(pessoaToSave);
        return MessageResponseDTO.builder()
                .message("Pessoa criada com id: " + savedPessoa.getId())
                .build();
    }
}

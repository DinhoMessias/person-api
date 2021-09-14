package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.request.PessoaRequestDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.dto.response.PessoaResponseDTO;
import one.digitalinnovation.personapi.entity.Pessoa;
import one.digitalinnovation.personapi.exception.PessoaNotFoundException;
import one.digitalinnovation.personapi.mapper.PessoaMapper;
import one.digitalinnovation.personapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    private final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;

    public MessageResponseDTO createPessoa(PessoaRequestDTO pessoaDTO) {
        Pessoa pessoaToSave = pessoaMapper.toEntity(pessoaDTO);
        Pessoa savedPessoa = pessoaRepository.save(pessoaToSave);
        return MessageResponseDTO.builder()
                .message("Pessoa criada com id: " + savedPessoa.getId())
                .build();
    }

    public List<PessoaResponseDTO> findAll() {

        List<Pessoa> pessoas = pessoaRepository.findAll();
        return pessoas.stream().
                map(pessoaMapper::toResponseDTO).
                collect(Collectors.toList());
    }

    public PessoaResponseDTO findById(Long id) throws PessoaNotFoundException {
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);

        if (optionalPessoa.isEmpty()) {
            throw new PessoaNotFoundException(id);
        }
        return pessoaMapper.toResponseDTO(optionalPessoa.get());
    }
}

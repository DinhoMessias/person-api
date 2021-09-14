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
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    private final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;

    public MessageResponseDTO createPessoa(PessoaRequestDTO pessoaDTO) {
        Pessoa pessoaToSave = pessoaMapper.toEntity(pessoaDTO);
        Pessoa savedPessoa = pessoaRepository.save(pessoaToSave);
        return createMessageResponseDTO("Pessoa criada com id: ", savedPessoa.getId());
    }

    public List<PessoaResponseDTO> findAll() {

        List<Pessoa> pessoas = pessoaRepository.findAll();
        return pessoas.stream().
                map(pessoaMapper::toResponseDTO).
                collect(Collectors.toList());
    }

    public PessoaResponseDTO findById(Long id) throws PessoaNotFoundException {
        Pessoa pessoa = verifyById(id);
        return pessoaMapper.toResponseDTO(pessoa);
    }

    public void delete(Long id) throws PessoaNotFoundException {
        Pessoa pessoa = verifyById(id);
        pessoaRepository.delete(pessoa);
    }

    public MessageResponseDTO editPessoa(Long id, PessoaRequestDTO pessoaDTO) throws PessoaNotFoundException {
        verifyById(id);
        Pessoa pessoaToSave = pessoaMapper.toEntity(pessoaDTO);
        pessoaToSave.setId(id);
        Pessoa savedPessoa = pessoaRepository.save(pessoaToSave);
        return createMessageResponseDTO("Pessoa editada com id: ", savedPessoa.getId());
    }

    private Pessoa verifyById(Long id) throws PessoaNotFoundException {
        return pessoaRepository.findById(id).orElseThrow(()
                -> new PessoaNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponseDTO(String message, Long id) {
        return MessageResponseDTO.builder()
                .message(message + id)
                .build();
    }
}

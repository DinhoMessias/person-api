package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.dto.request.PessoaCreateRequestDTO;
import one.digitalinnovation.personapi.dto.request.PessoaUpdateRequestDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.dto.response.PessoaResponseDTO;
import one.digitalinnovation.personapi.exception.PessoaNotFoundException;
import one.digitalinnovation.personapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public MessageResponseDTO createPessoa (@RequestBody PessoaCreateRequestDTO pessoaDTO){
        return pessoaService.createPessoa(pessoaDTO);
    }

    @GetMapping
    public List<PessoaResponseDTO> listAll(){
        return pessoaService.findAll();
    }

    @GetMapping(path = "/{id}")
    public PessoaResponseDTO findById(@PathVariable Long id) throws PessoaNotFoundException {
        return pessoaService.findById(id);
    }

    @PutMapping(path = "/{id}")
    public MessageResponseDTO editPessoa(@PathVariable Long id, @RequestBody PessoaUpdateRequestDTO pessoaUpdate) throws PessoaNotFoundException {
        return pessoaService.editPessoa(id, pessoaUpdate);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Long id) throws PessoaNotFoundException {
        pessoaService.delete(id);
    }
/*    @GetMapping
    public String hello(){
        return "<h1>Te amo meu bem</h1>";
    }*/
}

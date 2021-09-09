package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Pessoa;
import one.digitalinnovation.personapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public MessageResponseDTO createPessoa (@RequestBody Pessoa pessoa){
        return pessoaService.createPessoa(pessoa);
    }

    @GetMapping
    public String hello(){
        return "<h1>Te amo meu bem</h1>";
    }
}

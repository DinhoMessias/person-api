package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.dto.request.PessoaDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public MessageResponseDTO createPessoa (@RequestBody PessoaDTO pessoaDTO){
        return pessoaService.createPessoa(pessoaDTO);
    }

    @GetMapping
    public String hello(){
        return "<h1>Te amo meu bem</h1>";
    }
}

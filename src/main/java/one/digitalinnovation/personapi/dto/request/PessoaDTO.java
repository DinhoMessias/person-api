package one.digitalinnovation.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {

    @NotEmpty
    @Size(min = 2, max = 100)
    private String nome;

    @NotEmpty
    @CPF
    private String cpf;

    @Valid
    @NotEmpty
    private List<TelefoneDTO> telefones;
}

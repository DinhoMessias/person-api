package one.digitalinnovation.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.enums.TipoTelefone;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneDTO {

    @NotEmpty
    @Size(min = 11, max = 16)
    private String numero;

    @NotEmpty
    @Enumerated(EnumType.STRING)
    private TipoTelefone tipoTelefone;

}

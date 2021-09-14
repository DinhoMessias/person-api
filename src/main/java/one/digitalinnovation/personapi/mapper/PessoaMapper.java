package one.digitalinnovation.personapi.mapper;

import one.digitalinnovation.personapi.dto.request.PessoaRequestDTO;
import one.digitalinnovation.personapi.dto.response.PessoaResponseDTO;
import one.digitalinnovation.personapi.entity.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PessoaMapper {

    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

    Pessoa toEntity(PessoaRequestDTO pessoaDTO);

    PessoaRequestDTO toDTO(Pessoa pessoa);

    PessoaResponseDTO toResponseDTO(Pessoa pessoa);
}

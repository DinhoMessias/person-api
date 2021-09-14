package one.digitalinnovation.personapi.mapper;

import one.digitalinnovation.personapi.dto.request.PessoaDTO;
import one.digitalinnovation.personapi.entity.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PessoaMapper {

    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

    Pessoa toEntity(PessoaDTO pessoaDTO);

    PessoaDTO toDTO(Pessoa pessoa);
}

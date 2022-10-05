package uz.najot.atto.mapper;

import org.mapstruct.Mapper;
import uz.najot.atto.dto.TerminalDto;
import uz.najot.atto.entity.Terminal;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TerminalMapper {
    Terminal toEntity(TerminalDto terminalDto);
    TerminalDto toDto(Terminal terminal);
    List<Terminal> toEntityList(List<TerminalDto> terminalDtos);
    List<TerminalDto> toDtoList(List<Terminal> terminals);
}

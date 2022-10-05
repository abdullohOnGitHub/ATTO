package uz.najot.atto.mapper;

import org.mapstruct.Mapper;
import uz.najot.atto.dto.StationDto;
import uz.najot.atto.entity.Station;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StationMapper {
    Station toEntity(StationDto stationDto);
    StationDto toDto(Station station);
    List<Station> toEntityList(List<StationDto> stationDtos);
    List<StationDto> toDtoList(List<Station> stations);
}

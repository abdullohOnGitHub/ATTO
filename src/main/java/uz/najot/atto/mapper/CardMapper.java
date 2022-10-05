package uz.najot.atto.mapper;

import org.mapstruct.Mapper;
import uz.najot.atto.dto.CardDto;
import uz.najot.atto.entity.Card;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper {
    Card toEntity(CardDto cardDto);
    CardDto toDto(Card card);
    List<Card> toEntityList(List<CardDto> cardDtos);
    List<CardDto> toDtoList(List<Card> cards);
}

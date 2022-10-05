package uz.najot.atto.mapper;

import org.mapstruct.Mapper;
import uz.najot.atto.dto.CardDto;
import uz.najot.atto.dto.TransactionDto;
import uz.najot.atto.entity.Card;
import uz.najot.atto.entity.Transaction;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    Transaction toEntity(TransactionDto transactionDto);
    TransactionDto toDto(Transaction transaction);
    List<Transaction> toEntityList(List<TransactionDto> transactionDtos);
    List<TransactionDto> toDtoList(List<Transaction> transactions);

}

package uz.najot.atto.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.najot.atto.dto.ResponseDto;
import uz.najot.atto.entity.Card;
import uz.najot.atto.mapper.TransactionMapper;
import uz.najot.atto.repository.CardRepository;
import uz.najot.atto.repository.TransactionRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final CardRepository cardRepository;
    private final TransactionMapper transactionMapper;

    public ResponseDto<List<?>> getAllTransaction(){
        return new ResponseDto<>(true,0,"ok",transactionRepository.findAll());
    }

    //Report
    public ResponseDto<?> getTransactionByCardId(int card_id) {
        Optional<Card> card = cardRepository.findById(card_id);
        if (card.isPresent()){
            return new ResponseDto<>(true,0,"ok",transactionRepository.cardHistory(card_id));
        }
        return new ResponseDto<>(false,-1,"card_id not found",null);
    }

    //Report
    public ResponseDto<?> getMaxCard(String date) {
        List<LocalDate> dates = ConfigDate(date);
        return new ResponseDto<>(true,0,"ok",transactionRepository.getMaxSpendCards(dates.get(0),dates.get(1)));
    }

    //Report
    public ResponseDto<?> getMinCard(String date) {
        List<LocalDate> dates = ConfigDate(date);
        return new ResponseDto<>(true,0,"ok",transactionRepository.getMinSpendCard(dates.get(0),dates.get(1)));
    }
    public List<LocalDate> ConfigDate(String date){
        String from_date = date.substring(date.lastIndexOf("\"from\" : \"") + 10, date.indexOf(",") - 1);
        String s = date.substring(date.indexOf("\"to\" : \"") + 8);
        String to_date = s.substring(0, s.indexOf("\""));
        LocalDate from = LocalDate.parse(from_date);
        LocalDate to = LocalDate.parse(to_date);
        List<LocalDate> dates = new ArrayList<>();
        dates.add(from);
        dates.add(to);
        return dates;
    }
}

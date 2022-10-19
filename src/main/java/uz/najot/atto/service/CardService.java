package uz.najot.atto.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.najot.atto.dto.CardDto;
import uz.najot.atto.dto.ResponseDto;
import uz.najot.atto.entity.Card;
import uz.najot.atto.mapper.CardMapper;
import uz.najot.atto.repository.CardRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    public ResponseDto<?> addCard(CardDto cardDto) {
        Card card = new Card(cardDto.getCardNumber(), cardDto.getPhoneNumber(), cardDto.getBalance());
        return new ResponseDto<>(true,0,"saved",cardRepository.save(card));
    }

    public ResponseDto<List<?>> getAll() {
        return new ResponseDto<>(true, 0, "ok",cardRepository.findAll());
    }

    public ResponseDto<?> getById(int id) {
        Optional<?> card = cardRepository.findById(id);
        if (card.isPresent()){
            return new ResponseDto<>(true,0,"ok", card.get());
        }else{
            return new ResponseDto<>(false,-1,"not found",null);
        }
    }

    public ResponseDto<?> addBalanceToCardId(int card_id, double money) {
        Optional<Card> card = cardRepository.findById(card_id);
        if (card.isPresent()){
            Double balance = card.get().getBalance();
            balance = balance + money;
            card.get().setBalance(balance);
            cardRepository.save(card.get());
            return new ResponseDto<>(true,0,"money added",null);
        }
        return new ResponseDto<>(false,-1,"card not found",null);
    }
}

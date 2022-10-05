package uz.najot.atto.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.najot.atto.dto.CardDto;
import uz.najot.atto.dto.ResponseDto;
import uz.najot.atto.service.CardService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {
    @Autowired
    private final CardService cardService;

    @PostMapping
    public ResponseDto<?> add(@Valid @RequestBody CardDto cardDto){
        System.out.println(cardDto.getCardNumber());
        return cardService.addCard(cardDto);
    }

    @GetMapping
    public ResponseDto<List<?>> getAll(){
        return cardService.getAll();
    }

    @GetMapping("{id}")
    public ResponseDto<?> getById(@PathVariable int id){
        return cardService.getById(id);
    }

    @PutMapping
    public ResponseDto<?> addBalance(@RequestParam int card_id, @RequestParam double money){
        return cardService.addBalanceToCardId(card_id,money);
    }
}

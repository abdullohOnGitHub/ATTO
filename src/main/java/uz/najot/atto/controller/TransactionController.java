package uz.najot.atto.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.najot.atto.dto.ResponseDto;
import uz.najot.atto.dto.TransactionDto;
import uz.najot.atto.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {
    @Autowired
    private final TransactionService transactionService;

    @GetMapping
    public ResponseDto<List<?>> getAll(){
        return transactionService.getAllTransaction();
    }


    /**
     * Report GetHistory By Card_id
     */
    @GetMapping("/report/{card_id}")
    public ResponseDto<?> getTransactionByCardId(@PathVariable int card_id){
        return transactionService.getTransactionByCardId(card_id);
    }

    /**
     * Report GetMaxSpendCard
     */

    @GetMapping("/report/maxCard")
    public ResponseDto<?> getMaxSpendCards(@RequestBody @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") String date){
        return transactionService.getMaxCard(date);
    }

    /**
     * Report GetMinimumSpendCard
     */
    @GetMapping("report/minCard")
    ResponseDto<?> getMinSpendCard(@RequestBody @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") String date){
        return transactionService.getMinCard(date);
    }
}

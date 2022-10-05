package uz.najot.atto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {

    private  String phoneNumber;
    private  String cardNumber;
    @Min(1000)
    private  Double balance;
}
package uz.najot.atto.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardHistoryDto {
    private String name;
    private Double balance;
    private Date date;
}

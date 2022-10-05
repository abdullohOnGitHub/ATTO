package uz.najot.atto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link uz.najot.atto.entity.Transaction} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto{
    private Integer terminal_id;
    private Integer card_id;
    private Double balance = 1400d;
}
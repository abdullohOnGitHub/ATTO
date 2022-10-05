package uz.najot.atto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction extends Base{
    private Integer terminal_id;
    private Integer card_id;
    private Double balance = 1400d;
}

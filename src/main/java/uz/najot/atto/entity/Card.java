package uz.najot.atto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name = "card")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card extends Base{

    @Column(nullable = false)
    private String phoneNumber;
    @Column(unique = true, nullable = false)
    private String cardNumber;
    private Double balance;

}

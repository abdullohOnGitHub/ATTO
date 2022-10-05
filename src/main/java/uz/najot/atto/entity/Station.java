package uz.najot.atto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Station extends Base{
    @Column(nullable = false, unique = true)
    private String name;
    private Double balance;
}

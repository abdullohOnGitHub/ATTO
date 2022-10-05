package uz.najot.atto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.najot.atto.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
}

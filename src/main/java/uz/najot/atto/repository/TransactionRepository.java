package uz.najot.atto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.najot.atto.entity.Transaction;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @Query(value = "select s.name, transaction.balance, transaction.created_date from transaction join terminal t\n" +
            "    on t.id = transaction.terminal_id join station s\n" +
            "    on s.id = t.station_id where card_id = ?", nativeQuery = true)
    List<Map<String,Object>> cardHistory(int card_id);

    @Query(value = "select card_id,sum(balance) as money\n" +
            "from transaction where created_date between ? and ? group by card_id order by money desc limit 2",nativeQuery = true)
    List<Map<String,Object>> getMaxSpendCards(LocalDate from,LocalDate to);

    @Query(value = "select phone_number,card_number,balance\n" +
            "from card where id not in (select t.card_id from transaction t) and created_date between ? and ?;",nativeQuery = true)
    List<Map<String,Object>> getMinSpendCard(LocalDate from, LocalDate to);
}

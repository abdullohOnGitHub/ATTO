package uz.najot.atto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.najot.atto.entity.Station;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
public interface StationRepository extends JpaRepository<Station, Integer> {
    @Query(value = "select name, balance from station where created_date between ? and ? order by balance desc ",
            nativeQuery = true)
    List<Map<String,Object>> stationListOrderByBalance(LocalDate from, LocalDate to);
}

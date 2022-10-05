package uz.najot.atto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.najot.atto.entity.Terminal;

import java.util.List;
import java.util.Optional;

@Repository
public interface TerminalRepository extends JpaRepository<Terminal, Integer> {
    List<Terminal> findAllByStationId(int station_id);
    Optional<Terminal> findByName(String name);
}

package uz.najot.atto.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.najot.atto.dto.ResponseDto;
import uz.najot.atto.dto.TerminalDto;
import uz.najot.atto.entity.Card;
import uz.najot.atto.entity.Station;
import uz.najot.atto.entity.Terminal;
import uz.najot.atto.entity.Transaction;
import uz.najot.atto.mapper.TerminalMapper;
import uz.najot.atto.repository.CardRepository;
import uz.najot.atto.repository.StationRepository;
import uz.najot.atto.repository.TerminalRepository;
import uz.najot.atto.repository.TransactionRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TerminalService {
    private final TerminalRepository terminalRepository;
    private final StationRepository stationRepository;
    private final CardRepository cardRepository;
    private final TransactionRepository transactionRepository;
    private final TerminalMapper terminalMapper;

    @Transactional
    public ResponseDto<List<?>> getAll(){
        List<Terminal> terminals = terminalRepository.findAll();
        return new ResponseDto<>(true, 0, "ok",terminals);
    }

    public ResponseDto<?> getById(int id){
        Optional<Terminal> terminal = terminalRepository.findById(id);
        if (terminal.isPresent()){
            return new ResponseDto<>(true, 0, "ok",terminal.get());
        }
        return new ResponseDto<>(false, -1, "not found", null);
    }

    public ResponseDto<?> addTerminal(TerminalDto terminalDto){
        Station station = stationRepository.getReferenceById(terminalDto.getStation_id());
        Terminal save = terminalRepository.save(new Terminal(terminalDto.getName(),station));
        return new ResponseDto<>(true, 0, "ok", null);
    }

    @Transactional
    public ResponseDto<?> payByCardId(int card_id,String terminal_name){
        Optional<Card> card = cardRepository.findById(card_id);
        if (card.isPresent() && card.get().getBalance()>=1400){
            card.get().setBalance(card.get().getBalance()-1400);
            cardRepository.save(card.get());
            Optional<Terminal> terminal = terminalRepository.findByName(terminal_name);
            if (terminal.isPresent()){
                Integer station_id = terminal.get().getStation().getId();
                Optional<Station> station = stationRepository.findById(station_id);
                if (station.isPresent()){
                    station.get().setBalance(station.get().getBalance()+1400);
                    stationRepository.save(station.get());
                    transactionRepository.save(new Transaction(terminal.get().getId(),card.get().getId(),1400d));
                    return new ResponseDto<>(true,0,"ok",null);
                }else{
                    return new ResponseDto<>(false,-1,"station is not valid",null);
                }
            }else {
                return new ResponseDto<>(false,-1,"terminal is not valid",null);
            }
        }
        return new ResponseDto<>(false,-1,"card_id is not valid or balance is not enough",null);
    }

    public ResponseDto<List<?>> getTerminalByStationId(int id){
        Optional<Station> station = stationRepository.findById(id);
        if (station.isPresent()){
            return new ResponseDto<>(true,0,"ok",terminalRepository.findAllByStationId(id));
        }
        return new ResponseDto<>(false,-1,"station not found",null);
    }
}

package uz.najot.atto.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.najot.atto.dto.ResponseDto;
import uz.najot.atto.dto.TerminalDto;
import uz.najot.atto.service.TerminalService;

import java.util.List;

@RestController
@RequestMapping("/terminal")
@RequiredArgsConstructor
public class TerminalController {
    @Autowired
    private final TerminalService terminalService;

    @PostMapping
    public ResponseDto<?> addTerminal(@RequestBody TerminalDto terminalDto){
        return terminalService.addTerminal(terminalDto);
    }

    @GetMapping
    public ResponseDto<List<?>> getAll(){
        return terminalService.getAll();
    }

    @GetMapping("{id}")
    public ResponseDto<?> getTerminalById(@PathVariable int id){
        return terminalService.getById(id);
    }

    @PostMapping("/payment/{card_id}")
    public ResponseDto<?> paymentByCardId(@PathVariable int card_id, @RequestParam String terminal_name){
        return terminalService.payByCardId(card_id,terminal_name);
    }

    @GetMapping("/stationId/{station_id}")
    public ResponseDto<List<?>> findByStationId(@PathVariable int station_id){
        return terminalService.getTerminalByStationId(station_id);
    }

    //TODO terminal get yo'lidagi dtolani to'girlash kere
}

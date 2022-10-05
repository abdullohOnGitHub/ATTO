package uz.najot.atto.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.najot.atto.dto.ResponseDto;
import uz.najot.atto.dto.StationDto;
import uz.najot.atto.service.StationService;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/station")
@RequiredArgsConstructor
public class StationController {
    @Autowired
    private final StationService stationService;

    @PostMapping
    public ResponseDto<?> addStation(@RequestBody StationDto stationDto){
        return stationService.addStation(stationDto);
    }
    @GetMapping
    public ResponseDto<List<?>> getAllStations(){
        return stationService.getAllStation();
    }
    @GetMapping("{id}")
    public ResponseDto<?> getStationById(@PathVariable int id){
        return stationService.getStationById(id);
    }


    /**
     * Report GETStationsOrderByBalanceBetweenDates
     */
    @GetMapping("/all/ordered")
    public ResponseDto<?> getStationsOrderByBalance(@RequestBody @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") String date){
        return stationService.getStationOrderByBalance(date);
    }
}

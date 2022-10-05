package uz.najot.atto.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.najot.atto.dto.ResponseDto;
import uz.najot.atto.dto.StationDto;
import uz.najot.atto.entity.Station;
import uz.najot.atto.mapper.StationMapper;
import uz.najot.atto.repository.StationRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StationService {
    private final StationRepository stationRepository;
    private final StationMapper stationMapper;

    public ResponseDto<?> addStation(StationDto stationDto){
        Station station = new Station(stationDto.getName(), stationDto.getBalance());
        return new ResponseDto<>(true, 0,"ok",stationRepository.save(station));
    }

    public ResponseDto<List<?>> getAllStation(){
        return new ResponseDto<>(true,0,"ok",stationRepository.findAll());
    }

    public ResponseDto<?> getStationById(int id){
        Optional<Station> station = stationRepository.findById(id);
        if (station.isPresent()){
            return new ResponseDto<>(true,0,"ok",station.get());
        }
        return new ResponseDto<>(false,-1,"not found",null);
    }

    public ResponseDto<List<?>> getStationOrderByBalance(String date){
        String from_date = date.substring(date.lastIndexOf("\"from\" : \"") + 10, date.indexOf(",") - 1);
        String s = date.substring(date.indexOf("\"to\" : \"") + 8);
        String to_date = s.substring(0, s.indexOf("\""));

        LocalDate from = LocalDate.parse(from_date);
        LocalDate to = LocalDate.parse(to_date);

        return new ResponseDto<>(true,0,"ok",stationRepository.stationListOrderByBalance(from,to));
    }
}

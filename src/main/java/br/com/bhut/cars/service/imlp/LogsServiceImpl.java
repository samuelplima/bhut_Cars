package br.com.bhut.cars.service.imlp;

import br.com.bhut.cars.dto.CarsDTO;
import br.com.bhut.cars.dto.CreateCarDTO;
import br.com.bhut.cars.dto.LogsDTO;
import br.com.bhut.cars.entities.Logs;
import br.com.bhut.cars.repository.LogsRepository;
import br.com.bhut.cars.service.LogsService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LogsServiceImpl implements LogsService {

    private LogsRepository logsRepository;

    @Autowired
    public LogsServiceImpl(LogsRepository logsRepository) {
        this.logsRepository = logsRepository;
    }

    @Override
    public LogsDTO createLog(CreateCarDTO createCarDTO, LogsDTO logsDTO) {
        Logs logs = new Logs();
        Date date = new Date();

        logs.setCar_id(createCarDTO.getTitle());
        logs.setData_hora(new Date(date.getTime()));

        Logs savedLogs = logsRepository.save(logs);

        logsDTO.setCarId(savedLogs.getCar_id());
        logsDTO.setDataHora(savedLogs.getData_hora());

        return logsDTO;
    }
}

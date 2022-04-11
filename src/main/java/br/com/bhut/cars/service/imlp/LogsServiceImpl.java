package br.com.bhut.cars.service.imlp;

import br.com.bhut.cars.dto.CreateCarDTO;
import br.com.bhut.cars.dto.LogsDTO;
import br.com.bhut.cars.entities.Logs;
import br.com.bhut.cars.repository.LogsRepository;
import br.com.bhut.cars.service.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<LogsDTO> findAll() {
        List<Logs> logsList;
        logsList = logsRepository.findAll();
        return logsList
                .stream()
                .map(logsDTO -> getLogsDTO(logsDTO))
                .collect(Collectors.toList());
    }

    private LogsDTO getLogsDTO(Logs logs) {
        return new LogsDTO(logs.getId(), logs.getData_hora(), logs.getCar_id());
    }


}

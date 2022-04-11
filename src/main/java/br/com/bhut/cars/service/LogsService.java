package br.com.bhut.cars.service;

import br.com.bhut.cars.dto.CarsDTO;
import br.com.bhut.cars.dto.CreateCarDTO;
import br.com.bhut.cars.dto.LogsDTO;
import br.com.bhut.cars.entities.Logs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogsService {

    LogsDTO createLog(CreateCarDTO createCarDTO, LogsDTO logsDTO);

    List<LogsDTO> findAll();

}

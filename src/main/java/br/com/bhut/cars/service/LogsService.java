package br.com.bhut.cars.service;

import br.com.bhut.cars.dto.CarsDTO;
import br.com.bhut.cars.dto.CreateCarDTO;
import br.com.bhut.cars.dto.LogsDTO;

public interface LogsService {

    LogsDTO createLog(CreateCarDTO createCarDTO, LogsDTO logsDTO);

}

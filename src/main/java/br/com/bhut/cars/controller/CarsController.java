package br.com.bhut.cars.controller;

import br.com.bhut.cars.client.ClientCarsPost;
import br.com.bhut.cars.dto.CarsDTO;
import br.com.bhut.cars.client.ClientCarsGet;
import br.com.bhut.cars.dto.CreateCarDTO;
import br.com.bhut.cars.dto.LogsDTO;
import br.com.bhut.cars.service.LogsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Transactional
@RestController
@RequestMapping("/api")
public class CarsController {

    private ClientCarsGet clientCarsGet;
    private ClientCarsPost clientCarsPost;
    private LogsService logsService;

    @Autowired
    public CarsController(ClientCarsGet clientCarsGet, ClientCarsPost clientCarsPost, LogsService logsService) {
        this.clientCarsGet = clientCarsGet;
        this.clientCarsPost = clientCarsPost;
        this.logsService = logsService;
    }

    @GetMapping("/cars")
    public List<CarsDTO> listCars() {
        return clientCarsGet.listCars();
    }

    @PostMapping("/cars")
    public CreateCarDTO createCar(@RequestBody CreateCarDTO createCarDTO, LogsDTO logsDTO) {

        CreateCarDTO createdCar = clientCarsPost.createCar(createCarDTO);

        logsService.createLog(createdCar, logsDTO);

        return createdCar;
    }

}




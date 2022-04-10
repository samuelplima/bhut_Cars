package br.com.bhut.cars.Cars.controller;

import br.com.bhut.cars.Cars.dto.CarsDTO;
import br.com.bhut.cars.Cars.client.ClientCarsGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class CarsController {

    private ClientCarsGet clientCarsGet;

    @Autowired
    public CarsController(ClientCarsGet clientCarsGet) {
        this.clientCarsGet = clientCarsGet;
    }

    @GetMapping
    public List<CarsDTO> findAll () {
        return clientCarsGet.getCars();
    }

}




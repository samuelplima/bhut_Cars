package br.com.bhut.cars.Cars.controller;

import br.com.bhut.cars.Cars.client.ClientCarsPost;
import br.com.bhut.cars.Cars.dto.CarsDTO;
import br.com.bhut.cars.Cars.client.ClientCarsGet;
import br.com.bhut.cars.Cars.dto.CreateCarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarsController {

    private ClientCarsGet clientCarsGet;
    private ClientCarsPost clientCarsPost;

    @Autowired
    public CarsController(ClientCarsGet clientCarsGet, ClientCarsPost clientCarsPost) {
        this.clientCarsGet = clientCarsGet;
        this.clientCarsPost = clientCarsPost;
    }

    @GetMapping("/cars")
    public List<CarsDTO> findAll() {
        return clientCarsGet.getCars();
    }

    @PostMapping("/cars")
    public CreateCarDTO createCar(@RequestBody CreateCarDTO createCarsDTO) {
        return clientCarsPost.createCar(createCarsDTO);
    }

}




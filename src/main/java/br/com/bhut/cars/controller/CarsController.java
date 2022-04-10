package br.com.bhut.cars.controller;

import br.com.bhut.cars.client.ClientCarsPost;
import br.com.bhut.cars.dto.CarsDTO;
import br.com.bhut.cars.client.ClientCarsGet;
import br.com.bhut.cars.dto.CreateCarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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




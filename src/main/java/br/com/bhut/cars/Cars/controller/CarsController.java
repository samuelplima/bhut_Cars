package br.com.bhut.cars.Cars.controller;

import br.com.bhut.cars.Cars.model.dto.CarsDTO;
import br.com.bhut.cars.Cars.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarsController {

    private CarsService carsService;

    @Autowired
    public CarsController(CarsService carsService) {
        this.carsService = carsService;
    }

    @GetMapping("/{cars}")
    public List<CarsDTO> findAll (@PathVariable String cars) {
        return carsService.getCars(cars);
    }

}




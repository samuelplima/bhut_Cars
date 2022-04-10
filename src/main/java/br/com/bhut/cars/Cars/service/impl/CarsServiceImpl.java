package br.com.bhut.cars.Cars.service.impl;

import br.com.bhut.cars.Cars.model.dto.CarsDTO;
import br.com.bhut.cars.Cars.model.entities.Car;
import br.com.bhut.cars.Cars.service.CarsService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

public class CarsServiceImpl implements CarsService {

    @Override
    public List<CarsDTO> getCars(String cars) {
        List<Car> CarsList = null;
        return CarsList
                .stream()
                .map(car -> new CarsDTO(car))
                .collect(Collectors.toList());
    }
}

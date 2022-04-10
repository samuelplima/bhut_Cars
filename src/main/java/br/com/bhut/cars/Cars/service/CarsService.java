package br.com.bhut.cars.Cars.service;

import br.com.bhut.cars.Cars.model.dto.CarsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(url= "http://api-test.bhut.com.br:3000" , name = "Cars")
public interface CarsService {

    @GetMapping("{cars}/json")
    List<CarsDTO> getCars(@PathVariable("cars") String cars);

}

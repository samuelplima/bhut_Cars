package br.com.bhut.cars.Cars.model.dto;

import br.com.bhut.cars.Cars.model.entities.Car;

public class CarsDTO {

    private String title;
    private String brand;
    private String price;
    private int age;

    public CarsDTO(Car car) {
    }
}

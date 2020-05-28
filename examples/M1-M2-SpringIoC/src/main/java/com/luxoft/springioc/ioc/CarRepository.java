package com.luxoft.springioc.ioc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarRepository {

    public List<Car> getAllCars() {

        return new ArrayList<>(Arrays.asList(new Car("Tayota"), new Car("Mercedess"), new Car("Niva")));
    }
}

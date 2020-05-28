package com.luxoft.springioc.ioc;

import java.util.Iterator;
import java.util.List;

public class CarFinder {

    private CarRepository carRepository;

    public List<Car> getCars(String filter) {

        List<Car> result = carRepository.getAllCars();

        for (Iterator<Car> it = result.iterator(); it.hasNext();) {

            if (!it.next().getName().startsWith(filter)) {

                it.remove();
            }
        }

        return result;
    }

    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
}



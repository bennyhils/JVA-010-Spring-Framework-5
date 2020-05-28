package com.luxoft.springioc.ioc;

public class Demo {

    public static void main(String[] args) {

        CarRepository carRepository = new CarRepository();

        CarFinder finder = new CarFinder();
        finder.setCarRepository(carRepository);


        System.out.println(finder.getCars("T"));
    }
}

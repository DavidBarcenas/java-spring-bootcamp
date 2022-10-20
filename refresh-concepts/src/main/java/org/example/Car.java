package org.example;

import java.util.Objects;

public class Car {
    private String brand;
    private String model;
    private int year;
    private int km;
    private String domain;

    public Car() {
    }

    public Car(String brand, String model, int year, int km, String domain) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.km = km;
        this.domain = domain;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && km == car.km && brand.equals(car.brand) && model.equals(car.model) && domain.equals(car.domain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year, km, domain);
    }
}

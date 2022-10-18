package org.example;

public class Main {
    public static void main(String[] args) {
        Car clio = new Car();
        clio.setBrand("Renault");
        clio.setModel("Clio");
        clio.setYear(2014);
        clio.setKm(0);
        clio.setDomain("MHN123");

        Car megane = new Car("Renault", "Megane", 2016, 0, "ERT567");
        Car megane2 = new Car("Renault", "Megane", 2016, 0, "ERT567");

        System.out.println(clio.getBrand() + " - " + clio.getModel());
        System.out.println(megane.getBrand() + " - " + megane.getModel());

        System.out.println(clio.equals(megane));
        System.out.println(megane.equals(megane2));
    }
}
package com.birmingham.hci.workshop.chen.worksheet4;

/**
 * This class is a subclass of the class Aircraft, so this class
 * extends a series of properties from Aircraft, which are
 * passengerNumber and maxSpeed.
 * This class describes an Aeroplane using the fuelConsumption
 * to show the fuel consumption of a certain kind of aeroplane.
 *
 * User: Chen Liu
 * Date: 2019/11/16
 * Time: 10:35 pm
 */
public class Aeroplane extends Aircraft {
    /**
     * fuel consumption
     */
    private double fuelConsumption;

    /**
     * Constructor
     *
     * @param passengerNumber passengerNumber
     * @param maxSpeed        maxSpeed
     * @param fuelConsumption fuelConsumption
     */
    public Aeroplane(int passengerNumber, int maxSpeed, double fuelConsumption) {
        super(passengerNumber, maxSpeed);
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {
        return "Aeroplane{" +
                "fuelConsumption=" + fuelConsumption +
                ", passengerNumber=" + passengerNumber +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    // Getters and Setters
    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}

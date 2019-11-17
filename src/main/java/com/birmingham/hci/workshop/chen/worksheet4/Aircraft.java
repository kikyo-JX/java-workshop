package com.birmingham.hci.workshop.chen.worksheet4;

/**
 * The class describes an aircraft using the passengerNumber to
 * record the number of passengers and the maxSpeed to demonstrate
 * the max speed oif the aircraft.
 *
 * User: Chen Liu
 * Date: 2019/11/16
 * Time: 10:34 pm
 */
public class Aircraft {

    /**
     * Passenger number
     */
    protected int passengerNumber;

    /**
     * max speed
     */
    protected int maxSpeed;

    /**
     * Constructor
     *
     * @param passengerNumber passengerNumber
     * @param maxSpeed        maxSpeed
     */
    public Aircraft(int passengerNumber, int maxSpeed) {
        this.passengerNumber = passengerNumber;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "passengerNumber=" + passengerNumber +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    // Getters and Setters
    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}

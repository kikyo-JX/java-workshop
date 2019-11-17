package com.learning.worksheet4.Ex1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.birmingham.hci.workshop.chen.worksheet4.Aeroplane;
import com.birmingham.hci.workshop.chen.worksheet4.Aircraft;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Public tests for Exercise 1, Worksheet 4.
 * 
 * @author Alexandros Evangelidis
 * @version 2019-11-11
 */
public class AircraftTests {
  public static final double TOLERANCE = 0.0000000001;
  private Aircraft aircraft1, aircraft2;
  private Aeroplane aeroplane;

  @BeforeEach
  public void init() {

    aircraft1 = new Aircraft(300, 870);
    aeroplane = new Aeroplane(350, 850, 13);
    aircraft2 = new Aeroplane(280, 800, 14.5);
  }

  // testing getters of aircraft1
  @Test
  public void test1() {

    int expectedNumOfPassengers = 300;
    int actualNumOfPassengers = aircraft1.getPassengerNumber();
    assertEquals(expectedNumOfPassengers, actualNumOfPassengers);

    int expectedMaxSpeed = 870;
    int actualMaxSpeed = aircraft1.getMaxSpeed();
    assertEquals(expectedMaxSpeed, actualMaxSpeed);
  }

  // testing getters of aeroplane
  @Test
  public void test2() {

    int expectedNumOfPassengers = 350;
    int actualNumOfPassengers = aeroplane.getPassengerNumber();
    assertEquals(expectedNumOfPassengers, actualNumOfPassengers);

    int expectedMaxSpeed = 850;
    int actualMaxSpeed = aeroplane.getMaxSpeed();
    assertEquals(expectedMaxSpeed, actualMaxSpeed);

    double expectedFuelCons = 13;
    double actualFuelCons = aeroplane.getFuelConsumption();
    assertEquals(expectedFuelCons, actualFuelCons, TOLERANCE, "");
  }

  // testing setters of aircraft1
  @Test
  public void test3() {

    aircraft1.setPassengerNumber(320);
    int expectedNumOfPassengers = 320;
    int actualNumOfPassengers = aircraft1.getPassengerNumber();
    assertEquals(expectedNumOfPassengers, actualNumOfPassengers);

    aircraft1.setMaxSpeed(770);
    int expectedMaxSpeed = 770;
    int actualMaxSpeed = aircraft1.getMaxSpeed();
    assertEquals(expectedMaxSpeed, actualMaxSpeed);
  }

  // testing setters of aeroplane
  @Test
  public void test4() {

    aeroplane.setPassengerNumber(365);
    int expectedNumOfPassengers = 365;
    int actualNumOfPassengers = aeroplane.getPassengerNumber();
    assertEquals(expectedNumOfPassengers, actualNumOfPassengers);

    aeroplane.setMaxSpeed(863);
    int expectedMaxSpeed = 863;
    int actualMaxSpeed = aeroplane.getMaxSpeed();
    assertEquals(expectedMaxSpeed, actualMaxSpeed);


    aeroplane.setFuelConsumption(13.95);
    double expectedFuelCons = 13.95;
    double actualFuelCons = aeroplane.getFuelConsumption();
    assertEquals(expectedFuelCons, actualFuelCons, TOLERANCE, "");
  }


  // testing getters of aircraft2
  @Test
  public void test5() {

    int expectedNumOfPassengers = 280;
    int actualNumOfPassengers = aircraft2.getPassengerNumber();
    assertEquals(expectedNumOfPassengers, actualNumOfPassengers);

    int expectedMaxSpeed = 800;
    int actualMaxSpeed = aircraft2.getMaxSpeed();
    assertEquals(expectedMaxSpeed, actualMaxSpeed);
  }

  // testing setters of aircraft2
  @Test
  public void test6() {

    aircraft2.setPassengerNumber(290);
    int expectedNumOfPassengers = 290;
    int actualNumOfPassengers = aircraft2.getPassengerNumber();
    assertEquals(expectedNumOfPassengers, actualNumOfPassengers);

    aircraft2.setMaxSpeed(835);
    int expectedMaxSpeed = 835;
    int actualMaxSpeed = aircraft2.getMaxSpeed();
    assertEquals(expectedMaxSpeed, actualMaxSpeed);
  }
}

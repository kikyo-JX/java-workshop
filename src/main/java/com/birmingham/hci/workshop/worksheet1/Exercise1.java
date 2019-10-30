package com.birmingham.hci.workshop.worksheet1;

public class Exercise1 {

    public static void main(String[] args) {
        System.out.println(areaCircle(0));
        System.out.println(areaCircle(5));
        System.out.println(areaCircle(10));
    }

    public static double areaCircle(double radius) {
        return Math.PI * radius * radius;
    }
}

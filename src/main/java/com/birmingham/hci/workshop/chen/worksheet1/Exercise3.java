package com.birmingham.hci.workshop.chen.worksheet1;

/**
 * User: Chen Liu
 * Date: 2019/10/6
 * Time: 9:46 pm
 */
public class Exercise3 {

    public static int timeToAngle(int hours, int minutes) {
//        return (int) ((hours * 30 + Math.round(minutes * 30 / 60.0) - minutes * 6 + 360) % 360);
        return (int) Math.round(Math.abs(30 * hours + 0.5 * minutes + (360 - 6 * minutes)) % 360);
    }

    public static void main(String[] args) {
        System.out.println(timeToAngle(9, 0));
        System.out.println(timeToAngle(3, 0));
        System.out.println(timeToAngle(18, 0));
        System.out.println(timeToAngle(1, 30));
        System.out.println(timeToAngle(2, 30));
        System.out.println(timeToAngle(4, 41));
        System.out.println(timeToAngle(3, 1));
    }

}

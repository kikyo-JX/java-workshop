package com.birmingham.hci.workshop.worksheet1.week1;

/**
 * User: Chen Liu
 * Date: 2019/10/6
 * Time: 8:03 pm
 */
public class Swap {

    private int num;

    public Swap(int num) {
        this.num = num;
    }

    public static void swap(Swap a, Swap b) {
        int c = a.num;
        a.num = b.num;
        b.num = c;
    }

    public static void main(String[] args) {
        Swap a = new Swap(2);
        Swap b = new Swap(6);
        System.out.println("a = " + a.num + " b = " + b.num);
        swap(a, b);
        System.out.println("a = " + a.num + " b = " + b.num);
    }
}

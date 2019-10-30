package com.birmingham.hci.workshop.chen.worksheet1.week1;

/**
 * User: Chen Liu
 * Date: 2019/10/6
 * Time: 10:12 pm
 */
public class Hello {

    private int a;

    Hello(int a) {
        this.a = a;
    }

    public static void a(Hello b) {
        b = new Hello(2);
        System.out.println(b.a);
    }

    public static void main(String[] args) {
        Hello a = new Hello(1);
        System.out.println(a.a);
        a(a);
        System.out.println(a.a);
    }
}

package com.birmingham.hci.workshop.worksheet1.scope;

/**
 * User: Chen Liu
 * Date: 2019/10/6
 * Time: 7:28 pm
 */
public class Cat extends Animal {

    /**
     * 有没有毛
     */
    public void shut() {
        if (fur) {
            System.out.println("我有毛");
        } else {
            System.out.println("我没毛");
        }
    }
}

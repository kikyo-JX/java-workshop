package com.birmingham.hci.workshop.chen.worksheet1.scope;

/**
 * User: Chen Liu
 * Date: 2019/10/6
 * Time: 7:36 pm
 */
public class Tree {

    public void grow() {
        Animal lion = new Animal();
        lion.fur = false;
        lion.numOfLeg = 5;
        Animal tiger = new Animal();
        tiger.fur = false;
        System.err.println("Lion has fur: " + lion.fur);
        System.err.println("Tiger has fur: " + tiger.fur);
        System.err.println("Tiger has Leg = " + tiger.getNumOfLeg());
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.grow();
    }
}

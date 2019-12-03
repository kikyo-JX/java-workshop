package com.birmingham.hci.workshop.chen.worksheet5;

/**
 * User: Chen Liu
 * Date: 2019/12/1
 * Time: 7:04 pm
 */
public class Expenditure {

    /**
     * Description of expenditure
     */
    private String description;

    /**
     * Value of expenditure
     */
    private int value;

    /**
     * Constructor
     *
     * @param description description
     * @param value       value
     */
    public Expenditure(String description, int value) {
        this.description = description;
        this.value = value;
    }

    // Getters and Setters
    public String getDescription() {
        return description;
    }

    public int getValue() {
        return value;
    }

}

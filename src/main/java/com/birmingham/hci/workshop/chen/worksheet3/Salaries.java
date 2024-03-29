package com.birmingham.hci.workshop.chen.worksheet3;

import java.util.ArrayList;

/**
 * User: Chen Liu
 * Date: 2019/10/30
 * Time: 2:19 pm
 */
public class Salaries {

    /**
     * The container of the salaries of all employees
     */
    private ArrayList<double[]> allSalaries = new ArrayList<double[]>();

    /**
     * Calculate the average salary of an employee's
     *
     * @param employeeSalaries employeeSalaries
     * @return Average salary
     */
    public static double average(double[] employeeSalaries) throws IllegalArgumentException {
        // The sum of non-zero salary within 12 months
        double sum = 0;
        // The count of non-zero salary month, cuz the 0 entry should be disregarded
        int notZeroMonthCount = 0;
        for (double salary : employeeSalaries) {
            if (salary != 0) {
                sum += salary;
                notZeroMonthCount++;
            }
        }
        if (notZeroMonthCount == 0) {
            // if the salary of 12 months are all zero, throw the IllegalArgumentException
            throw new IllegalArgumentException();
        }

        return sum / notZeroMonthCount;
    }

    /**
     * Generate an ArrayList storing the average salaries of all employees.
     *
     * @return ArrayList
     */
    public ArrayList<Double> averageSalaries() {
        ArrayList<Double> averageSalaries = new ArrayList<Double>();
        for (double[] salaries : this.allSalaries) {
            try {
                // Method average may throw IllegalArgumentException
                // If no exception was thrown, add the average salary to the List
                averageSalaries.add(average(salaries));
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            }
        }

        return averageSalaries;
    }

    /**
     * Check whether for each employee with at least one non-zero monthly salary
     * their average salary is not higher than three times the overall average salary
     * of the other employees.
     * @return True or False
     */
    public boolean not3TimesHigher() {
        // Average salary of all the employees
        ArrayList<Double> averageSalaries = this.averageSalaries();
        int countOfValidEmployees = averageSalaries.size();
        double sumOfAllSalariesAverage = 0;
        for (Double average : averageSalaries) {
            sumOfAllSalariesAverage += average;
        }
        for (Double average : averageSalaries) {
            // The average of the other employees average salary
            // = (The sum of all average salaries - the average salary of this iteration's employee) /
            //   (The count of employees whose salary are not all zero - 1)
            if (average > (sumOfAllSalariesAverage - average) / (countOfValidEmployees - 1) * 3) {
                return false;
            }
        }
        return true;
    }

    /**
     * Add a salary info to the allSalaries list
     *
     * @param salary salary
     */
    public void addSalary(double[] salary) {
        this.allSalaries.add(salary);
    }

    /**
     * Get allSalaries list
     *
     * @return allSalaries
     */
    public ArrayList<double[]> getAllSalaries() {
        return this.allSalaries;
    }

    public static void main(String[] args) {
        Salaries salaries = new Salaries();
        salaries.addSalary(new double[]{1000, 1000, 2000, 2000, 0, 0, 0, 0, 0, 0, 0});
        salaries.addSalary(new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 499});
        salaries.addSalary(new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 499});
        salaries.addSalary(new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 499});
        salaries.addSalary(new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 503});
        System.out.println(salaries.averageSalaries());
        System.out.println(salaries.not3TimesHigher());
    }
}

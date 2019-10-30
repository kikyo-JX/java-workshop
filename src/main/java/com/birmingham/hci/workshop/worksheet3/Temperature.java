package com.birmingham.hci.workshop.worksheet3;

/**
 * User: Chen Liu
 * Date: 2019/10/30
 * Time: 2:14 pm
 */
public class Temperature {

    /**
     * Find the first day with the lowest temperature.
     *
     * @param temperatures temperatures
     * @return The coldest day
     */
    public static int coldest(double[] temperatures) {
        double coldestTemperatures = temperatures[0];
        int coldestDay = 1;
        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] < coldestTemperatures) {
                // If the temperature of the 'i'th day is lower than previous coldest temperature, record it
                coldestTemperatures = temperatures[i];
                coldestDay = i + 1;
            }
        }

        return coldestDay;
    }

    public static void main(String[] args) {
        double[] temperatures = new double[]{-20, -20, -10, -20, 0};
        System.out.println(coldest(temperatures));
    }
}

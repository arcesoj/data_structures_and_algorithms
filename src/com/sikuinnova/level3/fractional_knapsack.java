package com.sikuinnova.level3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by josearce on 12/20/17.
 */
public class fractional_knapsack {

    public static void main(String args[]) {

        /*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        double[] values = new double[n];
        double[] weights = new double[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextDouble();
            weights[i] = scanner.nextDouble();
        }

        System.out.println(MaximizingValueOfALoot(values, weights, capacity));
        */

        //stressTest();

        int capacity = 50;
        double[] values = {60, 100, 120};
        double[] weights = { 20, 50, 30};

        System.out.println(MaximizingValueOfALoot(values, weights, capacity));

        capacity = 1000;
        values = new double[]{ 500 };
        weights = new double[]{ 30 };
        System.out.println(MaximizingValueOfALoot(values, weights, capacity));


        capacity = 10;
        values = new double[]{ 500 };
        weights = new double[]{ 30 };
        System.out.println(MaximizingValueOfALoot(values, weights, capacity));
    }

    static double MaximizingValueOfALoot(double[] values,double[] weights,double capacity){

        double value = 0;
        if(capacity == 0)
            return 0;

        for(int i = 0; i < values.length; i++) {

            int max_index = select_max_index(values, weights);

            if (max_index >= 0) {
                double available_weights = min(capacity, weights[max_index]);
                value = value + available_weights * values[max_index] / weights[max_index];
                weights[max_index] = weights[max_index] - available_weights;
                capacity = capacity - available_weights;
            }
        }

        return value;
    }

    static int select_max_index(double[] values, double[] weights){

        int index = -1;
        double max = 0;

        for(int i = 0; i < values.length; i++) {
            if (weights[i] > 0 && (values[i] / weights[i]) > max) {
                max = values[i] / weights[i];
                index = i;
            }
        }

        return index;
    }

    static double min(double capacity, double weight){
        return capacity > weight ? weight : capacity;
    }
}

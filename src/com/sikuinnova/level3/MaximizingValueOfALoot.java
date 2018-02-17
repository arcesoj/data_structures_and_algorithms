package com.sikuinnova.level3;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by josearce on 12/19/17.
 */
public class MaximizingValueOfALoot {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        double[] values = new double[n];
        double[] weights = new double[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }

        System.out.println(MaximizingValueOfALoot(values, weights, capacity));

        /*
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
        */
    }

    static void stressTest(){

        while(true) {

            Random random = new Random();
            int capacity = (random.nextInt(1000 - 1 + 1) + 1) % 1000;
            double[] values = new double[capacity];
            double[] weights = new double[capacity];

            for (int i = 0; i < capacity; i++) {
                values[i] = (random.nextInt(10000 - 1 + 1) + 1) % 10000;
            }

            for (int i = 0; i < capacity; i++) {
                weights[i] = (random.nextInt(10000 - 1 + 1) + 1) % 10000;
            }

            System.out.println(MaximizingValueOfALoot(values, weights, capacity));

        }

    }

    private static double[] C;

    static double MaximizingValueOfALoot(double[] values, double[] weights, int capacity){

        int length = values.length;
        C = new double[length];
        double[] E = new double[length];

        for(int i = 0; i < length; i++){
            double result = (values[i] / weights[i]);
            C[i] = result;
            E[i] = result;
        }

        int[] D = new int[length];

        for(int i = 0; i < length; i++){
            D[i] = getMax();
        }

        int changeHeight = capacity;
        int index = 0;
        double sumValue = 0;

        if(length == 1 && weights[0] < capacity)  {
            return values[0];
        }

        while(changeHeight > 0){

            int indexD = D[index];
            double maxValue = E[indexD];
            double weight = weights[indexD];

            if(weight <= changeHeight) {
                changeHeight -= weight;
                sumValue += values[indexD];
            } else if(maxValue >= changeHeight && sumValue == 0) {
                changeHeight -= weight;
                double result = values[indexD] / weights[indexD];
                sumValue += result * capacity;
            }

            index++;

            if(index >= D.length)  {
                break;
            }
        }

        return Math.round(sumValue * 1000)/1000.000d;
    }

    static int getMax(){
        double max = 0;
        int indexMax = 0;

        for(int i = 0; i < C.length; i++){
            if( C[i] > max ){
                max = C[i];
                indexMax = i;
            }
        }

        C[indexMax] = 0;

        return indexMax;
    }

}

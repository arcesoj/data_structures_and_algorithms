package com.sikuinnova.week5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by josearce on 1/7/18.
 */
public class Knapsack {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }


    static int optimalWeight(int W, int[] w){

        int n = w.length;
        int[][] dp_result = new int[n + 1][W + 1];

        for (int[] row: dp_result)
            Arrays.fill(row, 0);

        for(int i = 1; i < n + 1; i++) {

            for(int weight = 1; weight < W + 1; weight++){

                dp_result[i][weight] = dp_result[i - 1][weight];

                if(w[i-1] <= weight){

                    int val = dp_result[i - 1][weight - w[i - 1]] + w[i - 1];

                    if(val > dp_result[i][weight]){
                        dp_result[i][weight] = val;
                    }

                }

            }

        }

        return dp_result[n][W];

    }


    static int optimalWeight2(int W, int[] m){

        int[] w = new int[m.length + 1];

        for(int i = 1; i < w.length; i++){
            w[i] = m[i - 1];
        }

        int items = w.length;
        int capacity = W + 1;

        int[][] weights = new int[W + 1][w.length];

        for(int j = 1; j < items; j++) {

            for(int i = 1; i < capacity; i++) {

                int prev = weights[i][j-1];
                int cur = w[j] + weights[W - w[j]][j - 1];

                if(cur > i){
                    weights[i][j] = prev;
                } else {
                    weights[i][j] = Math.max(prev, cur);
                }

            }
        }

        System.out.println(Arrays.deepToString(weights));
        return weights[W][w.length - 1];
    }

}

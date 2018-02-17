package com.sikuinnova.level3;

import java.util.Scanner;

/**
 * Created by josearce on 12/19/17.
 */
public class ChangingMoney {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();

        System.out.println(changing_money(a));
    }

    static int changing_money(int a){

        int[] A = {10, 5, 1};
        int[] B = {0, 0, 0};

        int changeAmount = a;
        int index = 0;

        while(changeAmount > 0){

            int maxValue = A[index];

            if(maxValue <= changeAmount){
                changeAmount -= maxValue;
                B[index] += 1;
            } else {
                index++;
            }
        }

        int sum = 0;

        for(int i = 0; i < B.length; i++){
            sum += B[i];
        }

        return sum;
    }

}

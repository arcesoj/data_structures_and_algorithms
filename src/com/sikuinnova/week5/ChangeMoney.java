package com.sikuinnova.week5;

import java.util.Arrays;

/**
 * Created by josearce on 1/5/18.
 */
public class ChangeMoney {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(greedyAlgorithms(40)));

        int[] coins = {1, 5 , 20};
        System.out.println(Arrays.toString(recursiveChange(40, coins)));

        System.out.println(DPChange(40, coins));
    }

    static int[] greedyAlgorithms(int money) {

        int[] change = new int[3];
        int[] coins = {5, 10, 25};

        while(money > 0) {

            int position = 0;
            int coin = 0;

            for(int i = coins.length - 1; i >= 0; --i){
                coin = coins[i];
                if(coin < money){
                    position = i;
                    break;
                }
            }

            change[position]++;
            money -= coin;
        }

        return change;
    }

    static int[] recursiveChange(int money, int[] coins){

        if(money == 0){
            return new int[0];
        }

        int[] change = new int[coins.length];
        for(int i = 0; i < coins.length; i++) {

            int coin = coins[i];
            if(money >= coin) {

                int[] numcoins = recursiveChange(money - coin, coins);

                if(sumCoins(numcoins) < sumCoins(change)) {
                    change[i] = numcoins[i] + 1;
                }

            }
        }

        return change;
    }

    static int DPChange(int money, int[] coins){

        int[] min_coins = new int[money + 1];
        Arrays.fill(min_coins, money);
        min_coins[0] = 0;

        for(int m = 1; m < money + 1; m++){

            for(int coin : coins){

                if(m >= coin){
                    int value = min_coins[m - coin] + 1;
                    if(value < min_coins[m]){
                        min_coins[m] = value;
                    }
                }
            }
        }

        return min_coins[money];
    }

    static int minNumCoins(int value){
        return 0;
    }

    static int sumCoins(int[] coins){

        int sum = 0;

        for(int i = 0; i < coins.length; i++){
            sum += coins[i];
        }

        return sum;
    }
}

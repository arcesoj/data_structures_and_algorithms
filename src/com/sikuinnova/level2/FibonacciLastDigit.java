package com.sikuinnova.level2;

import java.util.*;

public class FibonacciLastDigit {

    private static long getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current);
        }

        return current % 10;
    }

    private static long getFibonacciLastDigitNaivePro(int n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % 10;
        }

        return current;
    }
    
    public static void main(String[] args) {
        stressTest();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long c = getFibonacciLastDigitNaivePro(n);
        System.out.println(c);
    }

    static void stressTest(){

        while(true){

            Random random = new Random();
            int a = (random.nextInt(50 - 1 + 1) + 1) % 50;
            System.out.println("A : "+a);

            long res1 = getFibonacciLastDigitNaive(a);
            long res2 = getFibonacciLastDigitNaivePro(a);

            if( res1 != res2){
                System.out.println("\nWrong answer: "+res1+" "+res2);
                break;
            } else {
                System.out.println("\nOK ........ ===> \n"+a);
            }
        }
    }
}


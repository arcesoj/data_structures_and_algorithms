package com.sikuinnova.level2;

import java.util.Random;
import java.util.Scanner;

public class Fibonacci {

  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    return calc_fib(n - 1) + calc_fib(n - 2);
  }

  private static long calc_fib2(int n){

    if(n <= 1){
        return n;
    }

    long previous = 0;
    long current = 1;
    long sum = 0;

    for(int i = 2; i <= n; i++) {
      sum = previous + current;
      previous = current;
      current = sum;
    }

    return sum;
  }

  public static void main(String args[]) {

    //stressTest();

    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    System.out.println(calc_fib2(n));
  }

  static void stressTest(){

    while(true){

      Random random = new Random();
      int a = (random.nextInt(50 - 1 + 1) + 1) % 50;
      System.out.println("A : "+a);

      long res1 = calc_fib(a);
      long res2 = calc_fib2(a);

      if( res1 != res2){
        System.out.println("\nWrong answer: "+res1+" "+res2);
        break;
      } else {
        System.out.println("\nOK ........ ===> \n"+a);
      }
    }
  }

}

package com.sikuinnova.level2;

import java.util.*;

public class GCD {

  private static int gcd_naive(int a, int b) {
    int current_gcd = 1;


    for(int d = 2; d <= a && d <= b; ++d) {
      if (a % d == 0 && b % d == 0) {
        if (d > current_gcd) {
          current_gcd = d;
        }
      }
    }

    return current_gcd;
  }

  private static int gcd_pro(int a, int b){

    //System.out.println("A: "+a+" B: "+b);

    if(b <= 1){
      return (b == 0) ? a : 1;
    }

    // 1344, 217 = 42
    // 217, 42 = 7
    // 42, 7 = 0
    // 7, 0 =

    return gcd_pro(b, a % b);
  }

  public static void main(String args[]) {

    //stressTest();

    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd_pro(a, b));
  }

  static void stressTest(){

    while(true){

      int max = 1000;
      int min = 1;

      Random random = new Random();
      int a = random.nextInt((max - min) + 1) + min;
      int b = random.nextInt((max - min) + 1) + min;

      long res1 = gcd_naive(a, b);
      long res2 = gcd_pro(a, b);

      if( res1 != res2){
        System.out.println("\nWrong answer: "+res1+" "+res2);
        break;
      } else {
        System.out.println("\nOK ........ ===> \n\n");
      }
    }
  }
}

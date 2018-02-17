package com.sikuinnova.level2;

import java.util.*;

public class LCM {

  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

  private static long lcm_pro(long a, long b) {

    long x =  gcd_pro(a,b);
    long y = (a * b);
    return y / x;
  }

  private static long gcd_pro(long a, long b){
    if(b <= 1){
      return (b == 0) ? a : 1;
    }

    System.out.println(gcd_pro(b, a % b));

    return gcd_pro(b, a % b);
  }


  public static void main(String args[]) {

    //stressTest();

    Scanner scanner = new Scanner(System.in);
    long a = scanner.nextInt();
    long b = scanner.nextInt();

    System.out.println(lcm_pro(a,b));
  }

  static void stressTest(){

    while(true){

      int max = 10000;
      int min = 1;

      Random random = new Random();
      int a = random.nextInt((max - min) + 1) + min;
      int b = random.nextInt((max - min) + 1) + min;

      long res1 = lcm_naive(a, b);
      long res2 = lcm_pro(a, b);

      if( res1 != res2){
        System.out.println("\nWrong answer: "+res1+" "+res2);
        break;
      } else {
        System.out.println("\nOK ........ ===> \n\n");
      }
    }
  }
}

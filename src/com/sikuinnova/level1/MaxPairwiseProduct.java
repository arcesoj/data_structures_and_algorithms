package com.sikuinnova.level1;

import java.util.*;
import java.io.*;
/**
 * Created by josearce on 12/6/17.
 */

public class MaxPairwiseProduct {


    static long getMaxPairwiseProduct(long[] numbers) {
        long result = 0;
        long n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (numbers[i] * numbers[j] > result) {
                    result = numbers[i] * numbers[j];
                }
            }
        }
        return result;
    }

    static long getMaxPairwiseProductFast(long[] numbers){

        long n = numbers.length;
        int max_index_1 = -1;

        for(int i = 0; i < n; i++){
            if(max_index_1 == -1 || numbers[i] > numbers[max_index_1]){
                max_index_1 = i;
            }
        }

        int max_index_2 = -1;
        for(int j = 0; j < n; j++) {
            if( max_index_1 != j && ((max_index_2 == -1) || (numbers[j] > numbers[max_index_2]))) {
                max_index_2 = j;
            }
        }

        //System.out.println("\nIndex 1 : "+max_index_1+" Index 2: "+max_index_2);

        long result = numbers[max_index_1] * numbers[max_index_2];

        return result;
    }

    public static void main(String[] args) {

        //stressTest();

        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        //long result1 = getMaxPairwiseProduct(numbers);
        //long result2 = getMaxPairwiseProductFast(numbers);
        //System.out.println(result1+" <- 1 and 2 -> "+result2);

        System.out.println(getMaxPairwiseProductFast(numbers));
    }

    static void stressTest(){

        while(true){

            Random random = new Random();
            int n = random.nextInt(10) + 2;

            System.out.println(n);
            long[] a = new long[n];

            for(int i = 0; i < n; ++i){
                a[i] = (random.nextInt(10000 - 1 + 1) + 1) % 10000;// random.nextInt() % 10000;
            }

            for(int i = 0; i < n; ++i){
                System.out.print(a[i]+" ");
            }

            long res1 = getMaxPairwiseProduct(a);
            long res2 = getMaxPairwiseProductFast(a);

            if( res1 != res2){
                System.out.println("\nWrong answer: "+res1+" "+res2);
                break;
            } else {
                System.out.println("\nOK ........\n");
            }
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

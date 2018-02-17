package com.sikuinnova.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * Created by josearce on 12/28/17.
 */
public class BinarySearch {

    static boolean debug = false;

    static int binarySearch(int[] a, int x) {
        int left = 0;
        int right = a.length - 1;

        while (left <= right) {

            int mid = left + ((right - left) / 2);

            if(x < a[mid]){
                right = mid - 1;
            } else if(x > a[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {

        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];

        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        /*
        stressTest();

        int m = 5;
        int[] a = {1, 5, 8, 12, 13, 14};
        int[] b = {14, 13, 12, 8, 5, 1};
        */

        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            System.out.println(binarySearch(a, b[i]) + " ");
        }
    }

    static void stressTest(){

        while(true) {

            Random random = new Random();
            int m = 10;//(random.nextInt(50 - 1 + 1) + 1) % 50;

            int[] a = new int[m];
            for (int i = 0; i < m; i++) {
                a[i] = (random.nextInt(50 - 1 + 1) + 1) % 50;
            }

            int[] b = new int[m];
            for (int j = 0; j < m; j++) {
                b[j] = (random.nextInt(50 - 1 + 1) + 1) % 50;
            }

            Arrays.sort(a);

            for (int i = 0; i < m; i++) {

                int binary = binarySearch(a, b[i]);
                int linear = linearSearch(a, b[i]);

                if (binary != linear) {
                    System.out.println("X: " + b[i] + " binary: " + Arrays.toString(a) + " length :" + a.length);
                    debug = true;
                    binarySearch(a, b[i]);
                    System.out.println("Wrong answer: " + binary + " " + linear+"\n");
                    break;
                }
            }

            debug = false;
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

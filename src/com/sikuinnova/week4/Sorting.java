package com.sikuinnova.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * Created by josearce on 1/2/18.
 */
public class Sorting {

    private static Random random = new Random();

    private static int[] partition3(int[] a, int l, int r) {
        //write your code here
        int x = a[l];
        int i = l;

        while (true) {
            if (a[i] < x) {
                swap(a, i++, l++);
            } else if (a[i] > x) {
                swap(a, i, r--);
            } else {
                i++;
            }

            if(i > r){
                break;
            }
        }

        return new int[]{r, l};
    }

    // swap
    static void swap(int[] array, int index1, int index2) {
        int swap = array[index2];
        array[index2] = array[index1];
        array[index1] = swap;
    }


    private static int partition2(int[] a, int l, int r) {
        int x = a[l]; // the number we are looking
        int j = l; //Left initial
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        median3(a, l, k);
        //use partition3
        int[] m = partition3(a, l, r);
        randomizedQuickSort(a, l, m[0] - 1);
        randomizedQuickSort(a, m[1] + 1, r);
    }

    // median 3
    static void median3(int[] array, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        if (array[lo] > array[hi])
            swap(array, lo, hi);
        if (array[mid] > array[hi])
            swap(array, mid, hi);
        if (array[mid] < array[lo])
            swap(array, lo, mid);

        swap(array, mid, lo);
    }

    private static void randomizedQuickSort2(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        //use partition3
        int m = partition2(a, l, r);
        randomizedQuickSort(a, l, m - 1);
        randomizedQuickSort(a, m + 1, r);
    }

    public static void main(String[] args) {

        stressTest();

        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);

        System.out.println(Arrays.toString(a));
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }


    static void stressTest(){
/*
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

                int binary = randomizedQuickSort(a, b[i]);
                int linear = randomizedQuickSort2(a, b[i]);

                if (binary != linear) {
                    System.out.println("X: " + b[i] + " binary: " + Arrays.toString(a) + " length :" + a.length);
                    System.out.println("Wrong answer: " + binary + " " + linear+"\n");
                    break;
                }
            }

        }
        */
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

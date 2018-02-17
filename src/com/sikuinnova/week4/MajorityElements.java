package com.sikuinnova.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by josearce on 12/30/17.
 */
public class MajorityElements {

    static List<List<Integer>> getMajorityElement(Integer[] a, int left, int rigth){

        if(left + 1 == rigth){
            List<List<Integer>> tuplas = new ArrayList<>();

            List<Integer> b = new ArrayList<>();
            b.add(a[left]);
            tuplas.add(b);
            tuplas.add(new ArrayList<>());
            //System.out.println("Tupla: "+tuplas.toString());
            return tuplas;
        }

        int mid = ( left + (rigth - left) / 2);

        //System.out.println("Left: "+left+" Rigth: "+rigth+" Mid: "+mid);
        List<List<Integer>> left_half = getMajorityElement(a,left, mid);
        List<List<Integer>> right_half = getMajorityElement(a, mid, rigth);

        //System.out.println("left_half: "+left_half.toString());
        //System.out.println("right_half: "+right_half.toString());

        return countMerge(left_half, right_half);
    }

    static List<List<Integer>> countMerge(List<List<Integer>> left_half,List<List<Integer>> rigth_half){

        List<List<Integer>> one = chunkProcess(left_half.get(0), rigth_half.get(1));
        List<Integer> left_major = one.get(0);
        List<Integer> rigth_minor = one.get(1);

        List<List<Integer>> two = chunkProcess(rigth_half.get(0), left_half.get(1));
        List<Integer> rigth_major = two.get(0);
        List<Integer> left_minor = two.get(1);

       // System.out.println(" left_majors "+left_major+" right_majors "+rigth_major);

        if(left_major.get(0).equals(rigth_major.get(0))) {
            //return [left_majors + right_majors, left_minors + right_minors]

            List<List<Integer>> tupla = new ArrayList<>();
            // left_majors + right_majors
            left_major.addAll(rigth_major);
            tupla.add(left_major);
            //  left_minors + right_minors
            left_minor.addAll(rigth_minor);
            tupla.add(left_minor);

            //System.out.println("1 IF "+tupla.toString());
            return tupla;
        } else if(left_major.size() > rigth_major.size()){
            List<List<Integer>> tupla = new ArrayList<>();

            //return [left_majors, right_majors + left_minors + right_minors]
            tupla.add(left_major);

            rigth_major.addAll(left_minor);
            rigth_major.addAll(rigth_minor);
            tupla.add(rigth_major);

            //System.out.println("2 IF "+tupla.toString());
            return tupla;
        }

        // return [right_majors, left_majors + right_minors + left_minors]
        List<List<Integer>> tupla = new ArrayList<>();

        tupla.add(rigth_major);

        left_major.addAll(rigth_minor);
        left_major.addAll(left_minor);
        tupla.add(left_major);

        //System.out.println("3 IF "+tupla.toString());
        return tupla;
    }

    static List<List<Integer>> chunkProcess(List<Integer> majors, List<Integer> minors){

        List<Integer> left = new ArrayList<>();

        for(int i = 0; i < minors.size(); i++) {
            if (majors.get(0).equals(minors.get(i))) {
                majors.add(minors.get(i));
            } else {
                left.add(minors.get(i));
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        list.add(majors);
        list.add(left);

        //System.out.println("List list: "+majors.toString());

        return list;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        //int n = 4;
        //Integer[] a = {1, 2, 3, 4};

        //System.out.println(Arrays.toString(a));
        List<List<Integer>> result = getMajorityElement(a, 0, n);

        //System.out.println(result.toString());
        if (result.get(0).size() > a.length / 2) {
            System.out.println(1);
        } else {
            System.out.println(0);
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

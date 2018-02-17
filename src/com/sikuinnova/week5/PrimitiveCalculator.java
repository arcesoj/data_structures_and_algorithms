package com.sikuinnova.week5;

import java.util.*;

/**
 * Created by josearce on 1/7/18.
 */
public class PrimitiveCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = dynamicSequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }

    private static List<Integer> dynamicSequence(int n) {
        int[] a = new int[n + 1];
        int[] predecessor = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            a[i] = a[i - 1] + 1;
            predecessor[i] = i - 1;
            if (i % 3 == 0) {
                if (a[i / 3] < a[i]) {
                    a[i] = a[i / 3] + 1;
                    predecessor[i] = i / 3;
                }
            }
            if (i % 2 == 0) {
                if (a[i / 2] < a[i]) {
                    a[i] = a[i / 2] + 1;
                    predecessor[i] = i / 2;
                }
            }
        }

        List<Integer> sequence = new ArrayList<>();

        for (int i = n; i != 0; i = predecessor[i]) {
            sequence.add(i);
        }

        Collections.reverse(sequence);
        return sequence;
    }

    static String getMinimunOperations(int n){

        int[] hop_count = new int[n +1];

        Arrays.fill(hop_count, 0);
        hop_count[0] = 0;
        hop_count[1] = 1;

        for(int i = 2; i < n + 1; i++){

            List<Integer> indices = new ArrayList<>();

            if(i % 2 == 0)
                indices.add(i / 2);
            if(i % 3 == 0)
                indices.add(i / 3);

            //[hop_count[x] for x in indices];
            int min_hops = 2;//getMin();

            hop_count[i] = min_hops + 1;

        }


        int ptr = n;
        List<Integer> optimal_seq = new ArrayList<>();

        while(ptr != 1){

            List<Integer> candidates = new ArrayList<>();

            if(ptr % 2 == 0){
                candidates.add(ptr / 2);
            }

            if(ptr % 3 == 0){
                candidates.add(ptr / 3);
            }

            //ptr = min([(c, hop_count[c]) for c in candidates], key=lambda x: x[1] )[0]
            ptr = 7; //

            optimal_seq.add(ptr);

        }

        return optimal_seq.toString();
    }

}

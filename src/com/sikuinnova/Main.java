package com.sikuinnova;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int a  = 421;
        int b = 111;

        while(b > 0){

            int r = a % b;
            a = b;
            b = r;

        }

        System.out.print(a);
    }
}

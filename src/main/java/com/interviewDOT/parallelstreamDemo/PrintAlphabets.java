package com.interviewDOT.parallelstreamDemo;

import java.util.ArrayList;
import java.util.List;

public class PrintAlphabets {

    public static void main(String[] args) {

        System.out.println("Seqential Stream...");

        List<String> alpha = getData();
        alpha.forEach(x ->
                System.out.println("Thread : " + Thread.currentThread().getName() + ", alphabet: " + x));

        System.out.println("Parallel Stream...");

        List<String> alpha2 = getData();
        alpha2.parallelStream().forEach(x ->
                System.out.println("Thread : " + Thread.currentThread().getName() + ", alphabet: " + x)
        );

    }

    private static List<String> getData() {

        List<String> alpha = new ArrayList<>();

        int n = 97;  // 97 = a , 122 = z
        while (n <= 122) {
            char c = (char) n;
            alpha.add(String.valueOf(c));
            n++;
        }

        return alpha;
    }
}

package com.interviewDOT.parallelstreamDemo;

import java.util.stream.IntStream;

public class PrintParallelThreads {

    public static void main(String[] args) {

        System.out.println("Sequential Stream...");

        IntStream range = IntStream.rangeClosed(1, 10);
        range.forEach(x -> {
            System.out.println("Thread : " + Thread.currentThread().getName() + ", value: " + x);
        });

        System.out.println("Parallel Stream...");

        IntStream range2 = IntStream.rangeClosed(1, 10);
        range2.parallel().forEach(x -> {
            System.out.println("Thread : " + Thread.currentThread().getName() + ", value: " + x);
        });

    }
}

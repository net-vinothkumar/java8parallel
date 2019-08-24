package com.interviewDOT.parallelstreamDemo;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OneMillionPrime {
    public static void main(String[] args) {

        long count = getCountOfPrimeNumberUsingSequential();
//        long count = getCountOfPrimeNumberUsingParallel();
        System.out.println("\nTotal: " + count);
    }

    private static long getCountOfPrimeNumberUsingSequential(){
        return Stream.iterate(0, n -> n + 1)
                .limit(1_000_000)
                .filter(OneMillionPrime::isPrime)
                .peek(x -> System.out.format("%s\t", x))
                .count();
    }

    private static long getCountOfPrimeNumberUsingParallel(){
        return Stream.iterate(0, n -> n + 1)
                .limit(1_000_000)
                .parallel()   //with this 23s, without this 1m 10s
                .filter(OneMillionPrime::isPrime)
                .peek(x -> System.out.format("%s\t", x))
                .count();
    }

    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        return !IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
    }

}

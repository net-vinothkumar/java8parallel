package com.interviewDOT.parallelstreamDemo;

import java.util.stream.IntStream;

public class PrintNumbers {

	public static void main(String[] args) {
		System.out.println("Sequential Stream...");

		IntStream normalIntRange = IntStream.rangeClosed(1, 12);
		normalIntRange.forEach(System.out::println);

		System.out.println();
		System.out.println("Parallel Stream...");

		IntStream parallelIntRange = IntStream.rangeClosed(1, 12);
		parallelIntRange.parallel().forEach(System.out::println);
	}
}

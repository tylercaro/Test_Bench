package com.eintern.algorithms;

public class Fibonacci {

	public static long fibonacci(long number) {
		if ((number == 0) || (number == 1)) // base cases
			return number;
		else
			// recursion step
			return fibonacci(number - 1) + fibonacci(number - 2);
	}

	// MAIN
	public static void main(String[] args) {
		for (int counter = 0; counter <= 10; counter++)
			System.out.println( fibonacci(counter));
	}

}

package com.airline.util;

import org.springframework.util.StopWatch;

public class Fibonacci {
	
	// calculate(30) -> 5ms
	// calculate(32) -> 12ms
	// calculate(35) -> 55ms
	// calculate(36) -> 80ms
	// calculate(38) -> 220ms
	// calculate(40) -> 550ms
	// calculate(42) -> 1400ms
	public static int calculate(int n) {
		if(n == 0 || n== 1) {
			return n;
		} else {
			return calculate(n-1) + calculate(n-2);
		}
	}
	
	public static void main(String[] args) {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		calculate(42); // 
		stopWatch.stop();
		System.out.println("Elapsed Time: " + stopWatch.getTotalTimeMillis());
	}
}

package Simple;

import java.util.Scanner;

public class Fibonacci_Numbers {
	public static void main ( String[] args ) {
		Scanner scanner = new Scanner( System.in );
		int fib1 = 1;
		int fib2 = 1;
		int fib_q = 0;
		final int Q = scanner.nextInt();
		while ( fib_q <= Q ) {
			boolean isPrime = true;
			fib_q = fib1 + fib2;
			fib1 = fib2;
			fib2 = fib_q;
			if (fib_q % 2 == 0 && fib_q != 2) isPrime = false;
			else {
				for ( int i = 3; i < fib_q; i += 2 ) {
					if (fib_q % i == 0) {
						isPrime = false;
						break;
					}
				}
			}
			if ( fib_q <= Q && isPrime) System.out.println( fib_q );
		}
	}
}

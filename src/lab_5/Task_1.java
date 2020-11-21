package lab_5;

import java.util.*;

public class Task_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		double[] numbers = new double[n];
		int n0 = 1;
		int n1 = 1;
		int n2 = 0;
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = scanner.nextDouble();
		}
		if (n > 1) {
			System.out.println(numbers[1]);
		}

		while (n2 < n) {
			try {
				n2 = n1 + n0;
				System.out.println(numbers[n2]);
				n0 = n1;
				n1 = n2;
			} catch (java.lang.ArrayIndexOutOfBoundsException e) {
				break;
			}
		}
	}
}

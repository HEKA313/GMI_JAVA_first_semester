package lab_5;

import java.util.*;

public class Task_2_True {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		double[] numbers = new double[n];
		for (int i = 0; i < numbers.length; i++) numbers[i] = scanner.nextDouble();
		for (int i = 2; i < numbers.length - 1; i += 3) {
			numbers[i] = (numbers[i - 1] + numbers[i - 2]) / 2;
			numbers[i + 1] = (numbers[i - 1] + numbers[i + 1]) / 2;
		}
		for (double number : numbers) System.out.println(number);
	}
}

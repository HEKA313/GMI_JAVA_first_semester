package lab_5;

import java.util.*;

public class Task_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		double[] numbers = new double[n];
		numbers[0] = scanner.nextDouble();
		double sum = numbers[0];
		double max = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			numbers[i] = scanner.nextDouble();
			sum += numbers[i];
			if (numbers[i] > max) {
				max = numbers[i];
			}
		}
		System.out.printf("Среднее арифметическое равно: %f\n", (sum / numbers.length));
		System.out.printf("Максимальный элемент массива равен: %f\n", max);
		System.out.printf("Величина отклонения максимального элемента от среднего арифметического равна: %f\n", (max - sum / numbers.length));
	}
}

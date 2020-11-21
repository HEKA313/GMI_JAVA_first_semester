package lab_5;

import java.util.Scanner;

public class Task_3_True {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите n");
		int n = scanner.nextInt();
		double[] numbers = new double[n];
		System.out.println("Введите элемент");
		double num = scanner.nextDouble();
		System.out.println("Введите k");
		int k = scanner.nextInt();
		if (k > n) System.out.println("Элемента с номером k - нет");
		else {
			int neg = -1;
			for (int i = 0; i < numbers.length; i++) {
				numbers[i] = scanner.nextDouble();
				if (numbers[i] < 0 && neg == -1) {
					neg = i;
				}
			}
			if (neg >= 1 && k >= 1) {
				numbers[neg - 1] = num;
				numbers[k - 1] = num;
			} else if (neg == -1) System.out.println("Отрицательного элемента - нет");
			else System.out.println("Перед элементом k, либо перед отрицательным элементом нет места");

			for (double number : numbers) System.out.println(number);
		}
	}
}
package lab_5;

import java.util.*;

public class Task_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите n");
		int n = scanner.nextInt();
		System.out.println("Введите x");
		double x = scanner.nextDouble();
		double[] a = new double[n];
		double sum = 0;
		for (int i = 0; i < a.length; i++) {
			a[i] = scanner.nextDouble();
		}
		for (int i = a.length - 1; i >= 0; i--) {
			sum += a[i] * Math.pow(x, i + 1);
		}
		System.out.printf("Сумма многочлена равна: %f", sum);
	}
}

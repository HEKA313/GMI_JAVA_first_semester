package lab_5;

import java.util.*;

public class Task_4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		double[] x = new double[n];
		double comp = 1;
		double comp_temp;
		for (int i = 0; i < x.length; i++) {
			x[i] = scanner.nextDouble();
		}
		double max = x[0] * 2 * x[1] * x[2];
		for (int i = 0; i < x.length - 2; i++) {
			comp_temp = (x[i] * 2 * x[i + 1] * x[i + 2]);
			comp *= comp_temp;
			if (comp_temp > max) {
				max = comp_temp;
			}
		}
		System.out.printf("Произведение равно: %f\n", comp);
		System.out.printf("Максимальный сомножитель этого произведения равен: %f", max);
	}
}

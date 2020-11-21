package lab_5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task_4_True {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		System.out.println("Введите n");
		int n = scanner.nextInt();
		System.out.println("Введите m");
		int m = scanner.nextInt();
		int[] a = new int[n];
		int[] b = new int[m];
		int[] c;
		int z = 0;
		boolean check = false;
		if (n > m) c = new int[n];
		else c = new int[m];
		Arrays.fill(c, -1);
		for (int i = 0; i < a.length; i++) {
			a[i] = random.nextInt(10);
			System.out.println(a[i]);
		}
		System.out.println("\n\n");
		for (int i = 0; i < b.length; i++) {
			b[i] = random.nextInt(10);
			System.out.println(b[i]);
		}
		System.out.println("\n\n");
		for (int k : a) {
			for (int i : b) {
				if (k == i) {
					for (int value : c) {
						if (value == k) {
							check = false;
							break;
						}
						check = true;
					}
					if (check) {
						check = false;
						c[z] = k;
						z++;
						break;
					}
				}
			}
		}
		for (int i : c) if (i != -1) System.out.println(i);
	}
}
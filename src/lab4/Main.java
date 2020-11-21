package lab4;

import java.util.*;
import java.text.DecimalFormat;

public class Main {
	public static void main(String[] args) {
		Scanner Scanner = new Scanner(System.in);
		cycle:
		while (true) {
			System.out.println("1. Задача 1");
			System.out.println("2. Задача 2");
			System.out.println("3. Задача 3");
			System.out.println("4. Задача 4");
			System.out.println("5. Задача 5");
			System.out.println("6. Задача 6");
			System.out.println("7. Задача 7");
			System.out.println("8. Выход");
			System.out.println("Выберите пункт меню (1..8)");
			int c = Scanner.nextInt();
			switch (c) {
				case 1:
					Tasks.task_1();
					break;
				case 2:
					Tasks.task_2();
					break;
				case 3:
					Tasks.task_3();
					break;
				case 4:
					Tasks.task_4();
					break;
				case 5:
					Tasks.task_5();
					break;
				case 6:
					Tasks.task_6();
					break;
				case 7:
					Tasks.task_7();
					break;
				default:
					break cycle;
			}
		}
	}
}

class Tasks {
	static void task_1() {
		Scanner Scanner = new Scanner(System.in);
		double a = Scanner.nextDouble(), b = Scanner.nextDouble(), c = Scanner.nextDouble();
		double average = Math.cbrt(a * b * c);
		int temp = (int) average;
		System.out.println(average);
		System.out.println(average - temp);
	}

	static void task_2() {
		Scanner Scanner = new Scanner(System.in);
		boolean isSpecial = false;
		double x = Scanner.nextDouble();
		int decade = ((int) x / 10) % 10;
		int decimal = ((int) (x * 100)) % 10;
		if (decade > 3 && decade <= 7 && decade > decimal) {
			isSpecial = true;
		}
		System.out.println(isSpecial);
	}

	static void task_3() {
		Scanner Scanner = new Scanner(System.in);
		double x = Scanner.nextDouble();
		final double E = Math.E;
		final double a = 0.19, b = 6.1;
		double y;
		if (x <= -1) {
			y = Math.pow(E, Math.sin(x));
		} else if (x > 5) {
			y = Math.pow(Math.log(Math.abs(b * x)), 2);
		} else {
			y = Math.sqrt(1 + Math.pow((a * x), 2));
		}
		System.out.println(y);
	}

	static void task_4() {
		Scanner Scanner = new Scanner(System.in);
		System.out.println("Введите тип операции: p, o, r, b");
		String type = Scanner.next();
		DecimalFormat format = new DecimalFormat("##.00");
		System.out.println("Введите стоимость товара");
		double price = Scanner.nextDouble();
		switch (type) {
			case "p":
				System.out.println("накрутка 0%, цена: " + format.format(price));
				break;
			case "o":
				System.out.println("накрутка 5%, цена: " + format.format(price * 1.05));
				break;
			case "r":
				System.out.println("накрутка 15%, цена: " + format.format(price * 1.15));
				break;
			case "b":
				System.out.println("накрутка 7%, цена: " + format.format(price * 1.07));
				break;
			default:
				System.out.println("Введена несуществующая команда");
		}
	}

	static void task_5() {
		for (int i = 10; i < 100; i++) {
			int sum = 0;
			for (int j = 1; j < i; j++) {
				if (i % j == 0) {
					sum += j;
				}
			}
			if (sum % 2 == 0) {
				System.out.println(i);
			}
		}
	}

	static void task_6() {
		Scanner scanner = new Scanner(System.in);
		int prev = scanner.nextInt();
		int pres = scanner.nextInt();
		int next = scanner.nextInt();
		int count = 0;
		if (prev > pres) {
			count++;
		}
		do {
			if (pres > prev && pres > next) {
				count++;
			}
			prev = pres;
			pres = next;
			next = scanner.nextInt();
		} while (next != 0);
		if (pres > prev) {
			count++;
		}
		System.out.println(count);
	}

	static void task_7() {
		Scanner Scanner = new Scanner(System.in);
		System.out.println("Введите n");
		int n = Scanner.nextInt(), sum = 14;
		System.out.println(2);
		System.out.println(3);
		System.out.println(5);
		for (int i = 6; i < n; i++) {
			int a = 0;
			if (prime_number(i) == 1) {
				continue;
			}
			for (int j = 6; j <= i / 2; j++) {
				if (i % j == 0) {
					if (prime_number(j) == 1) {
						a = 1;
						break;
					}
				}
			}
			if (a == 0) {
				sum += i;
				System.out.println(i);
			}
		}
		System.out.println(sum);
	}

	private static int prime_number(int j) {
		int a = 1;
		for (int i = 2; i <= j / 2; i++) {
			if (j % 2 == 0 || j % i == 0) {
				a = 0;
				break;
			}
		}
		return (a);
	}
}
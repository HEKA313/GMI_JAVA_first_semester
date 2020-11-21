package lab4;

import java.util.*;
import java.text.DecimalFormat;

public class Task {
	public static void main(String[] args) {
		Scanner Scanner = new Scanner(System.in);
		cycle:
		while (true) {
			System.out.println("1. Задача 1");
			System.out.println("2. Задача 2");
			System.out.println("3. Задача 3 (нерекурсивная)");
			System.out.println("4. Задача 3 (рекурсивная)");
			System.out.println("5. Задача 4");
			System.out.println("6. Задача 5");
			System.out.println("7. Задача 6");
			System.out.println("8. Задача 7");
			System.out.println("9. Выход");
			System.out.println("Выберите пункт меню (1..9)");
			int c = Scanner.nextInt();
			switch (c) {
				case 1:
					Maratik.Task_1();
					break;
				case 2:
					Maratik.Task_2();
					break;
				case 3:
					Maratik.Task_3();
					break;
				case 4:
					Maratik.Task_4();
					break;
				case 5:
					Maratik.Task_5();
					break;
				case 6:
					Maratik.Task_6();
					break;
				case 7:
					Maratik.Task_7();
					break;
				case 8:
					Maratik.Task_8();
					break;
				default:
					break cycle;
			}
		}
	}
}

class Maratik {
	static void Task_1() {
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

	static void Task_2() {
		Scanner scanner = new Scanner(System.in);
		int prev = scanner.nextInt();
		int pres = scanner.nextInt();
		if (prev != 0 && pres != 0) {
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
		} else if (pres == 0) {
			System.out.println(prev);
		}
	}

	static void Task_3() {
		Scanner Scanner = new Scanner(System.in);
		System.out.println("Введите n");
		int n = Scanner.nextInt(), sum = 0, z = 0;
		for (int i = 2; z < n; i++) {
			int num = i;
			while (num % 2 == 0) num /= 2;
			while (num % 5 == 0) num /= 5;
			while (num % 3 == 0) num /= 3;
			if (num == 1) {
				System.out.println(i);
				sum += i;
				z++;
			}
		}
		System.out.println(sum);
	}

	static void Task_4() {
		Scanner Scanner = new Scanner(System.in);
		System.out.println("Введите n");
		int n = Scanner.nextInt(), sum = 0;
		if (n == 1) System.out.println(2 + '\n' + 2);
		else if (n == 2) System.out.println(2 + '\n' + 3 + '\n' + 5);
		else if (n == 3) System.out.println(2 + '\n' + 3 + '\n' + 4 + '\n' + 9);
		else if (n == 4) System.out.println(2 + '\n' + 3 + '\n' + 4 + '\n' + 5 + '\n' + 14);
		else if (n <= 0) System.out.println("Неверно введен диапазон");
		else {
			sum = 14;
			System.out.println(2);
			System.out.println(3);
			System.out.println(4);
			System.out.println(5);
			int z = 4;
			for (int i = 6; z < n; i++) {
				boolean a = false;
				if (prime_number(i, 2)) {
					continue;
				}
				for (int j = 6; j <= i / 2; j++) {
					if (i % j == 0) {
						if (prime_number(j, 2)) {
							a = true;
							break;
						}
					}
				}
				if (!a) {
					z++;
					sum += i;
					System.out.println(i);
				}
			}
			System.out.println(sum);
		}
	}

	private static boolean prime_number(int number, int i) {
		if (number == 1) return false;
		if (number == 2) return true;

		if (number % i == 0) return false;

		if (i <= Math.sqrt(number)) return prime_number(number, i + 1);
		else return true;
	}

	static void Task_5() {
		Scanner Scanner = new Scanner(System.in);
		double a = Scanner.nextDouble(), b = Scanner.nextDouble(), c = Scanner.nextDouble();
		double average = Math.cbrt(a * b * c);
		int temp = (int) average;
		System.out.println(average);
		System.out.println(average - temp);
	}

	static void Task_6() {
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

	static void Task_7() {
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

	static void Task_8() {
		Scanner Scanner = new Scanner(System.in);
		System.out.println("Введите тип операции: p, o, r, b");
		String type = Scanner.next();
		DecimalFormat format;
		format = new DecimalFormat("##.00");
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
}

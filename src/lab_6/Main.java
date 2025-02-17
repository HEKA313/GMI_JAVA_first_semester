package lab_6;

import java.util.*;

public class Main {
	public static void main ( String[] args ) {
		Scanner scanner = new Scanner( System.in );
		int b = 0, c = 0;
		cycle:
		while ( true ) {
			System.out.println( "1. Задача 1" );
			System.out.println( "2. Задача 2" );
			System.out.println( "3. Задача 3" );
			System.out.println( "4. Задача 4" );
			System.out.println( "5. Выход" );
			System.out.println( "Выберите пункт меню (1...5)" );
			int a = scanner.nextInt();
			if ( a != 5 ) {
				System.out.println( "1. Ввод чисел вручную" );
				System.out.println( "2. Случайный ввод чисел" );
				b = scanner.nextInt();
				if ( b != 1 && b != 2 ) {
					System.out.println( "Введите корректное значение" );
					break;
				}
				System.out.println( "1. Вывод в виде цикла" );
				System.out.println( "2. Вывод в виде рекурсии" );
				c = scanner.nextInt();
				if ( c != 1 && c != 2 ) {
					System.out.println( "Введите корректное значение" );
					break;
				}
			}
			switch ( a ) {
				case 1:
					My_Class.task_1( b, c );
					break;
				case 2:
					My_Class.task_2( b, c );
					break;
				case 3:
					My_Class.task_3( b, c );
					break;
				case 4:
					My_Class.task_4( b, c );
					break;
				default:
					break cycle;
			}
		}
	}
}

class My_Class {
	static Scanner scanner = new Scanner( System.in );
	static Random random = new Random();

	static int[][] in_manually ( int n, int m ) {
		int[][] a = new int[n][m];
		for ( int i = 0; i < n; i++ ) {
			for ( int j = 0; j < m; j++ ) {
				a[i][j] = scanner.nextInt();
			}
		}
		return a;
	}

	static int[][] in_random ( int n, int m ) {
		int[][] a = new int[n][m];
		for ( int i = 0; i < n; i++ ) {
			for ( int j = 0; j < m; j++ ) {
				a[i][j] = random.nextInt( 100 );
			}
		}
		return a;
	}

	static void out_cycle ( int[][] a ) {
		System.out.println( "Вы ввели массив:" );
		for ( int[] ints : a ) {
			for ( int j = 0; j < a[0].length; j++ ) {
				System.out.printf( "%4d", ints[j] );
			}
			System.out.print( "\n" );
		}
	}

	static void out_recursion ( int[][] a, int row, int col ) {
		System.out.println("Вы ввели массив:");
		if ( row == a.length ) {
		} else if ( col >= a[row].length ) {
			System.out.println();
			out_recursion( a, ++row, 0 );
		} else {
			System.out.printf( "%4d", a[row][col] );
			out_recursion( a, row, ++col );
		}
	}

	static boolean prime_number ( int num ) {
		if ( num == 2 ) return true;
		if ( num % 2 == 0 ) return false;
		if ( num < 2 ) return false;
		for ( int i = 3; i <= num / 2; i += 2 ) if ( num % i == 0 ) return false;
		return true;
	}

	static int[][] standard_actions ( int in, int out ) {
		System.out.println( "Введите количество строк" );
		int row = scanner.nextInt();
		System.out.println( "Введите количество столбцов" );
		int col = scanner.nextInt();
		int[][] array = new int[row][col];
		if ( in == 1 ) array = in_manually( row, col );
		else if ( in == 2 ) array = in_random( row, col );

		if ( out == 1 ) out_cycle( array );
		else if ( out == 2 ) out_recursion( array, 0, 0 );

		return array;
	}

	static int[] side_diagonal ( int[][] a ) {
		System.out.println( "Побочная диагональ:" );
		int[] array = new int[a.length];
		if ( a.length == 1 ) {
			array[0] = a[0][0];
			System.out.println( array[0] );
			return array;
		}
		for ( int i = a.length - 1; i >= 0; i-- ) {
			int j = a[0].length - i - 1;
			array[j] = a[i][j];
			System.out.printf( "%d ", array[j] );
		}
		System.out.println();
		return array;
	}

	static int[][] matrix_to_square ( int[][] array ) {
		System.out.println( "Начальная матрица приведена к квадратному виду:" );
		int[][] arr;
		if ( array.length > array[0].length ) arr = new int[array[0].length][array[0].length];
		else arr = new int[array.length][array.length];
		for ( int i = array.length - arr.length, z = 0; i < arr.length; i++, z++ ) {
			for ( int j = 0; j < arr.length; j++ ) {
				arr[z][j] = array[i][j];
				System.out.printf( "%d ", arr[z][j] );
			}
			System.out.println();
		}
		return arr;
	}

	static void matrix_transpose ( int[][] array ) {
		for ( int i = 0; i < array.length; i++ ) {
			for ( int j = i + 1; j < array.length; j++ ) {
				int temp = array[i][j];
				array[i][j] = array[j][i];
				array[j][i] = temp;
			}
		}
	}

	static void swap ( int[][] array, int[] side, int ind1, int ind2 ) {
		matrix_transpose( array );
		int[] tmp = array[ind1];
		array[ind1] = array[ind2];
		array[ind2] = tmp;
		int tmp1 = side[ind1];
		side[ind1] = side[ind2];
		side[ind2] = tmp1;
		matrix_transpose( array );
	}

	static void bubble_sort ( int[][] array, int[] side ) {
		boolean needIteration = true;
		if ( side.length <= 1 ) needIteration = false;
		while ( needIteration ) {
			needIteration = false;
			for ( int i = 1; i < side.length; i++ ) {
				if ( side[i] > side[i - 1] ) {
					swap( array, side, i, i - 1 );
					needIteration = true;
				}
			}
		}
		System.out.println( "Отсортированный массив, который указан выше:" );
		for ( int j : side ) System.out.printf( "%d ", j );
		System.out.println();
	}

	static void task_1 ( int in, int out ) {
		//23.	В каждой строке определить наибольшее простое число, если в строке нет простых чисел, выдавать соответствующее сообщение
		int[][] array = standard_actions( in, out );

		for ( int[] rows : array ) {
			int max = Integer.MIN_VALUE;
			for ( int cols : rows ) {
				if ( prime_number( cols ) && max < cols ) max = cols;
			}
			if ( max != Integer.MIN_VALUE ) System.out.println( max );
			else System.out.println( "Простых чисел в строке - нет" );
		}
	}

	static void task_2 ( int in, int out ) {
		//19.	найти номера строк, в которых на всех нечетных позициях стоят нули;
		int[][] array = standard_actions( in, out );

		for ( int i = 0; i < array.length; i++ ) {
			boolean check = true;
			for ( int j = 1; j < array[0].length; j += 2 ) {
				if ( array[i][j] != 0 ) {
					check = false;
					break;
				}
			}
			if ( check ) System.out.println( i + 1 );
		}
	}

	static void task_3 ( int in, int out ) {
		// 3.	Отсортировать столбцы матрицы по убыванию количества элементов меньших элементов побочной диагонали;
		// ГОВНО СТОРТИРОВКА
		int[][] array = standard_actions( in, out );
		int[] count = new int[array.length];
		int[][] arr;
		if ( array.length != array[0].length ) arr = matrix_to_square( array );
		else arr = array;
		int[] side = side_diagonal( arr );

		for ( int i = 0; i < side.length; i++ ) {
			int n = 0;
			for ( int[] ints : array ) {
				if ( ints[i] < side[i] ) n++;
			}
			count[i] = n;
		}

		System.out.println( "Массив созданный по количеству элементов столбцов, в которых элементы меньше побочной диагонали" );
		for ( int index : count ) System.out.printf( "%d ", index );
		System.out.println();

		bubble_sort( array, count );

		System.out.println( "Ответ:" );
		for ( int[] row : array ) {
			for ( int col : row ) System.out.printf( "%4d ", col );
			System.out.println();
		}
	}

	static void task_4 ( int in, int out ) {
		//28.	Переставить строку и столбец матрицы, на пересечении которых расположен минимальный четный элемент
		// побочной диагонали. Если на побочной диагонали нет четных элементов, то вывести матрицу в обратном порядке.
		int[][] array = standard_actions( in, out );
		int[][] arr;
		if ( array.length != array[0].length ) arr = matrix_to_square( array );
		else arr = array;
		int[] side = side_diagonal( arr );
		int min = Integer.MAX_VALUE;
		int min_pos = -1;

		for ( int i = 0; i < side.length; i++ ) {
			if ( side[i] < min && side[i] % 2 == 0 ) {
				min = side[i];
				min_pos = i;
			}
		}
		if ( min_pos != -1 ) {
			for ( int i = 0; i < array.length; i++ ) {
				int tmp = array[min_pos][i];
				array[min_pos][i] = array[i][min_pos];
				array[i][min_pos] = tmp;
			}
			System.out.println( "Конечная матрица:" );
			for ( int[] row : array ) {
				for ( int col : row ) {
					System.out.printf( "%d ", col );
				}
				System.out.println();
			}
		} else {
			System.out.println( "Матрица в обратном порядке:" );
			for ( int i = 0; i < array.length; i++ ) {
				for ( int j = 0; j < array[0].length; j++ ) {
					System.out.printf( "%d ", array[array.length - i - 1][array[0].length - j - 1] );
				}
				System.out.println();
			}
		}
	}
}
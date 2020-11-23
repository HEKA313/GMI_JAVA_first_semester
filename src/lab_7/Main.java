package lab_7;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main ( String[] args ) {
		Scanner Scanner = new Scanner( System.in );
		cycle:
		while ( true ) {
			System.out.println( "1. Задача 1" );
			System.out.println( "2. Задача 2" );
			System.out.println( "3. Задача 3" );
			System.out.println( "4. Задача 4" );
			System.out.println( "5. Задача 5" );
			System.out.println( "6. Задача 6" );
			System.out.println( "7. Задача 7" );
			System.out.println( "8. Выход" );
			System.out.println( "Выберите пункт меню (1...8)" );
			int c = Scanner.nextInt();
			switch ( c ) {
				case 1:
					My_Class.task_1();
					break;
				case 2:
					My_Class.task_2();
					break;
				case 3:
					My_Class.task_3();
					break;
				case 4:
					My_Class.task_4();
					break;
				case 5:
					My_Class.task_5();
					break;
				case 6:
					My_Class.task_6();
					break;
				case 7:
					My_Class.task_7();
					break;
				default:
					break cycle;
			}
		}
	}
}

class My_Class {
	static Scanner scanner = new Scanner( System.in );

	static void task_1 () {
		int count = 0;
		String str = scanner.nextLine();
		str = str.toLowerCase();
		for ( int i = 0; i < str.length(); i++ ) {
			char[] tmp = new char[1];
			str.getChars( i, i + 1, tmp, 0 );
			if ( tmp[0] == 'и' ) {
				count++;
			}
		}
		System.out.printf( "Буква 'и' встречается: %d раз\n", count );
	}

	static void task_2 () {
		String a = scanner.nextLine();
		String[] str = a.split( " " );
		String[] min_str = new String[str.length];
		String[] max_str = new String[str.length];
		int min = Integer.MAX_VALUE, max = 0;
		int min_count = 0, max_count = 0;
		for ( String tmp : str ) {
			int len = tmp.length();
			if ( len < min ) {
				min = len;
				Arrays.fill( min_str, "" );
				min_count = 0;
			}
			if ( len > max ) {
				max = len;
				Arrays.fill( max_str, "" );
				max_count = 0;
			}

			if ( len == min ) {
				min_str[min_count] = tmp;
				min_count++;
			}
			if ( len == max ) {
				max_str[max_count] = tmp;
				max_count++;
			}
		}

		System.out.println( "Массив слов минмальной длины" );
		for ( String tmp : min_str ) if ( !tmp.equals( "" ) ) System.out.printf( "%s ", tmp );
		System.out.println( "\nМассив  слов максимальной длины" );
		for ( String tmp : max_str ) if ( !tmp.equals( "" ) ) System.out.printf( "%s ", tmp );
		System.out.println();
	}

	static void task_3 () {
		String a = scanner.nextLine();
		String[] str = a.split( " " );
		String word = "";
		int pos = -1;
		int count = 0;
		char[] symbols;
		int min = Integer.MAX_VALUE;

		for ( int i = 0; i < str.length; i++ ) {
			int len = str[i].length();
			if ( len < min ) {
				min = len;
				word = str[i];
				pos = i + 1;
			}
		}
		symbols = new char[word.length()];
		Arrays.fill( symbols, ' ' );
		for ( int i = 0; i < word.length(); i++ ) {
			char[] tmp = new char[1];
			boolean check = false;
			word.getChars( i, i + 1, tmp, 0 );
			for ( char symbol : symbols ) {
				if ( tmp[0] == symbol ) {
					check = false;
					break;
				}
				check = true;
			}
			if ( check ) {
				symbols[count] = tmp[0];
				count++;
			}
		}
		System.out.printf( "Порядковый номер слова минимальной длины: %s\n", pos );
		System.out.printf( "Количество неповторяющихся символов этого слова: %s\n", count );
	}

	static void task_4 () {
		// Привет. Люблю тебя! Грустно? Мне тоже...
		// Привет Привет привет привет ПрИвЕт. Как КАК КаК кАк кАК?
		String a = scanner.nextLine();
		a = a.toLowerCase();
		String[] str = a.split( "[!.?]+" );
		List<String[]> sentences = new ArrayList<>();
		int max = 0, n = 0, count = 0;
		for ( String tmp : str ) sentences.add( tmp.split( " " ) );
		for ( String[] words : sentences ) {
			for ( String word : words ) {
				for ( String tmp : words ) {
					if ( tmp.equals( word ) && !tmp.equals( "" ) ) {
						n++;
						break;
					}
				}
			}
			if ( n > max ) {
				max = n;
				n = 0;
				count = 1;
			} else if ( n == max ) {
				n = 0;
				count++;
			}
		}
		System.out.println( count );
	}

	static void task_5 () {
		// aE:dC:cA:56:76:54
		StringBuilder str = new StringBuilder();
		str.append( scanner.nextLine() );
		StringBuilder final_str = new StringBuilder();
		Pattern pattern = Pattern.compile( "[a-z].+[A-Z]:" );
		Matcher matcher = pattern.matcher( str );
		Pattern pattern1 = Pattern.compile( "[0-9].+[0-9]" );
		Matcher matcher1 = pattern1.matcher( str );
		while ( matcher.find() && matcher1.find() ) {
			final_str.append( str.substring( matcher.start(), matcher.end() ) );
			final_str.append( str.substring( matcher1.start(), matcher1.end() ) );
		}
		if ( final_str.toString().contentEquals( str ) ) System.out.println( "Данная строка является mac-адресом" );
		else System.out.println( "Данная строка не является mac-адресом" );
	}

	static void task_6 () {
		String a = scanner.nextLine();
		a = a.toLowerCase();
		String[] str = a.split( " " );
		String original_str = "cat";
		for ( String tmp : str ) {
			if ( tmp.contains( original_str ) ) {
				System.out.println( "Введенная строка содержит \"cat\"" );
				break;
			}
		}
	}

	static boolean repeat_character ( String str ) {
		for ( int i = 0; i < str.length() - 1; i++ ) {
			char[] sym = new char[1];
			char[] sym1 = new char[1];
			str.getChars( i, i + 1, sym, 0 );
			str.getChars( i + 1, i + 2, sym1, 0 );
			if ( sym[0] == '"' || sym1[0] == '"' ) continue;
			if ( sym[0] != sym1[0] || sym[0] != 'a' ) {
				return false;
			}
		}
		return true;
	}

	static void task_7 () {
		//There'll be no more "Aaaaaaaaaaaaaaaaa"
		String a = scanner.nextLine();
		a = a.toLowerCase();
		String[] str = a.split( " " );
		for ( int i = 0; i < str.length; i++ ) {
			if ( str[i].length() == 1 ) continue;
			if ( repeat_character( str[i] ) ) {
				str[i] = "argh";
			}
		}
		System.out.println( Arrays.toString( str ) );
	}
}

package lab1.Ernest_Badalov;

import java.util.*;

public class Task_3 {
    public static void main(String[] args) {
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
}

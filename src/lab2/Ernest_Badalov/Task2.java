package lab2.Ernest_Badalov;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        double x = Scanner.nextDouble();
        boolean isSpecial = false;
        if (((x / 10) > 3) && ((x / 10) <= 7) && ((x / 10) > ((x * 100) % 10))) {
            isSpecial = true;
        }
        System.out.println(isSpecial);
    }
}

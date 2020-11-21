package lab1.Ernest_Badalov;

import java.util.*;

public class Fuck {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        double a = Scanner.nextDouble(), b = Scanner.nextDouble(), c = Scanner.nextDouble();
        double average = Math.cbrt(a * b * c);
        int dec = (int) average;
        double decimal = average - dec;
        System.out.println(decimal);
    }
}

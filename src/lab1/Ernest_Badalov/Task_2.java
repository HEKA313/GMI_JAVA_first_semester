package lab1.Ernest_Badalov;

import java.util.*;

public class Task_2 {
    public static void main(String[] args) {
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
        }
        else if (pres == 0){
            System.out.println(prev);
        }
    }
}

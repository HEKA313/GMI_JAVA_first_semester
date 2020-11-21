package lab1.Ernest_Badalov;

public class Task_1 {
    public static void main(String[] args) {
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
}

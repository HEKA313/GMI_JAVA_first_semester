package lab4;

public class prime {
    private static boolean isPrime(int number, int i) {
        if (number == 1) return false;
        if (number == 2) return true;

        if (number % i == 0) return false;

        if (i <= Math.sqrt(number)) return isPrime(number, i + 1);
        else return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(14, 2));
    }
}

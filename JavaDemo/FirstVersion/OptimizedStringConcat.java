import java.util.Random;
import java.util.Scanner;

public class OptimizedStringConcat {
    public static void main(String[] args) {
        // Warm-up
        System.out.println("Warming up...");
        for (int i = 0; i < 3; i++) {
            buildString(10000);
        }

        // for better analysis (increasing time) getting some input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press number1: ");
        int i = scanner.nextInt();

        // Test
        System.out.println("Starting test...");
        long startTime = System.currentTimeMillis();
        String result = buildString(1000000);
        long endTime = System.currentTimeMillis();

        System.out.println("Result length: " + result.length());
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }

    public static String buildString(int iterations) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(iterations);  // Pre-allocate capacity
        for (int i = 0; i < iterations; i++) {
            char randomChar = (char)(random.nextInt(26) + 'a');  // a-z
            sb.append(randomChar);
        }
        return sb.toString();
    }
}
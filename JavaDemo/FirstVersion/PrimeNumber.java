import java.util.ArrayList;
import java.util.List;

public class PrimeNumberProfilingExample {

    public static void main(String[] args) {
        // Warm-up phase (not measured, to avoid measuring JVM startup overhead)
        System.out.println("Warming up...");
        for (int i = 0; i < 3; i++) {
            findPrimesUpTo(10000);
        }

        // Actual measurement
        System.out.println("Starting profiling...");
        int limit = 100000;
        long startTime = System.currentTimeMillis();

        List<Integer> primes = findPrimesUpTo(limit);

        long endTime = System.currentTimeMillis();
        System.out.println("Found " + primes.size() + " prime numbers up to " + limit);
        System.out.println("Execution time: " + (endTime - startTime) + " ms");
    }

    // Inefficient
    public static List<Integer> findPrimesUpTo(int limit) {
        List<Integer> primes = new ArrayList<>();

        for (int number = 2; number <= limit; number++) {
            if (isPrime(number)) {
                primes.add(number);
            }
        }

        return primes;
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        // Inefficient
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
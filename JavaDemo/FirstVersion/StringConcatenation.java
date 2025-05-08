import java.util.Random;

// Building a large string of ransom chars
public class StringConcatenation {
    public static void main(String[] args) {
        // Warm-up
        System.out.println("Warming up...");
        for (int i = 0; i < 3; i++) {
            buildString(10000);
        }

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
        String str = "";
        for (int i = 0; i < iterations; i++) {
            char randomChar = (char)(random.nextInt(26) + 'a');  // a-z
            str += randomChar; // Inefficient string concatenation
        }
        return str;
    }
}
import java.util.Random;

public class StringConcatenationOptimized {
    public static void main(String[] args) {
        // Warm-up phase (unchanged, but helps JIT optimize the code)
        System.out.println("Warming up...");
        for (int i = 0; i < 3; i++) {
            buildString(10000);
        }

        // Performance test
        System.out.println("Starting test...");
        long startTime = System.currentTimeMillis();
        String result = buildString(1000000); // Building a large string
        long endTime = System.currentTimeMillis();

        System.out.println("Result length: " + result.length());
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }

    /**
     * Optimized version of buildString() using StringBuilder.
     * Key improvements:
     * 1. Replaced `String` concatenation (`str += randomChar`) with `StringBuilder`.
     * 2. Pre-allocated initial capacity to avoid internal array resizing.
     * 3. Eliminated O(n²) time complexity (now O(n)).
     */
    public static String buildString(int iterations) {
        Random random = new Random();

        // CHANGE 1: Use StringBuilder instead of String for mutable appends
        // - Avoids creating a new String object on every loop iteration.
        // - Initial capacity set to `iterations` to minimize buffer reallocation.
        StringBuilder sb = new StringBuilder(iterations);

        for (int i = 0; i < iterations; i++) {
            char randomChar = (char)(random.nextInt(26) + 'a'); // a-z

            // CHANGE 2: Append using StringBuilder instead of +=
            // - Appends directly to the buffer without copying existing chars.
            sb.append(randomChar);
        }

        // Convert StringBuilder to String only once at the end.
        return sb.toString();
    }
}
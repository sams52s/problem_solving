public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {1, 2, 3};
        int[] digits2 = {9, 9, 9};
        int[] digits3 = {1, 0, 0, 0};
        int[] result = plusOne(digits);
        int[] result2 = plusOne(digits2);
        int[] result3 = plusOne(digits3);
        System.out.print("Result of plusOne: ");
        printResult(result);
        printResult(result2);
        printResult(result3);
        int[] result4 = plusOne2ndSolution(digits);
        int[] result5 = plusOne2ndSolution(digits2);
        int[] result6 = plusOne2ndSolution(digits3);
        System.out.print("\nResult of plusOne2ndSolution: ");
        printResult(result4);
        printResult(result5);
        printResult(result6);

    }
    public static void printResult(int[] result) {
        System.out.print("Result: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


    public static int[] plusOne(int[] digits) {
        int total = 0;
        for(int digit : digits) {
            total = total * 10 + digit;
        }
        total += 1;
        String totalString = String.valueOf(total);
        int[] result = new int[totalString.length()];
        for(int i = 0; i < totalString.length(); i++) {
            result[i] = Character.getNumericValue(totalString.charAt(i));
        }
        return result;
    }
    /**
     * This solution has O(n) time complexity and O(1) space complexity.
     * It converts the array to an integer, adds one, and converts it back to an array.
     * This is not the most efficient way to solve the problem.
     */
    public static int[] plusOne2ndSolution(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        // If we reach here, it means all digits were 9
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
    /**
     * This solution has O(n) time complexity and O(1) space complexity.
     * It iterates from the last digit to the first digit,
     * incrementing the last digit and handling carry if necessary.
     * If all digits are 9, it creates a new array with an extra digit.
     * This is the most efficient way to solve the problem.
     * It uses a single loop to handle the carry and
     * does not require any additional space for the result.
     * Runtime 0ms Memory 41.78MB
     */
}

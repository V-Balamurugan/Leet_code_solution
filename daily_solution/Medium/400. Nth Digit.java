------------------------------------------------(Brute force approach)-----------------------------------------
class Solution {
    public int findNthDigit(int n) {

        long digits = 1;  // Number of digits in each number
        long numbers = 9; // How many numbers in this group
        long start = 1;   // First number in this group

        // Find which digit group contains the nth digit
        while (n > digits * numbers) {
            n -= digits * numbers;

            digits++;
            numbers *= 10;
            start *= 10;
        }

        // Find the number containing the nth digit
        long number = start + (n - 1) / digits;

        // Find the position inside that number
        int position = (int) ((n - 1) % digits);

        // Extract the required digit without building the sequence
        String num = String.valueOf(number);

        return num.charAt(position) - '0';
    }
}

---------------------------------------(Binary search approach)-----------------------------------------
  class Solution {

    public int findNthDigit(int n) {

        int[] digitsArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        long digitCount = 1;
        long numberCount = 9;
        long start = 1;

        // Find the group containing the nth digit
        while (n > digitCount * numberCount) {
            n -= digitCount * numberCount;

            digitCount++;
            numberCount *= 10;
            start *= 10;
        }

        // Find the exact number
        long number = start + (n - 1) / digitCount;

        // Find the digit position inside that number
        int position = (int) ((n - 1) % digitCount);

        // Extract digits mathematically
        long divisor = 1;

        for (int i = 0; i < digitCount - position - 1; i++) {
            divisor *= 10;
        }

        int digit = (int) ((number / divisor) % 10);

        // Return using your array
        return digitsArray[digit];
    }
}

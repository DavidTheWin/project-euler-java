package org.dgreen.projecteuler;

import java.util.Stack;

public class Problem13 {
    public static String firstNDigitsOfSumOf(int numberOfDigits, String[] numbers) {
        var lengthOfNumber = numbers[0].length();
        var digitsOfSum = new Stack<Character>();

        var carryOver = 0;
        for (int positionInString = lengthOfNumber - 1; positionInString >= 0; positionInString--) {
            var sum = carryOver;
            carryOver = 0;

            for (int positionInArray = 0; positionInArray < numbers.length; positionInArray++) {
                sum += valueOfCharAt(numbers, positionInArray, positionInString);

                if (sum >= 10) {
                    carryOver++;
                    sum -= 10;
                }
            }

            digitsOfSum.push((char)(sum + 48));
        }

        var charsInCarryOver = String.valueOf(carryOver).toCharArray();
        for (char c : charsInCarryOver) {
            digitsOfSum.push(c);
        }

        return firstNDigitsFromStack(digitsOfSum, numberOfDigits);
    }

    private static int valueOfCharAt(String[] numbers, int positionInArray, int positionInString) {
        return Character.getNumericValue(numbers[positionInArray].charAt(positionInString));
    }

    private static String firstNDigitsFromStack(Stack<Character> stack, int numberOfDigits) {
        var output = new StringBuilder();

        for (int i = 0; i < numberOfDigits; i++) {
            output.append(stack.pop());
        }

        return output.toString();
    }
}

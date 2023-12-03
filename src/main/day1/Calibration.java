package main.day1;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calibration {
    // TODO: Make this code actually work lol
    // So you need to split each line like you're already doing then combine the first
    // and last digit so for example adse3jfj5anc9 would be 39
    // then you need to get the sum of all of the lines where you perform that operation
    // You'll need to fully rework the below code though

    private static Map<String, String> numbers = new HashMap<>();

    public Calibration() {
        numbers.put("one", "1");
        numbers.put("two", "2");
        numbers.put("three", "3");
        numbers.put("four", "4");
        numbers.put("five", "5");
        numbers.put("six", "6");
        numbers.put("seven", "7");
        numbers.put("eight", "8");
        numbers.put("nine", "9");
    }

    static int sumOfCalibration(String input) {
        int sum = 0;
        String[] values = input.split("\\n");
        for (String value : values) {
            String firstNumber = findFirstNumber(value);
            String lastNumber = findLastNumber(value);

            if (firstNumber.isEmpty()) {
                firstNumber = lastNumber;
            }

            if (lastNumber.isEmpty()) {
                lastNumber = firstNumber;
            }

            // Both were empty
            if (firstNumber.isEmpty()) {
                continue;
            }

            sum += Integer.parseInt(firstNumber.concat(lastNumber));
        }

        return sum;
    }

    private static String findFirstNumber (String input) {
        // Try parsing the first character to check that it is an int
        try {
            String firstChar = input.split("")[0];
            int num = Integer.parseInt(firstChar);
            return firstChar;
        } catch(NumberFormatException ignored){};

        int indexOfNumber = 999;
        String firstNumber = "";

        for (Map.Entry<String, String> entry : numbers.entrySet()) {
            String key = entry.getKey();

            int index = input.indexOf(key);
            if (index != -1 && index < indexOfNumber) {
                indexOfNumber = index;
                firstNumber = entry.getValue();
            }
        }

        int firstDigitIndex = findFirstDigitIndex(input);
        if (firstDigitIndex < indexOfNumber && firstDigitIndex != -1) {
            return input.split("")[firstDigitIndex];
        }

        // If no number return an empty string
        return firstNumber;
    }

    private static String findLastNumber (String input) {
        // Try parsing the last character to check that if is an int
        try {
            String lastChar = input.split("")[input.length() - 1];
            int num = Integer.parseInt(lastChar);
            return lastChar;
        } catch(NumberFormatException ignored){};

        int largestIndex = -1;
        String lastNumber = "";

        for (Map.Entry<String, String> entry : numbers.entrySet()) {
            String key = entry.getKey();

            int index = input.lastIndexOf(key);
            if (index != -1 && index > largestIndex) {
                largestIndex = index;
                lastNumber = entry.getValue();
            }
        }

        int lastDigitIndex = findLastDigitIndex(input);
        if (lastDigitIndex != -1 && lastDigitIndex > largestIndex) {
            return input.split("")[lastDigitIndex];
        }

        // If no number return an empty string
        return lastNumber;
    }

    private static int findFirstDigitIndex(String input) {
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isDigit(currentChar)) {
                return i;
            }
        }
        // Return -1 if no digit is found
        return -1;
    }

    private static int findLastDigitIndex(String input) {
        for (int i = input.length() - 1; i > -1; i--) {
            char currentChar = input.charAt(i);
            if (Character.isDigit(currentChar)) {
                return i;
            }
        }
        // Return -1 if no digit is found
        return -1;
    }
}

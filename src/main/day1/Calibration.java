package main.day1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Calibration {
    // TODO: Make this code actually work lol
    // So you need to split each line like you're already doing then combine the first
    // and last digit so for example adse3jfj5anc9 would be 39
    // then you need to get the sum of all of the lines where you perform that operation
    // You'll need to fully rework the below code though

    static final enum numbers = "one";

    static int sumOfCalibration(String input) {
        int sum = 0;
        String[] values = input.split("\\n");
        for (String value : values) {
            String firstNumber = findFirstNumber(value);
            String lastNumber = findLastNumber(value);

            sum += Integer.parseInt(firstNumber.concat(lastNumber));
        }

        return sum;
    }

    private static String findFirstNumber (String input) {
        Matcher matcher = Pattern.compile("\\d").matcher(input);

        if (matcher.find()) {
            return matcher.group();
        }

        // If no number return an empty string
        return "";
    }

    private static String findLastNumber (String input) {
        String reversedInput = new StringBuilder(input).reverse().toString();
        Matcher matcher = Pattern.compile("\\d").matcher(reversedInput);

        if (matcher.find()) {
            return matcher.group();
        }

        // If no number return an empty string
        return "";
    }
}

package main.day1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Calibration {
    // TODO: Make this code actually work lol
    // So you need to split each line like you're already doing then combine the first
    // and last digit so for example adse3jfj5anc9 would be 39
    // then you need to get the sum of all of the lines where you perform that operation
    // You'll need to fully rework the below code though

    static IntStream sumOfCalibration (String input) {
        String[] values = input.split("\\n");
        return Arrays.stream(values).mapToInt(Calibration::sum);
    }

    private static int sum(String input) {
        return input.lines().mapToInt(Integer::parseInt).sum();
    }
}

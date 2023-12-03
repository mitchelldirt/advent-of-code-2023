package main.day1;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalibrationTest {

    @Test
    void testSumOfCalibration() {
        Calibration calibration = new Calibration();

        String input =
                """
                abc7po
                six1234567eight
                k93l
                24
                onetwo
                """;

        // Test cases
        assertEquals(274, calibration.sumOfCalibration(input));
    }
}

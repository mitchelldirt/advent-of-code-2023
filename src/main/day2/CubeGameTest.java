package main.day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 12 red 13 green 14 blue
public class CubeGameTest {
    static final String input = """
            Game 1: 1 red, 3 blue, 11 green; 1 blue, 5 red; 3 blue, 5 green, 11 red
            Game 2: 20 red, 20 blue, 20 green; 20 green, 20 blue; 20 blue, 20 green, 20 red
            Game 3: 12 blue, 5 red; 3 red, 11 green, 12 blue; 1 red, 6 blue, 9 green
            """;
    // 363
    // 8000
    // 660

    @Test
    void testSumOfPosibleGameIds() {
        assertEquals(4, CubeGame.sumOfPosibleGameIds(input));
    }

    @Test
    void testFewestPossibleBlocks() {
        assertEquals(9023, CubeGame.fewestNumberCubes(input));
    }
}

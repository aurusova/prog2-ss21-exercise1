package puzzle1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Repository: https://github.com/aurusova/prog2-ss21-exercise1

class Puzzle1Test {

    private Puzzle1 puzzle1;
    private final File wrong_input = new File("src/test/resources/test_input.txt");
    private final File correct_input = new File("src/test/resources/puzzle1_input.txt");

    @BeforeEach
    void setUp() {
        puzzle1 = new Puzzle1();
    }

    @DisplayName("Part 1: Check fuel calculation per 100756 mass")
    @Test
    void calculateFuelPerModule1() {
        int expected = 33583;
        int actual = puzzle1.calculateFuelPerModuleWithoutMass(100756);
        assertEquals(expected, actual);
    }

    @DisplayName("Part 1: Check fuel calculation per 12 mass")
    @Test
    void calculateFuelPerModule2() {
        int expected = 2;
        int actual = puzzle1.calculateFuelPerModuleWithoutMass(12);
        assertEquals(expected, actual);
    }

    @DisplayName("Part 1: Check fuel calculation per 14 mass")
    @Test
    void calculateFuelPerModule3() {
        int expected = 2;
        int actual = puzzle1.calculateFuelPerModuleWithoutMass(14);
        assertEquals(expected, actual);
    }

    @DisplayName("Part 1: Check fuel calculation per 1969 mass")
    @Test
    void calculateFuelPerModule4() {
        int expected = 654;
        int actual = puzzle1.calculateFuelPerModuleWithoutMass(1969);
        assertEquals(expected, actual);
    }

    @DisplayName("Part 2: Check fuel calculation per 14 mass")
    @Test
    void calculateFuelPerModuleWithMass1() {
        int expected = 2;
        int actual = puzzle1.calculateFuelPerModuleWithMass(14);
        assertEquals(expected, actual);
    }

    @DisplayName("Part 2: Check fuel calculation per 1969 mass")
    @Test
    void calculateFuelPerModuleWithMass2() {
        int expected = 966;
        int actual = puzzle1.calculateFuelPerModuleWithMass(1969);
        assertEquals(expected, actual);
    }

    @DisplayName("Part 2: Check fuel calculation per 100756 mass")
    @Test
    void calculateFuelPerModuleWithMass3() {
        int expected = 50346;
        int actual = puzzle1.calculateFuelPerModuleWithMass(100756);
        assertEquals(expected, actual);
    }

    @DisplayName("Check input file for non-numbers")
    @Test
    void checkForNonNums() {
        List<Integer> expected = new ArrayList<>();
        List<Integer> actual = puzzle1.extractMasses(wrong_input);
        assertEquals(expected, actual);
    }

    @DisplayName("Check size of the list of extracted values")
    @Test
    void checkListSize() {
        int expected = 100;
        int actual = puzzle1.extractMasses(correct_input).size();
        assertEquals(expected, actual);
    }

    @DisplayName("Check complete part 1 of puzzle")
    @Test
    void part1() {
        int expected = 3454026;
        int actual = puzzle1.part1(correct_input);
        assertEquals(expected, actual);
    }

    @DisplayName("Check complete part 2 of puzzle")
    @Test
    void part2() {
        int expected = 5178170;
        int actual = puzzle1.part2(correct_input);
        assertEquals(expected, actual);
    }
}
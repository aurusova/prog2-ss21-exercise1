package puzzle1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Puzzle1 {

    public List<Integer> extractMasses(File input) {
        List<Integer> massesList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line != null && line.trim().length() > 0) {
                    massesList.add(Integer.parseInt(line));
                } else {
                    massesList.clear();
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return massesList;
    }

    public int calculateFuelPerModuleWithoutMass(int mass) {
        return mass / 3 - 2;
    }

    public int calculateFuelPerModuleWithMass(int mass) {
        int sum = 0;
        while (mass > 0) {
            mass = calculateFuelPerModuleWithoutMass(mass);
            if (mass > 0) {
                sum += mass;
            }
        }
        return sum;
    }

    public int part1(File massesList) {
        List<Integer> masses = extractMasses(massesList);
        int sumOfFuel = 0;
        for (Integer mass : masses) {
            sumOfFuel += calculateFuelPerModuleWithoutMass(mass);
        }
        return sumOfFuel;
    }

    public int part2(File massesList) {
        List<Integer> masses = extractMasses(massesList);
        int sumOfFuel = 0;
        for (Integer mass : masses) {
            sumOfFuel += calculateFuelPerModuleWithMass(mass);
        }
        return sumOfFuel;
    }

    public static void main(String[] args) {
        Puzzle1 puzzle = new Puzzle1();
        File massesList = new File("src/test/resources/puzzle1_input.txt");

        int first_result = puzzle.part1(massesList);
        System.out.println("Sum of the fuel requirements for all modules on the spacecraft: " + first_result);
        int second_result = puzzle.part2(massesList);
        System.out.println("Sum of the fuel requirements for all modules on the spacecraft including the mass of the added fuel: " + second_result);
    }
}
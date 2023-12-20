package ua.nure.cpp.sivenko.practice1;

import ua.nure.cpp.sivenko.practice1.task.Part1;
import ua.nure.cpp.sivenko.practice1.task.Part2;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        try {
            Part1.main(new String[] {"4", "6"});
        } catch (IllegalArgumentException ex) {
            readTwoDecimals();
        }

        try {
            Part2.main(new String[] {"-10"});
        } catch (IllegalArgumentException ex) {
            readInteger();
        }
    }

    private static void readTwoDecimals() {
        Scanner console = new Scanner(System.in).useLocale(Locale.US);
        double a, c;

        while (true) {
            try {
                System.out.print("Enter the first number: ");
                a = console.nextDouble();
                System.out.print("Enter the second number: ");
                c = console.nextDouble();

                Part1.main(new String[] { String.valueOf(a), String.valueOf(c) });
                break;
            } catch (InputMismatchException ex) {
                console.nextLine();
            }
        }
    }

    private static void readInteger() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter an integer number: ");
                Part2.main(new String[] { String.valueOf(scanner.nextInt()) });
                break;
            } catch (InputMismatchException ex) {
                scanner.nextLine();
            }
        }
    }
}

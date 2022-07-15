package com.assignment.three;

import java.util.Random;
import java.util.Scanner;

public class RandomAlphaNumericString {

    private static final String ALPHABETS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";

    public static void main(String[] args) {
        String all = ALPHABETS + ALPHABETS.toUpperCase() + NUMBERS;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length: ");
        int length = scanner.nextInt();
        scanner.nextLine();
        String randomString = new Random()
                .ints(0, all.length())
                .limit(length)
                .mapToObj(c -> String.valueOf(all.charAt(c)))
                .reduce(String::concat).get();
        System.out.println(randomString);
    }
}

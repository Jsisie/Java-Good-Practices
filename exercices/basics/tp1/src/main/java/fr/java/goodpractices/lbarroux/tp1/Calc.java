package fr.java.goodpractices.lbarroux.tp1;

import java.util.Scanner;

/*
    Operations between values entered by the user
 */
public class Calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter two integer values :");
        int val1 = scanner.nextInt();
        int val2 = scanner.nextInt();
        System.out.println("Sum of the two values entered : " + (val1 + val2));
        System.out.println("Difference of the two values entered : " + (val1 - val2));
        System.out.println("Product of the two values entered : " + (val1 * val2));
        System.out.println("Quotient of the two values entered : " + (val1 / val2));
        System.out.println("Rest of the two values entered : " + (val1 % val2));
    }
}

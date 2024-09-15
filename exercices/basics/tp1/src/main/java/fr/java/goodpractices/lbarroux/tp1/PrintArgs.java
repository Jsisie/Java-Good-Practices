package fr.java.goodpractices.lbarroux.tp1;

import java.util.Arrays;

/*
    Displays the arguments passed to the application
 */
public class PrintArgs {
    public static void main(String[] args) {
        System.out.println("Number of arguments : " + args.length);

        /* Method 1 : classic for loop */
        for (int i = 0 ; i < args.length ; i++) {
            System.out.println(args[i]);
        }

        /* Method 2 : enhanced 'foreach' loop */
        for (String arg : args) {
            System.out.println(arg);
        }

        /* Method 3 : stream forEach */
        Arrays.stream(args).forEach(System.out::println);
    }
}

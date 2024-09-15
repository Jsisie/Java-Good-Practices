package fr.java.goodpractices.lbarroux.tp1;

import java.util.Scanner;

/*
    Example of Record code
 */
public record Point(int x, int y) {

    /* Method overloading */
    public double distance() {
        return distance(new Point(0, 0));
    }

    /* Method overloading */
    public double distance(Point p) {
        return Math.sqrt(Math.pow((p.x - this.x),2) + Math.pow(p.y - this.y, 2));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x value : ");
        int x = scanner.nextInt();
        System.out.print("Enter y value : ");
        int y = scanner.nextInt();

        var point = new Point(x,y);
        System.out.println(point);
        System.out.println("dist = " + point.distance());
        System.out.println("dist = " + point.distance(new Point (2,3)));
    }
}
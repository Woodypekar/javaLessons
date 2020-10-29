package ru.stqa.javaLessons.sandBox;

public class MyFirstProgram {

    public static void main (String[] args) {

        Point p1 = new Point(1, 2);
        Point p2 = new Point(11, 22);
        System.out.println(p1.distance(p2));

    }

}
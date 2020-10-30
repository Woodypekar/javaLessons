package ru.stqa.javaLessons.sandBox;

public class MyFirstProgram {

    public static void main (String[] args) {
        hello("world");
        hello("user");
        hello("Nikita");


        Point p1 = new Point(1, 2);
        Point p2 = new Point(2, 1);
        int answer = (int) p1.distance(p2);
        System.out.println(answer);
        System.out.println(p1.distance(p2));

        Square s = new Square(5);
        System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

        Rectangle r = new Rectangle(4 ,6);
        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и "+ r.b + " = " + r.area());

    }
    public static void hello(String somebody) {

        System.out.println("Hello, " + somebody + "!");
    }


}
package ru.stqa.javaLessons.sandBox;

public class MyFirstProgram {

    public static void main (String[] args) {
        hello("world");
        hello("user");
        hello("Nikita");

<<<<<<< HEAD
        Point p1 = new Point(1, 2);
        Point p2 = new Point(11, 22);
        System.out.println(p1.distance(p2));
=======
        Square s = new Square(5);
        System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());
>>>>>>> parent of 167c709... Удалены строки из обучения

        Rectangle r = new Rectangle(4 ,6);
        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и "+ r.b + " = " + r.area());

    }
    public static void hello(String somebody) {

        System.out.println("Hello, " + somebody + "!");
    }


}
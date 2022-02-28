package kalkulator;

import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        while(true) {
            System.out.println("-------Calculator--------");
            System.out.println("1.Triangle");
            System.out.println("2.Square");
            System.out.println("3.Circle");
            System.out.println("4.Prism");
            System.out.println("5.Exit");
            System.out.println();


            System.out.print("Your choise:");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    makeTriangle().print();
                    break;
                case 2:
                    makeSquare().print();
                    break;
                case 3:
                    makeCircle().print();
                    break;
                case 4:
                    makePrism().print();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("There is not such an option");
                    System.out.println();
            }
        }
    }

    static Triangle makeTriangle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a:");
        double a = scanner.nextDouble();
        System.out.print("Enter b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter c: ");
        double c = scanner.nextDouble();

        Triangle triangle = new Triangle(a, b, c);
        return triangle;
    }

    static Square makeSquare() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x: ");
        double x = scanner.nextDouble();

        Square square = new Square(x);
        return square;
    }

    static Circle makeCircle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x: ");
        double r = scanner.nextDouble();

        Circle circle = new Circle(r);
        return circle;
    }

    static Prism makePrism() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose prism: 1 - Square, 2 - Circle, 3 - Triangle ");
        int choice = scanner.nextInt();
        double h;
        Figure b = null;
        Prism prism;

        switch(choice){
            case 1:
                b = makeSquare();
                break;
            case 2:
                b = makeCircle();
                break;
            case 3:
                b = makeTriangle();
                break;
            default:
                System.out.println("There is no such an option");
                break;
        }

        System.out.print("Enter h: ");
        h = scanner.nextDouble();
        prism = new Prism(b, h);
        return prism;
    }
}

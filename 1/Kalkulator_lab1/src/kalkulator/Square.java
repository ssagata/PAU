package kalkulator;

public class Square extends Figure
        implements Printable {

    private double p;

    public Square(double p){
        this.p = p;
        if (p <= 0)  throw new IllegalArgumentException("such a square doesnt exist");
    }

    @Override
    double calculateArea() {
        return p*p;
    }

    @Override
    double calculatePerimeter() {
        return 4 * p;
    }


    @Override
    public void print() {
        System.out.println("------Square------");
        System.out.println("Your choise - SQUARE -> side: " + this.p );
        System.out.println("Parimete: " + this.calculatePerimeter());
        System.out.println("Area: " + this.calculateArea());
    }

    public double getP(){return p;}
}
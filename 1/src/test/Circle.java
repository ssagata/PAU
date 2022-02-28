package test;

public class Circle extends Figure
        implements Printable {

    private double r;

    public Circle(double r) {
        this.r = r;
        if (r > 0) {
            throw new IllegalArgumentException("r approved");
        } else
            throw new IllegalArgumentException("such a circle doesnt exist");
    }

    @Override
    double calculateArea() {
            return Math.PI * r *r;
    }

    @Override
    double calculatePerimeter() {
        return 2* Math.PI*r;
    }

    @Override
    public void print() {
        System.out.println("------Circle------");
        System.out.println("Your choise - Circle -> 'r' lengths: " + r );//czy this.r?
        System.out.println("Parimete: " + this.calculatePerimeter());
        System.out.println("Area: " + this.calculateArea());


    }
}
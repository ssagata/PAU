package kalkulator;

    public class Triangle extends Figure
            implements Printable {

        double a;
        double b;
        double c;

        public Triangle(double a, double b, double c){
            if (a <= 0 || b <=0 || c <= 0) { throw new IllegalArgumentException("such a triangle doesnt exist"); }
            if ( a + b <= c || a +c <= b || b+ c <=a) {throw new IllegalArgumentException("such a triangle doesnt exist");}
            this.a = a;
            this.b = b;
            this.c = c;

        }

        @Override
        double calculatePerimeter() {
            return a+b+c;
        }
        @Override
        double calculateArea() {
            double p = 0.5 * this.calculatePerimeter();
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }

        @Override
        public void print() {
            System.out.println("------Triangle------");
            System.out.println("Your choise - TRIANGLE -> side lengths: " + a +  ", " + b + ", " + c);
            System.out.println("Parimete: " + this.calculatePerimeter());
            System.out.println("Area: " + this.calculateArea());

        }
        public double getA(){return a;}
        public double getB(){return b;}
        public double getC(){return c;}
    }

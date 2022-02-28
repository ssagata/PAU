package kalkulator;

    public class Prism implements Printable{

        Figure b;
        private double h;

        public Prism(Figure b, double h){
            if( h <= 0 ) throw new IllegalArgumentException("such a prism doesnt exist");
            this.h = h;
            this.b = b;

        }

        double calculateVolume(){
            return b.calculateArea()* h;
        }
        double calculateAreaF() {
            if( b instanceof Square){
                return 2 * b.calculateArea() + 4 * ((Square)b).getP() * h;
            } else if (b instanceof Circle){
                return 2 * b.calculateArea() + b.calculatePerimeter() * h;
            }else
                return 2 * b.calculateArea() + (((Triangle)b).getA() + ((Triangle) b).getB() + ((Triangle)b).getC()) * h ;
        }


        @Override
        public void print() {
            System.out.println("------Prism------");
            System.out.println("Your choise - Prism -> side lengths: " + b + "and height is: " + h);
            System.out.println("Area: " + this.calculateAreaF());
            System.out.println("Volume: " + this.calculateVolume());
        }
    }

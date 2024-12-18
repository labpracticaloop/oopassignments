
import java.util.Scanner;

class Complex {

    private double real;
    private double img;

    public Complex() {

        this.real = 0;

        this.img = 0;
    }

    public Complex(double real, double img) {
        this.real = real;
        this.img = img;
    }

    public Complex
            add(Complex other) {
        return new Complex(this.real + other.real, this.img + other.img);
    }

    public Complex
            subtract(Complex other) {
        return new Complex(this.real - other.real, this.img - other.img);
    }

    public Complex
            multiply(Complex other) {
        double realpart = this.real * other.real - this.img * other.img;
        double imgpart = this.real * other.img + this.img * other.real;
        return new Complex(realpart, imgpart);
    }

    public Complex
            division(Complex other) {
        double denominator = this.real * this.real + this.img * this.img;

        {
            if (denominator == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
        }
        double realpart = (this.real * other.real + this.img * other.img) / denominator;
        double imgpart = (this.img * other.real - this.real * other.img) / denominator;

        return new Complex(realpart, imgpart);
    }

    public String toString() {
        return img >= 0 ? real + "+" + img + "i" : real + "-" + (-img) + "i";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter real part of 1st Complex Number: ");
        double real1 = scanner.nextDouble();
        System.out.println("Enter imaginary part of 1st Complex Number: ");
        double img1 = scanner.nextDouble();
        Complex c1 = new Complex(real1, img1);
        System.out.println("Enter real part of 2nd Complex Number: ");
        double real2 = scanner.nextDouble();
        System.out.println("Enter imaginary part of 2nd Complex Number: ");
        double img2 = scanner.nextDouble();
        Complex c2 = new Complex(real2, img2);

        Complex Addition = c1.add(c2);
        Complex Subraction = c1.subtract(c2);
        Complex Multiplication = c1.multiply(c2);
        Complex Divison = c1.division(c2);

        System.out.println("1st Complex Number is: " + c1);
        System.out.println("2nd Complex Number is: " + c2);
        System.out.println("Addition is: " + Addition);
        System.out.println("Subraction is: " + Subraction);
        System.out.println("Multiplication is: " + Multiplication);
        System.out.println("Divison is: " + Divison);

    }
}

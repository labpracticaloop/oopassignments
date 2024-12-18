
import java.util.Scanner;

abstract class Shape {

    protected double value1;
    protected double value2;

    public void inputdata(double value1, double value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public abstract void computearea();

}

class Triangle extends Shape {

    @Override
    public void computearea() {
        double area = 0.5 * value1 * value2;
        System.out.println("Area of the triangle is: " + area);
    }
}

class Rectangle extends Shape {

    @Override
    public void computearea() {
        double area = value1 * value2;
        System.out.println("Area of the Rectangle is: " + area);
    }
}

public class dynamicbinding {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Triangle \n2.Rectangle");
        int choice = scanner.nextInt();
        Shape shape;
        switch (choice) {
            case 1:
                shape = new Triangle();
                break;

            case 2:
                shape = new Rectangle();
                break;

            default:
                System.out.println("Invalid choice");
                scanner.close();
                return;
        }

        System.out.println("Enter the first dimension: ");
        double value1 = scanner.nextDouble();
        System.out.println("Enter the second dimension: ");
        double value2 = scanner.nextDouble();

        shape.inputdata(value1, value2);
        shape.computearea();

        scanner.close();
    }

}

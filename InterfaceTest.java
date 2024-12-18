
import java.util.Scanner;

interface Vehicle {

    void changeGear(int newGear);

    void speedUp(int increment);

    void applyBrakes(int decrement);

    void displayStatus();
}

class Bicycle implements Vehicle {

    private int gear;
    private int speed;

    @Override
    public void changeGear(int newGear) {
        this.gear = newGear;
        System.out.println("Bicycle gear changed to: " + gear);
    }

    @Override
    public void speedUp(int increment) {
        this.speed += increment;
        System.out.println("Bicycle speed increased by " + increment + " to: " + speed);
    }

    @Override
    public void applyBrakes(int decrement) {
        this.speed -= decrement;
        if (speed < 0) {
            speed = 0;
        }
        System.out.println("Bicycle speed decreased by " + decrement + " to: " + speed);
    }

    @Override
    public void displayStatus() {
        System.out.println("Bicycle - Gear: " + gear + ", Speed: " + speed);
    }
}

class Bike implements Vehicle {

    private int gear;
    private int speed;

    @Override
    public void changeGear(int newGear) {
        this.gear = newGear;
        System.out.println("Bike gear changed to: " + gear);
    }

    @Override
    public void speedUp(int increment) {
        this.speed += increment;
        System.out.println("Bike speed increased by " + increment + " to: " + speed);
    }

    @Override
    public void applyBrakes(int decrement) {
        this.speed -= decrement;
        if (speed < 0) {
            speed = 0;
        }
        System.out.println("Bike speed decreased by " + decrement + " to: " + speed);
    }

    @Override
    public void displayStatus() {
        System.out.println("Bike - Gear: " + gear + ", Speed: " + speed);
    }
}

class Car implements Vehicle {

    private int gear;
    private int speed;

    @Override
    public void changeGear(int newGear) {
        this.gear = newGear;
        System.out.println("Car gear changed to: " + gear);
    }

    @Override
    public void speedUp(int increment) {
        this.speed += increment;
        System.out.println("Car speed increased by " + increment + " to: " + speed);
    }

    @Override
    public void applyBrakes(int decrement) {
        this.speed -= decrement;
        if (speed < 0) {
            speed = 0;
        }
        System.out.println("Car speed decreased by " + decrement + " to: " + speed);
    }

    @Override
    public void displayStatus() {
        System.out.println("Car - Gear: " + gear + ", Speed: " + speed);
    }
}

public class InterfaceTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select Vehicle:\n1. Bicycle\n2. Bike\n3. Car");
        int choice = scanner.nextInt();
        Vehicle vehicle;

        switch (choice) {
            case 1:
                vehicle = new Bicycle();
                break;
            case 2:
                vehicle = new Bike();
                break;
            case 3:
                vehicle = new Car();
                break;
            default:
                System.out.println("Invalid choice");
                scanner.close();
                return;
        }

        while (true) {
            System.out.println("\nChoose an operation:\n1. Change Gear\n2. Speed Up\n3. Apply Brakes\n4. Display Status\n5. Exit");
            int operation = scanner.nextInt();

            switch (operation) {
                case 1:
                    System.out.print("Enter new gear: ");
                    int newGear = scanner.nextInt();
                    vehicle.changeGear(newGear);
                    break;
                case 2:
                    System.out.print("Enter speed increment: ");
                    int increment = scanner.nextInt();
                    vehicle.speedUp(increment);
                    break;
                case 3:
                    System.out.print("Enter speed decrement: ");
                    int decrement = scanner.nextInt();
                    vehicle.applyBrakes(decrement);
                    break;
                case 4:
                    vehicle.displayStatus();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid operation");
            }
        }
    }
}

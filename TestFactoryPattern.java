
import java.util.Scanner;

abstract class Car {

    public abstract void allocateAccessories();

    public abstract void finalMakeup();

    public void buildCar() {
        allocateAccessories();
        finalMakeup();
    }
}

class Hatchback extends Car {

    @Override
    public void allocateAccessories() {
        System.out.println("Allocating accessories for Hatchback.");
    }

    @Override
    public void finalMakeup() {
        System.out.println("Final makeup for Hatchback.");
    }
}

class Sedan extends Car {

    @Override
    public void allocateAccessories() {
        System.out.println("Allocating accessories for Sedan.");
    }

    @Override
    public void finalMakeup() {
        System.out.println("Final makeup for Sedan.");
    }
}

class SUV extends Car {

    @Override
    public void allocateAccessories() {
        System.out.println("Allocating accessories for SUV.");
    }

    @Override
    public void finalMakeup() {
        System.out.println("Final makeup for SUV.");
    }
}

class CarFactory {

    public static Car getCar(String carType) {
        switch (carType.toLowerCase()) {
            case "hatchback":
                return new Hatchback();
            case "sedan":
                return new Sedan();
            case "suv":
                return new SUV();
            default:
                throw new IllegalArgumentException("Invalid car type: " + carType);
        }
    }
}

public class TestFactoryPattern {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the type of car to build (Hatchback, Sedan, SUV): ");
        String carType = scanner.nextLine();

        try {
            Car car = CarFactory.getCar(carType);
            System.out.println("Building a " + carType + " car...");
            car.buildCar();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}

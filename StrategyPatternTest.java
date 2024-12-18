
import java.util.Scanner;

// Payment Strategy interface
interface PaymentStrategy {

    void pay(double amount);
}

// Credit Card payment strategy
class CreditCardPayment implements PaymentStrategy {

    private String name;
    private String cardNumber;
    private String cvv;
    private String expiryDate;

    public CreditCardPayment(String name, String cardNumber, String cvv, String expiryDate) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

// PayPal payment strategy
class PayPalPayment implements PaymentStrategy {

    private String email;
    private String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

// Bitcoin payment strategy
class BitcoinPayment implements PaymentStrategy {

    private String walletAddress;

    public BitcoinPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Bitcoin.");
    }
}

// Shopping Cart class
class ShoppingCart {

    private double totalAmount;

    public ShoppingCart() {
        this.totalAmount = 0.0;
    }

    public void addItem(double price) {
        totalAmount += price;
        System.out.println("Added item worth " + price + ". Total: " + totalAmount);
    }

    public void checkout(PaymentStrategy paymentMethod) {
        if (totalAmount > 0) {
            paymentMethod.pay(totalAmount);
            totalAmount = 0.0;
        } else {
            System.out.println("Cart is empty. Please add items before checkout.");
        }
    }
}

// Test class
public class StrategyPatternTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        while (true) {
            System.out.println("\nShopping Cart Menu:");
            System.out.println("1. Add Item\n2. Checkout\n3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter item price: ");
                    double price = scanner.nextDouble();
                    cart.addItem(price);
                    break;

                case 2:
                    System.out.println("Choose Payment Method:");
                    System.out.println("1. Credit Card\n2. PayPal\n3. Bitcoin");
                    int paymentChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    PaymentStrategy paymentMethod = null;

                    switch (paymentChoice) {
                        case 1:
                            System.out.print("Enter Name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter Card Number: ");
                            String cardNumber = scanner.nextLine();
                            System.out.print("Enter CVV: ");
                            String cvv = scanner.nextLine();
                            System.out.print("Enter Expiry Date (MM/YY): ");
                            String expiryDate = scanner.nextLine();
                            paymentMethod = new CreditCardPayment(name, cardNumber, cvv, expiryDate);
                            break;

                        case 2:
                            System.out.print("Enter PayPal Email: ");
                            String email = scanner.nextLine();
                            System.out.print("Enter PayPal Password: ");
                            String password = scanner.nextLine();
                            paymentMethod = new PayPalPayment(email, password);
                            break;

                        case 3:
                            System.out.print("Enter Bitcoin Wallet Address: ");
                            String walletAddress = scanner.nextLine();
                            paymentMethod = new BitcoinPayment(walletAddress);
                            break;

                        default:
                            System.out.println("Invalid payment method.");
                    }

                    if (paymentMethod != null) {
                        cart.checkout(paymentMethod);
                    }
                    break;

                case 3:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

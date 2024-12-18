
import java.util.Scanner;

public class ExceptionHandlingTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the first number (Num1): ");
            String input1 = scanner.nextLine();
            System.out.print("Enter the second number (Num2): ");
            String input2 = scanner.nextLine();
            if (input1.equalsIgnoreCase("error") || input2.equalsIgnoreCase("error")) {
                throw new IllegalArgumentException("Manual error triggered by user input.");
            }

            int num1 = Integer.parseInt(input1);
            int num2 = Integer.parseInt(input2);

            int result = num1 / num2;
            System.out.println("The result of division is: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Exception: Invalid input. Please enter valid integers.");
        } catch (ArithmeticException e) {
            System.out.println("Exception: Division by zero is not allowed.");
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Program execution completed.");
        }
    }
}

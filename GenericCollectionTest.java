
import java.util.*;

public class GenericCollectionTest {

    public static int countEvenNumbers(Collection<Integer> collection) {
        int count = 0;
        for (Integer number : collection) {
            if (number % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static int countOddNumbers(Collection<Integer> collection) {
        int count = 0;
        for (Integer number : collection) {
            if (number % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    public static int countPrimeNumbers(Collection<Integer> collection) {
        int count = 0;
        for (Integer number : collection) {
            if (isPrime(number)) {
                count++;
            }
        }
        return count;
    }

    public static int countPalindromes(Collection<String> collection) {
        int count = 0;
        for (String str : collection) {
            if (isPalindrome(str)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isPrime(Integer number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a property to filter:");
        System.out.println("1. Even Numbers\n2. Odd Numbers\n3. Prime Numbers\n4. Palindromes");
        int choice = scanner.nextInt();
        scanner.nextLine();

        Collection<Integer> numbers = new ArrayList<>();
        Collection<String> strings = new ArrayList<>();

        if (choice >= 1 && choice <= 3) {
            System.out.println("Enter numbers (comma-separated):");
            String[] input = scanner.nextLine().split(",");
            for (String s : input) {
                numbers.add(Integer.parseInt(s.trim()));
            }

            switch (choice) {
                case 1:
                    System.out.println("Count of even numbers: " + countEvenNumbers(numbers));
                    break;
                case 2:
                    System.out.println("Count of odd numbers: " + countOddNumbers(numbers));
                    break;
                case 3:
                    System.out.println("Count of prime numbers: " + countPrimeNumbers(numbers));
                    break;
            }
        } else if (choice == 4) {
            System.out.println("Enter strings (comma-separated):");
            String[] input = scanner.nextLine().split(",");
            for (String s : input) {
                strings.add(s.trim());
            }
            System.out.println("Count of palindromes: " + countPalindromes(strings));
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}

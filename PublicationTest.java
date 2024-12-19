
import java.util.Scanner;

abstract class Publication {

    private String title;
    private double price;
    private int copies;
    private int soldCopies;

    public Publication(String title, double price, int copies) {
        this.title = title;
        this.price = price;
        this.copies = copies;
        this.soldCopies = 0;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public void salecopy(int copiessold) {
        if (copiessold > copies) {
            System.out.println("Stock is not enough");
        } else {
            copies -= copiessold;
            soldCopies += copiessold;
            System.out.println(copiessold + " of " + title + " sold");
        }
    }

    public double calculateTotalSale() {
        return soldCopies * price;
    }

    public abstract void displaydetails();
}

class Book extends Publication {

    private String author;

    public Book(String title, double price, int copies, String author) {
        super(title, price, copies);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void ordercopies(int numcopies) {
        setCopies(getCopies() + numcopies);
        System.out.println(numcopies + " of " + getTitle() + " ordered");
    }

    @Override
    public void displaydetails() {
        System.out.println("Title of the book: " + getTitle());
        System.out.println("Price of the book: Rs. " + getPrice());
        System.out.println("Author of the book: " + author);
        System.out.println("Number of Copies available: " + getCopies());
    }
}

class Magazine extends Publication {

    private String currentissue;

    public Magazine(String title, double price, int copies, String currentissue) {
        super(title, price, copies);
        this.currentissue = currentissue;
    }

    public String getCurrentissue() {
        return currentissue;
    }

    public void receiveissue(String newissue) {
        currentissue = newissue;
        System.out.println("New issue received for " + newissue);
    }

    @Override
    public void displaydetails() {
        System.out.println("Title of the magazine: " + getTitle());
        System.out.println("Price of the magazine: Rs. " + getPrice());
        System.out.println("Current issue of the magazine: " + currentissue);
        System.out.println("Number of Copies available: " + getCopies());
    }
}

public class PublicationTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the title of the book: ");
        String bookTitle = scanner.nextLine();
        System.out.print("Enter the price of the book: ");
        double bookPrice = scanner.nextDouble();
        System.out.print("Enter the number of copies of the book: ");
        int bookCopies = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the author of the book: ");
        String bookAuthor = scanner.nextLine();

        Book book = new Book(bookTitle, bookPrice, bookCopies, bookAuthor);

        System.out.print("Enter the number of book copies sold: ");
        int bookSold = scanner.nextInt();
        book.salecopy(bookSold);

        System.out.print("Enter the title of the magazine: ");
        String magazineTitle = scanner.nextLine();
        System.out.print("Enter the price of the magazine: ");
        double magazinePrice = scanner.nextDouble();
        System.out.print("Enter the number of copies of the magazine: ");
        int magazineCopies = scanner.nextInt();
        System.out.print("Enter the current issue of the magazine: ");
        String magazineIssue = scanner.nextLine();

        Magazine magazine = new Magazine(magazineTitle, magazinePrice, magazineCopies, magazineIssue);

        System.out.print("Enter the number of magazine copies sold: ");
        int magazineSold = scanner.nextInt();
        magazine.salecopy(magazineSold);

        System.out.println("\nDetails of the Book:");
        book.displaydetails();
        System.out.println("Total Sale for Book: Rs. " + book.calculateTotalSale());

        System.out.println("\nDetails of the Magazine:");
        magazine.displaydetails();
        System.out.println("Total Sale for Magazine: Rs. " + magazine.calculateTotalSale());

        scanner.close();
    }
}

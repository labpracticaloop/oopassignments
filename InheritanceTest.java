
import java.util.Scanner;

class Employee {

    private String empName;
    private int empId;
    private String address;
    private String mailId;
    private String mobileNo;

    public Employee(String empName, int empId, String address, String mailId, String mobileNo) {
        this.empName = empName;
        this.empId = empId;
        this.address = address;
        this.mailId = mailId;
        this.mobileNo = mobileNo;
    }

    public String getEmpName() {
        return empName;
    }

    public int getEmpId() {
        return empId;
    }

    public String getAddress() {
        return address;
    }

    public String getMailId() {
        return mailId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + empName);
        System.out.println("Address: " + address);
        System.out.println("Email: " + mailId);
        System.out.println("Mobile: " + mobileNo);
    }
}

class Programmer extends Employee {

    private double basicPay;

    public Programmer(String empName, int empId, String address, String mailId, String mobileNo, double basicPay) {
        super(empName, empId, address, mailId, mobileNo);
        this.basicPay = basicPay;
    }

    public void generatePaySlip() {
        double da = 0.97 * basicPay;
        double hra = 0.10 * basicPay;
        double pf = 0.12 * basicPay;
        double staffClubFund = 0.001 * basicPay;
        double grossSalary = basicPay + da + hra;
        double netSalary = grossSalary - (pf + staffClubFund);

        System.out.println("Pay Slip for Programmer:");
        displayEmployeeDetails();
        System.out.println("Basic Pay: $" + basicPay);
        System.out.println("Gross Salary: $" + grossSalary);
        System.out.println("Net Salary: $" + netSalary);
    }
}

class TeamLead extends Employee {

    private double basicPay;

    public TeamLead(String empName, int empId, String address, String mailId, String mobileNo, double basicPay) {
        super(empName, empId, address, mailId, mobileNo);
        this.basicPay = basicPay;
    }

    public void generatePaySlip() {
        double da = 0.97 * basicPay;
        double hra = 0.10 * basicPay;
        double pf = 0.12 * basicPay;
        double staffClubFund = 0.001 * basicPay;
        double grossSalary = basicPay + da + hra;
        double netSalary = grossSalary - (pf + staffClubFund);

        System.out.println("Pay Slip for Team Lead:");
        displayEmployeeDetails();
        System.out.println("Basic Pay: $" + basicPay);
        System.out.println("Gross Salary: $" + grossSalary);
        System.out.println("Net Salary: $" + netSalary);
    }
}

class AssistantProjectManager extends Employee {

    private double basicPay;

    public AssistantProjectManager(String empName, int empId, String address, String mailId, String mobileNo, double basicPay) {
        super(empName, empId, address, mailId, mobileNo);
        this.basicPay = basicPay;
    }

    public void generatePaySlip() {
        double da = 0.97 * basicPay;
        double hra = 0.10 * basicPay;
        double pf = 0.12 * basicPay;
        double staffClubFund = 0.001 * basicPay;
        double grossSalary = basicPay + da + hra;
        double netSalary = grossSalary - (pf + staffClubFund);

        System.out.println("Pay Slip for Assistant Project Manager:");
        displayEmployeeDetails();
        System.out.println("Basic Pay: $" + basicPay);
        System.out.println("Gross Salary: $" + grossSalary);
        System.out.println("Net Salary: $" + netSalary);
    }
}

class ProjectManager extends Employee {

    private double basicPay;

    public ProjectManager(String empName, int empId, String address, String mailId, String mobileNo, double basicPay) {
        super(empName, empId, address, mailId, mobileNo);
        this.basicPay = basicPay;
    }

    public void generatePaySlip() {
        double da = 0.97 * basicPay;
        double hra = 0.10 * basicPay;
        double pf = 0.12 * basicPay;
        double staffClubFund = 0.001 * basicPay;
        double grossSalary = basicPay + da + hra;
        double netSalary = grossSalary - (pf + staffClubFund);

        System.out.println("Pay Slip for Project Manager:");
        displayEmployeeDetails();
        System.out.println("Basic Pay: $" + basicPay);
        System.out.println("Gross Salary: $" + grossSalary);
        System.out.println("Net Salary: $" + netSalary);
    }
}

public class InheritanceTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Mobile Number: ");
        String mobile = scanner.nextLine();

        System.out.print("Enter Basic Pay: ");
        double basicPay = scanner.nextDouble();

        System.out.println("Select Role: \n1. Programmer \n2. Team Lead \n3. Assistant Project Manager \n4. Project Manager");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                Programmer programmer = new Programmer(name, id, address, email, mobile, basicPay);
                programmer.generatePaySlip();
                break;
            case 2:
                TeamLead teamLead = new TeamLead(name, id, address, email, mobile, basicPay);
                teamLead.generatePaySlip();
                break;
            case 3:
                AssistantProjectManager apm = new AssistantProjectManager(name, id, address, email, mobile, basicPay);
                apm.generatePaySlip();
                break;
            case 4:
                ProjectManager pm = new ProjectManager(name, id, address, email, mobile, basicPay);
                pm.generatePaySlip();
                break;
            default:
                System.out.println("Invalid choice");
        }

        scanner.close();
    }
}

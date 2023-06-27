import java.util.Scanner;

public class ATMInterface {
    private double accountBalance;
    private int pin;

    public ATMInterface(double initialBalance, int pin) {
        this.accountBalance = initialBalance;
        this.pin = pin;
    }

    public boolean validatePIN(int inputPIN) {
        return pin == inputPIN;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void deposit(double amount) {
        accountBalance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Amount withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public static void main(String[] args) {
        ATMInterface atm = new ATMInterface(1000.0, 1234); // Set initial balance and PIN

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM!");

        while (true) {
            System.out.print("Enter your PIN: ");
            int inputPIN = scanner.nextInt();

            if (atm.validatePIN(inputPIN)) {
                System.out.println("PIN validated.");

                while (true) {
                    System.out.println("---------------------------");
                    System.out.println("Please select an option:");
                    System.out.println("1. Check Account Balance");
                    System.out.println("2. Deposit");
                    System.out.println("3. Withdraw");
                    System.out.println("4. Exit");
                    System.out.println("---------------------------");

                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.println("Account Balance: $" + atm.getAccountBalance());
                            break;
                        case 2:
                            System.out.print("Enter the amount to deposit: $");
                            double depositAmount = scanner.nextDouble();
                            atm.deposit(depositAmount);
                            System.out.println("Amount deposited: $" + depositAmount);
                            break;
                        case 3:
                            System.out.print("Enter the amount to withdraw: $");
                            double withdrawAmount = scanner.nextDouble();
                            atm.withdraw(withdrawAmount);
                            break;
                        case 4:
                            System.out.println("Thank you for using the ATM. Goodbye!");
                            System.exit(0);
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                }
            } else {
                System.out.println("Invalid PIN. Please try again.");
            }
        }
    }
}

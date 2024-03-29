package AtmInterface;
import java.util.Scanner;

class BankAccount {
 private double balance;

 public BankAccount(double balance) {
     this.balance = balance;
 }

 public double getBalance() {
     return balance;
 }

 public void deposit(double amount) {
     balance += amount;
     System.out.println("Deposited: Rs." + amount);
 }

 public boolean withdraw(double amount) {
     if (amount <= balance) {
         balance -= amount;
         System.out.println("Withdrawn: Rs." + amount);
         return true;
     } else {
         System.out.println("Insufficient funds!");
         return false;
     }
 }
}

class ATM {
 private BankAccount bankAccount;
 private Scanner scanner;

 public ATM(BankAccount bankAccount) {
     this.bankAccount = bankAccount;
     this.scanner = new Scanner(System.in);
 }

 public void displayMenu() {
     System.out.println("\nATM Menu:");
     System.out.println("1. Withdraw");
     System.out.println("2. Deposit");
     System.out.println("3. Check Balance");
     System.out.println("4. Exit");
 }

 public void handleUserInput() {
     int choice;
     do {
         displayMenu();
         System.out.print("Enter your choice: ");
         choice = scanner.nextInt();
         switch (choice) {
             case 1:
                 withdraw();
                 break;
             case 2:
                 deposit();
                 break;
             case 3:
                 checkBalance();
                 break;
             case 4:
                 System.out.println("Exiting...");
                 break;
             default:
                 System.out.println("Invalid choice. Please try again.");
         }
     } while (choice != 4);
 }

 private void withdraw() {
     System.out.print("Enter amount to withdraw: Rs.");
     double amount = scanner.nextDouble();
     if (bankAccount.withdraw(amount)) {
         System.out.println("Remaining Balance: Rs." + bankAccount.getBalance());
     }
 }

 private void deposit() {
     System.out.print("Enter amount to deposit: Rs.");
     double amount = scanner.nextDouble();
     bankAccount.deposit(amount);
     System.out.println("Current Balance: Rs." + bankAccount.getBalance());
 }

 private void checkBalance() {
     System.out.println("Current Balance: Rs." + bankAccount.getBalance());
 }
}

public class AtmInterface {
 public static void main(String[] args) {
	 
	 System.out.println("Here's Your ** ATM Interface **");
	 System.out.println("- through which you can easily access transactional related operations. ");
	 
	 BankAccount bankAccount = new BankAccount(1000);

     ATM atm = new ATM(bankAccount);

     atm.handleUserInput();
 }
}
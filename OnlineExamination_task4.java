import java.util.Scanner;

class BankAccount {
    int balance;
    int prevTransaction;
    String customerName;
    String customerId;
    int flag = 0;

    BankAccount(String cName, String cId) {
        this.customerName = cName;
        this.customerId = cId;
    }

    public final void clrscr() {
        try {
            try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } 
    } catch (final Exception es) {
         System.out.println("nothing here!");
    }

    }

    void checkId() {
        System.out.println("Welcome " + customerName);
        System.out.println();
        System.out.print("Please enter your PIN: ");
        Scanner id = new Scanner(System.in);
        String chk = id.nextLine();
        if (chk.equals(customerId)) {
            clrscr();
            showMenu();
        } else {
            System.out.println("=================================");
            System.out.println("Wrong Login!!");
            System.out.println("=================================");

            if (flag < 3) {
                flag++;
                checkId();
            }
        }
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            prevTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (this.balance > amount) {
            balance = balance - amount;
            prevTransaction = -amount;
        } else {
            clrscr();
            System.out.println("*****************");
            System.out.println("Sufficient Balance not available for the withdrawal!");
            System.out.println("*****************");
        }
    }

    void getPrevTransaction() {
        if (prevTransaction > 0) {
            System.out.println("Deposited: " + prevTransaction);
        } else if (prevTransaction < 0) {
            System.out.println("Withdraw: " + Math.abs(prevTransaction));
        } else {
            System.out.println("No Transaction Occured ");
        }
    }

    public void transfer(double amount, BankAccount acc) {
        if (this.balance < amount) {
            //clrscr();
            System.out.println("===========================================");
            System.out.println("Transfer Fails due to insufficient balance!");
            System.out.println("===========================================");
        } else {
            this.balance -= amount;
            acc.balance += amount;
            System.out.println("Account of " + this.customerName + " becomes $" + this.balance);
            System.out.println("Account of " + acc.customerName + " becomes $" + acc.balance);
            System.out.println("\n");
        }
    }

    private void showMenu() {
        char option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is  " + customerId);
        do {
            System.out.println("\n");
            System.out.println("\n");
            System.out.println("A. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous Transaction");
            System.out.println("E. Transfer");
            System.out.println("F. Quit");

            System.out.println("=================================");
            System.out.println("Enter the option");
            System.out.println("=================================");
            option = sc.next().charAt(0);
            option = Character.toUpperCase(option);
            System.out.println("\n");

            switch (option) {
                case 'A':
                  
                    System.out.println("================");
                    System.out.println("Balance " + balance);
                    System.out.println("================");
                    System.out.println("\n");
                    break;

                case 'B':
                    clrscr();
                    System.out.println("===========================");
                    System.out.println("Enter the amount to deposit");
                    System.out.println("===========================");
                    int amount = sc.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;
                
                case 'C':
                    clrscr();
                    System.out.println("============================");
                    System.out.println("Enter the amount to withdraw");
                    System.out.println("============================");
                    int amount2 = sc.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;

                case 'D':
                    clrscr();
                    System.out.println("================");
                    getPrevTransaction();
                    System.out.println("================");
                    System.out.println("\n");
                    break;

                case 'E':
                   // clrscr();
                    System.out.println("***");
                    System.out.println("To whom");
                    BankAccount bb = new BankAccount("Raj", "1002");
                    System.out.println(bb.customerName);
                    System.out.println("***");
                    System.out.println("Amount to Transfer");
                    double am = sc.nextDouble();
                    System.out.println("***");
                    transfer(am, bb);
                    break;

                case 'F':
                    //clrscr();
                    System.out.println("you are Quit");
                    break;
                
                default:
                    //clrscr();
                    System.out.println("Invalid Option!!! Please Enter Again");
            }

        } while (option != 'F');
        System.out.println("ThankYou For using our services,visit again!!");

    }
}


 class ATMinterface {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount("Dnyanu", "2001");
        ba.checkId();
    }
}


Q4 Online exam

import java.util.Scanner;

public class onlineExam {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username, password;
        boolean isAuthenticated = false;
        
        // Login
        while (!isAuthenticated) {
            System.out.print("Enter username: ");
            username = scanner.nextLine();
            System.out.print("Enter password: ");
            password = scanner.nextLine();
            // Check if the username and password are correct
            if (username.equals("admin") && password.equals("admin123")) {
                isAuthenticated = true;
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        }
        
        // Update Profile and Password
        System.out.print("Enter new username (leave blank to skip): ");
        String newUsername = scanner.nextLine();
        if (!newUsername.isEmpty()) {
            username = newUsername;
        }
        System.out.print("Enter new password (leave blank to skip): ");
        String newPassword = scanner.nextLine();
        if (!newPassword.isEmpty()) {
            password = newPassword;
        }
        System.out.println("Profile updated successfully!");
        
        // MCQs
        int score = 0;
        System.out.println("Give 5 quations answer in 5 minutes:");
        
        System.out.println("1) Who invented Java Programming?");
        System.out.println("a) Guido van Rossum");
        System.out.println("b) James Gosling");
        System.out.println("c) Dennis Ritchie");
        System.out.println("d) Bjarne Stroustrup");
        
        System.out.print("Your answer: ");
        String answer1 = scanner.nextLine();
        if (answer1.equals("b")) {
            score++;
        }
        System.out.println("2) Which component is used to compile, debug and execute the java programs?");
        System.out.println("a) JRE");
        System.out.println("b) JIT");
        System.out.println("c) JDK");
        System.out.println("d) JVM");
        System.out.print("Your answer: ");
        String answer2 = scanner.nextLine();
        if (answer2.equals("c")) {
            score++;
        }
        System.out.println("3) Which of these cannot be used for a variable name in Java?");
        System.out.println("a) identifier & keyword");
        System.out.println("b) identifier");
        System.out.println("c) keyword");
        System.out.println("d) none of the mentioned");
        System.out.print("Your answer: ");
        String answer3 = scanner.nextLine();
        if (answer3.equals("c")) {
            score++;
        }
        System.out.println("4) What is the extension of java code files?");
        System.out.println("a) .js");
        System.out.println("b) .cpp");
        System.out.println("c) .txt");
        System.out.println("d) .java");
        System.out.print("Your answer: ");
        String answer4 = scanner.nextLine();
        if (answer4.equals("d")) {
            score++;
        }
        System.out.println("5) Which of the following is not an OOPS concept in Java?");
        System.out.println("a) Polymorphism");
        System.out.println("b) Inheritance");
        System.out.println("c) Compilation");
        System.out.println("d) Encapsulation");
        System.out.print("Your answer: ");
        String answer5 = scanner.nextLine();
        if (answer5.equals("c")) {
            score++;
        }
        System.out.println("You scored " + score + " out of 5.");
        
        // Timer and auto-submit
        System.out.println("You have 5 minutes to complete the exam.");
        long startTime = System.currentTimeMillis();
        long endTime = startTime + 5 * 60 * 1000; // five minutes in milliseconds
        while (System.currentTimeMillis() < endTime) {
            // Wait for the time to expire
        }
        System.out.println("Time end! Your exam has been automatically submitted.");
        
        // Closing session and logout
        isAuthenticated = false;
        System.out.println("You have been logged out test.");
    }

}

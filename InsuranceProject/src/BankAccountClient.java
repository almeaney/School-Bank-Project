import java.util.Scanner;

public class BankAccountClient {
    public static void main(String[] args) {
        String username;
        String oldPass;
        String password;
        String numChoice;
        double accountBalance;
        double downPayment;

        Scanner in = new Scanner(System.in);

        System.out.println("This program will create a savings account, a checking account, and a mortgage account based on user input.\nEach object will be manipulated by the user.\n");

        System.out.print("Enter your accounts ID: ");
        try{username = in.nextLine();}
        catch(Exception e){
            System.out.print("\nInvalid input. Setting username to jeff");
            username = "jeff";
        }
        System.out.print("\nEnter your password: ");
        try{password = in.nextLine();}
        catch(Exception e){
            System.out.print("\nInvalid input. Setting password to password");
            password = "password";
        }

        System.out.print("Enter your accounts balance: ");
        try{accountBalance = in.nextDouble();}
        catch(Exception e){
            System.out.print("\nInvalid input. Setting account balance to $10");
            accountBalance = 10;
        }
        SavingsAccount savingsAccount = new SavingsAccount(username,password, accountBalance);
        System.out.println(savingsAccount.toString());
        System.out.println("\nWithdrawing $10 for an opening fee.");
        try {
            savingsAccount.withdraw(10);
        }
        catch(NotEnoughMoneyException e){
            System.out.print(e.getMessage());
        }
        System.out.println("\n\n" + savingsAccount.toString());

        //This segment allows the user to input the data necessary for a savings account,
        //and then creates one for them. Afterwords, 10 dollars is withdrawn as an "opening fee"
        //--------------------------------------------------------------------------------------
        
        CheckingAccount checkingAccount = new CheckingAccount();

        System.out.println("\n\n\nChange the information for your checking account (old password is 'password' by default)");
        System.out.println(checkingAccount.toString());
        System.out.print("Enter your accounts ID: ");
        in.nextLine();
        try{username = in.nextLine();}
        catch(Exception e){
            System.out.print("\nInvalid input. Setting username to jeff");
            username = "jeff";
        }
        checkingAccount.setAccountID(username);
        System.out.println("\n" + checkingAccount.toString());

        System.out.print("\nEnter your old password: ");
        try{oldPass = in.nextLine();}
        catch(Exception e){
            System.out.print("\nInvalid input. Setting password to password");
            oldPass = "";
        }
        System.out.print("\nEnter your new password: ");
        try{password = in.nextLine();}
        catch(Exception e){
            System.out.print("\nInvalid input. Setting password to password");
            password = "password";
        }
        try {
            checkingAccount.changePassword(oldPass, password);
        }
        catch(BadPasswordException e){
            System.out.print(e.getMessage());
        }
        System.out.println("\n" + checkingAccount.toString());
        
        //This segment creates a genaric checking account and lets the user change the genaric values
        //to their own.
        //-------------------------------------------------------------------------------------------
       
        System.out.print("Now lets make a mortgage!\nEnter your accounts ID: ");
        try{username = in.nextLine();}
        catch(Exception e){
            System.out.print("\nInvalid input. Setting username to jeff");
            username = "jeff";
        }
        System.out.print("\nEnter your password: ");
        try{password = in.nextLine();}
        catch(Exception e){
            System.out.print("\nInvalid input. Setting password to password");
            password = "password";
        }
        System.out.print("\nEnter your loan size (you will pay this off over 30 years): ");
        try{accountBalance = in.nextDouble();}
        catch(Exception e){
            System.out.print("\nInvalid input. Setting account balance to $10");
            accountBalance = 10;
        }
        in.nextLine();
        System.out.print("\nEnter your down payment: ");
        try{downPayment = in.nextDouble();}
        catch(Exception e){
            System.out.print("\nInvalid input. Setting down payment to 20% of your loan");
            downPayment = accountBalance * 0.2;
        }

        in.nextLine();
        System.out.print("Are you a veteran of the US Armed Services? (enter 'y' or 'n': ");
        try{numChoice = in.nextLine();}
        catch(Exception e){
            numChoice = "";
        }
        MortgageAccount mortgageAccount;
        if(numChoice.equalsIgnoreCase("y")){
            mortgageAccount = new VAMortgage(username,password, accountBalance, (accountBalance /360.00d));
            try {
                mortgageAccount.setDownPayment(downPayment);
            }
            catch(InsufficientDownPayment e){
                System.out.print(e.getMessage());
            }
        }
        else {
            mortgageAccount = new MortgageAccount(username, password, accountBalance, accountBalance / 360);
            try {
                mortgageAccount.setDownPayment(downPayment);
            } catch (InsufficientDownPayment e) {
                System.out.print(e.getMessage());
            }
        }
        System.out.println("\n" + mortgageAccount.toString());
        System.out.println("Making a payment\n");
        mortgageAccount.makePayment();
        System.out.println(mortgageAccount.toString());
    }
}
//This segment prompts the user for all necessary information for a mortgage account. Then, the program determines if the
//down payment is sufficient, followed by emulating a "monthly payment".
//-----------------------------------------------------------------------------------------------------------------------

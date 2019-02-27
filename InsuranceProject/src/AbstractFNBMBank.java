//import java.util.Scanner;
public abstract class AbstractFNBMBank implements FNBMBankAccount {
    protected String accountID;
    protected String password;
    protected double accountBalance;
    //protected boolean login = false;

    //private Scanner in;

    AbstractFNBMBank() {  //Default Constructor, creates generic account
        //in = new Scanner(System.in);

        accountID = "user";
        password = "password";
        accountBalance = 0.0;

    }

    AbstractFNBMBank(String id, String pass, double balance) { //Standard Constructor, creates specific account
        //in = new Scanner(System.in);

        accountID = id;
        password = pass;
        accountBalance = balance;
    }


    public void changePassword(String oldPass, String newPass) throws BadPasswordException { //Allows the client to change their password if they correctly enter the old password
        if(!oldPass.equals(password)) {
                throw new BadPasswordException("Old password does not match new password. Password will remain unchanged");
            }
        password = newPass;
        System.out.println("You have changed your password!");

    }

    public String getAccountID() {
            return accountID;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountID(String id){
                accountID = id;
                System.out.println("\nYou have successfully changed your ID!");
            }

    protected void changeBalance(double change){ //Method to change the balance of the account, wrapped in subclasses
        accountBalance += change;
    }
    public abstract String toString(); //left for subclasses
}



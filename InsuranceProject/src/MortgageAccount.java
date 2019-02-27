import java.text.DecimalFormat;

public class MortgageAccount extends AbstractFNBMBank {
    private double monthlyPayment;

    DecimalFormat round, round2;
    public MortgageAccount (){
        super();
        monthlyPayment = 0;
        round = new DecimalFormat("$#,##0.00");
    }

    public MortgageAccount(String accountID, String password, double loanSize, double mp){
        super(accountID,password, loanSize);
        monthlyPayment = mp;
        round = new DecimalFormat("$#,##0.00");
    }

    public void setDownPayment(double downPayment)throws InsufficientDownPayment { //tells the user if their down payment is too small, and subtracts it from the total loan
        if(downPayment < accountBalance * 0.2)
            throw new InsufficientDownPayment("Your down payment must be 20% of your loan");
        changeBalance(-downPayment);
        System.out.println("Down payment set");
    }

    public void makePayment(){ //makes the monthly payment
        changeBalance(-monthlyPayment);
    }

    public String toString(){ // toStrings with proper format
        String s = "Account: " + accountID + " Mortgage\nPassword: " + password +"\nDebt Remaining: " + round.format(accountBalance) + "\nMonthly Payment" + round.format(monthlyPayment);
        return s;
    }
}

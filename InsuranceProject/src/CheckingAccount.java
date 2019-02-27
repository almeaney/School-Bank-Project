import java.text.DecimalFormat;

public class CheckingAccount extends AbstractFNBMBank {
    private DecimalFormat round;
    public CheckingAccount() {
        super();
        round = new DecimalFormat("$#,##0.00");
    }
    public CheckingAccount(String id, String pass, double balance ) {
        super(id, pass, balance);
        round = new DecimalFormat("$#,##0.00");
    }

    public void deposit(double money){ //Wrapper method for change balance, can be modified to verify required preconditions for depositing
        changeBalance(money);
    }
    public void withdraw(double money) throws NotEnoughMoneyException{ //Wrapper method for change balance, verifies the account actually has sufficient funds
        if(money > accountBalance)
            throw new NotEnoughMoneyException();
        money = 0 - money;
        changeBalance(money);
    }
    public String toString(){ //toStrings with proper format
        String s = "Account: " + accountID + " Checking\nPassword: " + password +"\nBalance: " + round.format(accountBalance);
        return s;
    }
}


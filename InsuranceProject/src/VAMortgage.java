public class VAMortgage extends MortgageAccount {
    public VAMortgage(){
        super();
    }
    public VAMortgage(String accountID, String password, double loanSize, double monthlyPayment){
        super(accountID,password, loanSize,monthlyPayment);
    }

    @Override
    public void setDownPayment(double downPayment) throws InsufficientDownPayment { //Lowers the minimum requirement
        if(downPayment < accountBalance *0.05)
            throw new InsufficientDownPayment("A VA Mortgage down payment must be at least 5% of your loan)");
        changeBalance(-downPayment);
    }
}

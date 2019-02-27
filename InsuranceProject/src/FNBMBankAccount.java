public interface FNBMBankAccount{
    public void changePassword(String oldPass, String newPass) throws BadPasswordException;
    public String getAccountID();
    public void setAccountID(String id);
    public double getAccountBalance();
   // public void login(String idAttempt, String passAttempt);
    //public void logout();
    public String toString();

}


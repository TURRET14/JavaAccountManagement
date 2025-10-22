package Classes;

import java.util.Date;

public class Transaction {
    private Date Date = new Date();
    private boolean IsWithdrawal = true;
    private double Amount = 0;
    private double Balance = 0;
    private String Description = new String();


    public Transaction() {}
    public Transaction(boolean IsWithdrawal, double Amount, double Balance, String Description) {
        this.IsWithdrawal = IsWithdrawal;
        this.Amount = Amount;
        this.Balance = Balance;
        this.Description = Description;
    }

    public Date GetDate() {
        return Date;
    }

    public boolean GetIsWithdrawal() {
        return IsWithdrawal;
    }

    public double GetAmount() {
        return Amount;
    }

    public double GetBalance() {
        return Balance;
    }

    public String GetDescription() {
        return Description;
    }
}

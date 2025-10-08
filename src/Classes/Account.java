package Classes;

import java.util.Date;

public class Account {
    private int ID = 0;
    private double Balance = 0;
    private double AnnualInterestRate = 4.5;
    private Date DateCreated = new Date();

    public Account() {}
    public Account(int ID, int Balance) {
        this.ID = ID;
        this.Balance = Balance;
    }

    public int GetID() {
        return ID;
    }
    public void SetID(int ID) {
        this.ID = ID;
    }

    public double GetBalance() {
        return Balance;
    }
    public void SetBalance(double Balance) {
        this.Balance = Balance;
    }

    public double GetAnnualInterestRate() {
        return AnnualInterestRate;
    }
    public void SetAnnualInterestRate(double AnnualInterestRate) {
        this.AnnualInterestRate = AnnualInterestRate;
    }

    public Date GetDateCreated() {
        return DateCreated;
    }

    public double GetMonthlyInterest() {
        return Balance * AnnualInterestRate / 100 / 12;
    }

    public boolean Withdraw(double Amount) {
        if (Amount > Balance || Amount <= 0) {
            return false;
        }
        else {
            Balance = Balance - Amount;
            return true;
        }
    }

    public boolean Deposit(double Amount) {
        if (Amount <= 0) {
            return false;
        }
        else {
            Balance = Balance + Amount;
            return true;
        }

    }
}

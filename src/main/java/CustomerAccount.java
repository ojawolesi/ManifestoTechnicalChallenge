import java.io.IOException;

public class CustomerAccount {
    int accNum;
    int accPin;
    int overdraft;
    int balance;

    public CustomerAccount(int accNum, int accPin) {
        this.accNum = accNum;
        this.accPin = accPin;
    }

    public int getAccPin() {
        return accPin;
    }

    public void setOverdraft(int overdraft) {
        this.overdraft = overdraft;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    // checks money to be withdrawn against customer's account balance
    public boolean checkMoney(int cash)
    {
        int totalCash = overdraft + balance;

        if ((totalCash - cash) < 0 )
        {
            try {
                main.fwh.writer("FUNDS_ERR\r\n");
                main.fwh.close();
            } catch (IOException e) {
                System.err.println("FUNDS_ERR");
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }

    // withdraws cash from ATM, after checking the withdrawal against the customer and ATM balance
    public void cashWithdrawal (int cash)
    {
        if (checkMoney(cash) && main.atm.checkMoney(cash))
        {
            if (balance < cash)
            {
                balance = 0;
                overdraft = balance - cash;
            }
            else
            {
                balance -= cash;
            }

            int atmBalance = main.atm.getCashBalance();
            atmBalance -= cash;
            main.atm.setCashBalance(atmBalance);
            try {
                main.fwh.writer(balance+ "\r\n");
                main.fwh.close();
            } catch (IOException e) {
                System.err.println("ATM_ERR");
                e.printStackTrace();
            }
        }

    }
}

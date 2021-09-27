import java.io.IOException;

public class ATM {
    int cashBalance;

    public ATM(int cashBalance) {
        this.cashBalance = cashBalance;
    }

    public int getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(int cashBalance) {
        this.cashBalance = cashBalance;
    }

    // checks the amount to be withdrawn against the amount of money in the ATM
    public boolean checkMoney(int cash) {
        if ((cashBalance - cash) < 0 )
        {
            try
            {
                main.fwh.writer("ATM_ERR\r\n");
                main.fwh.close();
            } catch (IOException e)
            {
                System.err.println("ATM_ERR");
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }
}

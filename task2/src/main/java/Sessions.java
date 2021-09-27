import java.io.IOException;

public class Sessions {
    String userInfo;
    CustomerAccount customerAccount;

    public Sessions(String userInfo)
    {
        this.userInfo = userInfo;
    }

    // checks pin entered against the Customer Pin Number
    public boolean checkPin(CustomerAccount cA, int enteredPin)
    {
        if (cA.getAccPin() == enteredPin)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    // processes user's account number, correct PIN and the PIN they actually entered
    public boolean processPin ()
    {
        String [] array = userInfo.split(" ");
        int accNum = Integer.parseInt(array[0]);
        int accPin = Integer.parseInt(array[1]);
        int enteredPin = Integer.parseInt(array[2]);

        customerAccount = new CustomerAccount(accNum, accPin);

        return checkPin(customerAccount, enteredPin);
    }

    // ends the session for entries with wrong PIN Number entered
    public void endSession()
    {
        try
        {
            main.fwh.writer("ACCOUNT_ERR\r\n");
            main.fwh.close();
        }
        catch (IOException e)
        {
            System.err.println("ACCOUNT_ERR");
            e.printStackTrace();
        }
    }

}

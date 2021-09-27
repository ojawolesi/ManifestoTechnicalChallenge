import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main {

    static ATM atm;
    static FileWriteHandler fwh;

    public static void main(String[] args) throws IOException
    {

        File newFile = new File("output.txt");
        FileWriter myWriter = new FileWriter(newFile, true);
        fwh = new FileWriteHandler(myWriter, newFile);

        Scanner sc = null;
        if (0 < args.length) {
            sc = new Scanner(new File(args[0]));
        } else {
            System.err.println("File path missing:" + args.length);
        }

        assert sc != null;
        // create new ATM and and an accompanying session
        int atmBalance = Integer.parseInt(sc.nextLine());
        atm = new ATM(atmBalance);
        Sessions sessions = null;

        // loops through Input file
        while (sc.hasNextLine())
        {
            String input = sc.nextLine();

            // checks for blank space which indicates a new session
            if (input.equals(""))
            {
                String line = sc.nextLine();
                sessions = new Sessions(line);

                if (sessions.processPin())
                {
                    String overdraftLine = sc.nextLine();
                    String [] overdraftArr = overdraftLine.split(" ");
                    sessions.customerAccount.setBalance(Integer.parseInt(overdraftArr[0]));
                    sessions.customerAccount.setOverdraft(Integer.parseInt(overdraftArr[1]));
                }
                else
                {
                    sessions.endSession();
                    sessions = null;
                }
            }
            // checks for balance inquiry code and prints balance accordingly
            else if(input.equals("B"))
            {
                try
                {
                    // checks that the balance inquiry is for an authenticated user session
                    if (sessions == null)
                    {
                        continue;
                    }
                    else
                    {
                        fwh.writer(sessions.customerAccount.getBalance()+ "\r\n");
                        fwh.close();
                    }
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            // otherwise it must be a cash withdrawal
            else
            {
                // checks that the cash withdrawal is for an authenticated user session
                if (sessions == null)
                {
                    continue;
                }
                else
                {
                    String [] withdrawalLine = input.split(" ");
                    if (withdrawalLine[0].equals("W"))
                    {
                        sessions.customerAccount.cashWithdrawal(Integer.parseInt(withdrawalLine[1]));
                    }
                }

            }
        }
        myWriter.close();

    }
}

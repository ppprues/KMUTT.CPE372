/**
 *  Class to exercise a simple EmailMessage class
 *
 *  Created by Sally E. Goldin, 26 June 2017 for CPE 372
 */
public class EmailTester
{
    /**
     * Main function, loops creating and then "sending" emails
     * @param args    Strings passed from command line (not used)
     */
    public static void main(String args[])
    {
        while (true)
        {
            EmailMessage msg = new EmailMessage();
            String to = IOUtils.getString("==> Enter To email address");
            msg.setToAddress(to);
            String from = IOUtils.getString("==> Enter From email address");
            msg.setFromAddress(from);
            String subject = IOUtils.getString("==> Enter email subject");
            msg.setSubject(subject);
            System.out.println("==> Enter message text below. Type END to  finish.");
            while (true)
            {
                String line = IOUtils.getBareString();
                if (line.compareTo("END") == 0)
                    break;
                msg.addToBody(line);
            }
            String response = IOUtils.getString("\nSend? ");
            if ((response.startsWith("Y")) ||
                    (response.startsWith("y")))
            {
                msg.send();
                System.out.println("Sent message to " +
                        msg.getToAddress());
            }
            response = IOUtils.getString("\nContinue? ");
            if ((!response.startsWith("Y")) &&
                    (!response.startsWith("y")))
                break;
        }

    }

}
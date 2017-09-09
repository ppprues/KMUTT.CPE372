/**
 * EmailMessage
 *
 * This class represents a single message, either created or
 * received, in an email client application.
 *
 * Created by Pongnut Jittipanyakul (Prues)
 * ID 58070503419
 *
 * 18 August 2017
 */
public class EmailMessage
{
    private String createdTime; /* time of created */
    private String sentTime;    /* time of sent */
    private String toAddress;   /* to email address */
    private String fromAddress; /* from email address */
    private String subject;     /* subject of message */
    private String line;        /* line of body */

    /**
     * Constructor function, for initialize time and line
     */
    public EmailMessage()
    {
        createdTime = IOUtils.getDateTime();
        line = "";
    }

    /**
     * Set input string to toAddress
     * @param inputString specify to address of message
     */
    public void setToAddress(String inputString)
    {
        toAddress = inputString;
    }

    /**
     * Set input string to fromAddress
     * @param inputString specify from address of message
     */
    public void setFromAddress(String inputString)
    {
        fromAddress = inputString;
    }

    /**
     * Set input string to subject
     * @param inputString specify subject of message
     */
    public void setSubject(String inputString)
    {
        subject = inputString;
    }

    /**
     * Add each line and newline to line
     * @param inputString specify each line of body
     */
    public void addToBody(String inputString)
    {
        line += inputString;
        if (!inputString.contains("\n"))
        {
            line += "\n";
        }
    }

    /**
     * Print out the entire message to the terminal
     */
    public void send()
    {
        System.out.println("-------------------------------------------------");
        System.out.println("[Message created at " + createdTime + "]");
        System.out.println("-------------------------------------------------");
        System.out.println("TO:      " + toAddress);
        System.out.println("FROM:    " + fromAddress);
        System.out.println("SUBJECT: " + subject);
        System.out.println("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -");
        System.out.println(getBody());
        System.out.println("-------------------------------------------------");
        sentTime = IOUtils.getDateTime();
        System.out.println("[Message sent at " + sentTime + "]");
        System.out.println("-------------------------------------------------\n\n");
    }

    /**
     * Return created time
     * @return createdTime  time of created
     */
    public String getCreatedTime()
    {
        return createdTime;
    }

    /**
     * Return sent time
     * @return sentTime  time of sent
     */
    public String getSentTime()
    {
        return sentTime;
    }

    /**
     * Return toAddress
     * @return toAddress    toAddress
     */
    public String getToAddress()
    {
        return toAddress;
    }

    /**
     * Return fromAddress
     * @return fromAddress  fromAddress
     */
    public String getFromAddress()
    {
        return fromAddress;
    }

    /**
     * Return subject
     * @return subject  subject of email
     */
    public String getSubject()
    {
        return subject;
    }

    /**
     * Return body
     * @return line     all lines of body
     */
    public String getBody()
    {
        if (line.length() > 0)
            line = line.substring(0, line.length() - 1);
        return line;
    }
}
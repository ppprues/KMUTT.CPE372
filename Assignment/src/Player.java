import java.io.IOException;

public class Player
{
    private String name;
    private int score;
    private TileCollection playerTiles;

    Player(String name)
    {

    }

    public boolean selectTiles(int howMany)
    {

    }

    public String getName()
    {

    }

    public int getScore()
    {

    }

    public void updateScore(int points)
    {

    }

    public void printTiles()
    {

    }

    /**
     * Asks for a string, and returns it
     * as the function value.
     * @param prompt String to print, telling which coordinate
     * @return the string value entered, without a newline
     */
    protected static String getOneString(String prompt)
    {
        String inputString;
        int readBytes = 0;
        byte buffer[] = new byte[200];
        System.out.println(prompt);
        try
        {
            readBytes = System.in.read(buffer, 0, 200);
        }
        catch (IOException ioe)
        {
            System.out.println("Input/output exception - Exiting");
            System.exit(1);
        }
        inputString = new String(buffer);
        int pos = inputString.indexOf("\n");
        if (pos > 0)
            inputString = inputString.substring(0, pos);
        return inputString;
    }

    public static void main(String args[])
    {
        System.out.println("What is your name?");

        System.out.println("How many tiles do you want?");
    }
}
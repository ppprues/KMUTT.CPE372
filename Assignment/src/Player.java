import java.io.IOException;

public class Player
{
    /**
     * instance of reader that knows how to parse the files
     */
    private static TileReader reader;

    private static final int maxLimit = 7;

    private String name;
    private int score;
    private TileCollection playerTiles;

    Player(String name)
    {
        this.name = name;
        score = 0;
        playerTiles = new TileCollection(0, 7);
    }

    public boolean selectTiles(int howMany)
    {
        return true;
    }

    public String getName()
    {
        return name;
    }

    public int getScore()
    {
        return score;
    }

    public void updateScore(int points)
    {
        score += points;
    }

    public void printTiles()
    {
        playerTiles.printTiles();
    }

    /**
     * Asks for a string, and returns it
     * as the function value.
     *
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
        {
            inputString = inputString.substring(0, pos);
        }
        return inputString;
    }

    public static void main(String args[])
    {
        if (args.length != 1)
        {
            System.out.println("Usage:   java Player [filetoread]\n");
            System.exit(0);
        }
        reader = new TileReader();
        System.out.print("Trying to open'" + args[0] + "' ... ");
        if (!reader.open(args[0]))
        {
            System.out.println("FAILED!\n\n");
            System.exit(1);
        }
        System.out.println("Success!\n");
        Tile nextTile = reader.readTile();
        while (nextTile != null)
        {
            System.out.println("  readTile returned an object: " + nextTile.getLetter() + " " + nextTile.getValue());
            try
            {
                Thread.sleep(50);
            }
            catch (InterruptedException ie)
            {
            }
            nextTile = reader.readTile();
        }
        reader.close();
        System.out.println("\nClosing file and exiting...\n\n");

        String name = getOneString("What is your player name?");
        Player player = new Player(name);
        TileManager allTiles = new TileManager();
        player.selectTiles(maxLimit);
        player.printTiles();
    }
}
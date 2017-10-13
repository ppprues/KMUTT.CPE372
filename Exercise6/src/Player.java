/**
 * Player class to keep name, score and all tiles.
 *
 * Created by Pongnut Jittipanyakul (Prues) ID 58070503419
 *
 * 1 October 2017
 */

import java.io.IOException;

public class Player
{
    /** max limit for playerTiles */
    private static final int maxLimit = 7;

    /** instance of reader that knows how to parse the files */
    private static TileReader reader;

    /** player's name */
    private String name;

    /** player's score */
    private int score;

    /** player's all tiles */
    private TileCollection playerTiles;

    /**
     * Constructor creates a new player by specifying name
     * and set the initial score and playerTiles.
     *
     * @param name player's name
     */
    public Player(String name)
    {
        this.name = name;
        score = 0;
        playerTiles = new TileCollection(0, maxLimit);
    }

    /**
     * Check the maximum limit for player's tiles
     * and return false when it exceeds the limit.
     *
     * @param howMany   player's name
     * @return bOK      true, unless it exceeds the limit (maxTiles)
     */
    public boolean selectTiles(int howMany)
    {
        boolean bOK = false;
        if (playerTiles.getTileCount() < howMany)
        {
            bOK = true;
        }
        return bOK;
    }

    /**
     * Return player's name
     *
     * @return name player's name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Return player's score
     *
     * @return score    player's score
     */
    public int getScore()
    {
        return score;
    }

    /**
     * Update score by add specific points to player's score
     *
     * @param points    points to add
     */
    public void updateScore(int points)
    {
        score += points;
    }

    /**
     * Print all tiles of this player
     */
    public void printTiles()
    {
        playerTiles.printTiles();
    }

    /**
     * Asks for one integer value, and returns it as the function value.
     *
     * @param prompt String to print, telling which coordinate
     * @return the value. Exits with error if user types in something that can't be read as an integer
     */
    protected static int getOneInteger(String prompt)
    {
        int value = 0;
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
        try
        {
            int pos = inputString.indexOf("\n");
            if (pos > 0)
            {
                inputString = inputString.substring(0, pos);
            }
            value = Integer.parseInt(inputString);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("Bad number entered - Exiting");
            System.exit(1);
        }
        return value;
    }

    /**
     * Asks for a string, and returns it as the function value.
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

    /**
     * Main function to test
     */
    public static void main(String args[])
    {
        boolean bEndGame = false; /* end game yet */

        /* Create all tiles from argument */
        if (args.length != 2)
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
        reader.readTiles();
        TileManager bagTiles = new TileManager(reader.getAllFiles());
        reader.close();
        System.out.println("\nClosing file and exiting...\n\n");

        /* Initial the first player */
        String name = getOneString("What is first player's name?");
        Player firstPlayer = new Player(name);
        Player secondPlayer = new Player("Com");

        /* Draw tiles for player */
        while (firstPlayer.selectTiles(maxLimit) && bagTiles.getTileCount() > 0)
        {
            Tile selectTile = bagTiles.selectRandomTile();
            if (selectTile != null && !firstPlayer.playerTiles.addTile(selectTile))
            {
                System.out.println("Can't add tile");
            }
        }
        firstPlayer.printTiles();

        /* Loop until end game */
        while (!bEndGame)
        {
            System.out.println("\n" + firstPlayer.getName() + " " + firstPlayer.getScore() + "-" + secondPlayer.getScore() + " " + secondPlayer.getName());
            System.out.println("\n1 - Pass\n2 - Exchange\n3 - Play\n0 - Give up");
            int turn = getOneInteger("What do " + firstPlayer.getName() + " want to do?");
            if (turn == 1) /* Pass */
            {
                System.out.println(firstPlayer.getName() + " say \"Pass!\"");
            }
            if (turn == 2) /* Exchange */
            {
                System.out.println(firstPlayer.getName() + " say \"Exchange!\"");
                /* Exchange method */
                while (firstPlayer.selectTiles(maxLimit) && bagTiles.getTileCount() > 0)
                {
                    Tile selectTile = bagTiles.selectRandomTile();
                    if (selectTile != null && !firstPlayer.playerTiles.addTile(selectTile))
                    {
                        System.out.println("    Can't add tile");
                    }
                }
            }
            else if (turn == 3) /* Play */
            {
                System.out.println(firstPlayer.getName() + " say \"Play!\"");
                /* Play method */
                if (firstPlayer.playerTiles.getTileCount() > 0)
                {
                    Tile playTile = firstPlayer.playerTiles.getRandom();
                    firstPlayer.updateScore(playTile.getValue());
                    firstPlayer.playerTiles.removeTile(playTile);
                }
                else
                {
                    System.out.println("You don't have tile to play");
                }
            }
            else if (turn == 0) /* Give up */
            {
                bEndGame = true;
            }

            /* Print all tiles when finished each turn */
            firstPlayer.printTiles();
        }

        System.out.println(firstPlayer.getName() + " Win! with score " + firstPlayer.getScore() + "-" + secondPlayer.getScore() + " " + secondPlayer.getName());
    }
}
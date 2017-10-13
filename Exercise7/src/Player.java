/**
 * Player.java
 *
 * This class represents a single player in the Scrabble game.
 * Currently this class is incomplete. All it can do is draw random
 * tiles.
 *
 * Created by Pongnut Jittipanyakul (Prues) ID: 58070503419
 *
 * Modified for Exercise 7
 * - Add getName() method.
 * - Add clearTiles() method.
 *
 * 15 October 2017
 */
public class Player
{
    /**
     * The player's tiles for making words
     */
    private TileCollection playerTiles = new TileCollection(0, 7);

    /* each player has a maximum of 7 tiles at any one time */

    /**
     * Player's name
     */
    private String name;

    /**
     * Player's current score
     */
    private int score = 0;

    /**
     * Contructor sets the name
     * @param playerName   Name of this player
     */
    public Player(String playerName)
    {
        name = playerName;
    }

    /**
     * Return the name
     * @return player's name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Return the score
     * @return player's score
     */
    public int getScore()
    {
        return score;
    }

    /**
     * Select tiles randomly from the TileManager
     * @param  howMany  How many tiles to select
     * @return true if successful, false if error
     *         Error could involve there are not enough tiles
     *            left, or the user asking for too many tiles
     */
    public boolean selectTiles(int howMany)
    {
        boolean bOk = true;
        if ((playerTiles.getTileCount() + howMany) > playerTiles.getMaxTiles())
        {
            System.out.println("Error - Too many tiles requested");
            bOk = false;
        }
        else
        {
            int i = 0;
            Tile tile = null;
            for (i = 0; (i < howMany) && bOk; i++)
            {
                tile = TileManager.selectRandomTile();
                if (tile == null)
                {
                    bOk = false;
                }
                else
                {
                    bOk = playerTiles.addTile(tile);
                }
            }
        }
        return bOk;
    }

    /**
     * Delete all tiles in the collection
     */
    public void clearTiles()
    {
        playerTiles.clear();
    }

    /**
     * Print the tiles the player currently holds
     */
    public void printTiles()
    {
        System.out.println("Tiles for Player " + name);
        playerTiles.printTiles();
    }

    /**
     * Update the player's score
     * @param points  points to add or subtract (if negative)
     */
    public void updateScore(int points)
    {
        score = score + points;
    }

    /**
     * Return tile with highest score. Used to determine
     * player who will go first.
     * @return Tile with highest score, of all those in playerTiles
     */
    public Tile getHighest()
    {
        return playerTiles.getHighest();
    }

    /**
     * Main function for testing/exercising the use case
     */
    public static void main(String args[])
    {
    /* Fill the pool of tiles */
        TileManager.initialize();

        Player player = new Player("Sally Goldin");
        if (player.selectTiles(4))
        {
            System.out.println("Successfully selected 4 tiles\n");
        }
        else
        {
            System.out.println("Error selecting 4 tiles\n");
        }
        player.printTiles();
        if (player.selectTiles(3))
        {
            System.out.println("Successfully selected 3 tiles\n");
        }
        else
        {
            System.out.println("Error selecting 3 tiles\n");
        }
        player.printTiles();
        if (player.selectTiles(2))
        {
            System.out.println("Successfully selected 2 tiles\n");
        }
        else
        {
            System.out.println("Error selecting 2 tiles\n");
        }
        player.printTiles();
        System.out.println("Highest score tile is " + player.getHighest());
    }
}

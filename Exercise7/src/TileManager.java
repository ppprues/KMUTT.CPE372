/**
 * TileManager.java
 *
 * This class represents the pool of unselected tiles in the
 * game of Scrabble.
 *
 * All methods are static because this is a singleton class.
 *
 * Created by Pongnut Jittipanyakul (Prues) ID: 58070503419
 *
 * Modified for Exercise 7
 * - Add addTile() method.
 *
 * 15 October 2017
 */
public class TileManager
{
    private static final String tileFileName = "alltiles.txt";

    /**
     * collection of tiles in the pool
     */
    private static TileCollection tiles = new TileCollection(0, 100);

    /**
     * Set up all the tiles necessary for a new game
     * This could be done via reading from a file or
     * by hardcoding the data
     */
    public static void initialize()
    {
        tiles.clear();  /* get rid of any old tiles */
        TileFileReader reader = new TileFileReader();
        if (!reader.open(tileFileName))
        {
            System.out.println("Error opening tile file " +
                    tileFileName + " in TileManager:initialize()");
            System.exit(0);
        }
        Tile nextTile = null;
        while ((nextTile = reader.getTile()) != null)
        {
            boolean bOk = tiles.addTile(nextTile);
            if (bOk)
            {
                //System.out.println("Successfuly added " + nextTile);
            }
            else
            {
                System.out.println("Error adding " + nextTile);
            }
        }
        System.out.println("TileManager initialized");
    }

    /**
     * Add a tile to the pool.
     * @param newTile   Tile to add
     * @return true if successful, false if would violate the max constraint
     *         returns false if tile already in the set as well
     */
    public static boolean addTile(Tile newTile)
    {
        return tiles.addTile(newTile);
    }

    /**
     * Get a random tile from the pool and return it to the
     * user, deleting it from the collection.
     * @return random Tile or null if the pool is empty
     */
    public static Tile selectRandomTile()
    {
        Tile theTile = tiles.getRandom();
        if (theTile != null)
        {
            tiles.removeTile(theTile);
        }
        return theTile;
    }

    /**
     * Get current number of tiles in the pool 
     * @return current size of tile collection
     */
    public static int getTilesRemaining()
    {
        return tiles.getTileCount();
    }

    /** Main function for testing */
    public static void main(String args[])
    {
        TileManager.initialize();
        for (int i = 0; i < 5; i++)
        {
            Tile t = selectRandomTile();
            if (t != null)
            {
                System.out.println("Selected " + t);
            }
        }
        System.out.println(TileManager.getTilesRemaining() + " tiles remain in pool");
    }
}
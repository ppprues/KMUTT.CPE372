/**
 * TileCollection class to keep all tiles in TreeSet
 * including min and max possible range.
 *
 * Created by Pongnut Jittipanyakul (Prues) ID 58070503419
 *
 * 1 October 2017
 */

import java.util.Random;
import java.util.TreeSet;

public class TileCollection
{
    /** all tiles in TreeSet */
    private TreeSet<Tile> tiles;

    /** min tiles */
    private int minTiles;

    /** max tiles */
    private int maxTiles;

    /**
     * Constructor creates all tiles in TreeSet
     * by specifying min and max possible range.
     *
     * @param minTiles  min tiles
     * @param maxTiles  max tiles
     */
    public TileCollection(int minTiles, int maxTiles)
    {
        tiles = new TreeSet<>();
        this.minTiles = minTiles;
        this.maxTiles = maxTiles;
    }

    /**
     * Print all tiles of this collection
     */
    public void printTiles()
    {
        for (Tile currentTile : tiles)
        {
            System.out.println("\"" + currentTile.getLetter() + "\" Value: " + currentTile.getValue() + " Count: " + currentTile.getCount());
        }
    }

    /**
     * Return this tile TileCollection size.
     *
     * @return size total tiles count
     */
    public int getTileCount()
    {
        return tiles.size();
    }

    /**
     * Add one tile to this TileCollection
     * and return the success or failure.
     *
     * @param  tile tile to add
     * @return bOK  true, unless it exceeds the limit (maxTiles)
     */
    public boolean addTile(Tile tile)
    {
        boolean bOK = true;
        if (getTileCount() <= maxTiles)
        {
            tiles.add(tile);
        }
        else
        {
            bOK = false;
        }
        return bOK;
    }

    /**
     * Remove one tile from this TileCollection
     * and return the success or failed.
     *
     * @param  tile tile to remove
     * @return bOK  true, unless it exceeds the limit (minTiles)
     */
    public boolean removeTile(Tile tile)
    {
        boolean bOK = true;
        if (getTileCount() > minTiles)
        {
            tiles.remove(tile);
        }
        else
        {
            bOK = false;
        }
        return bOK;
    }

    /**
     * Return the highest tile in this TileCollection.
     *
     * @return tile  the highest tile in this TileCollection
     */
    public Tile getHighest()
    {
        return tiles.last();
    }

    /**
     * Return the lowest tile in this TileCollection.
     *
     * @return tile  the lowest tile in this TileCollection
     */
    public Tile getLowest()
    {
        return tiles.first();
    }

    /**
     * Return the random tile in this TileCollection.
     *
     * @return tile  the random tile in this TileCollection
     */
    public Tile getRandom()
    {
        Tile tile = null;
        int randomNumber = new Random().nextInt(getTileCount());
        int i = 0;
        for (Tile currentTile : tiles)
        {
            if (i == randomNumber)
            {
                tile = currentTile;
                break;
            }
            i++;
        }
        return tile;
    }
}
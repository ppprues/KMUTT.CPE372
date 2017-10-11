/**
 * TileManager class to keep all tiles in bag
 *
 * Created by Pongnut Jittipanyakul (Prues) ID 58070503419
 *
 * 1 October 2017
 */

public class TileManager
{
    /** all tiles of bag */
    private TileCollection tiles;

    /**
     * Constructor creates all tiles for bag.
     *
     * @param tiles all tiles in the beginning game
     */
    public TileManager(TileCollection tiles)
    {
        this.tiles = tiles;
    }

    /**
     * Return this TileCollection size.
     *
     * @return size total tiles count
     */
    public int getTileCount()
    {
        return tiles.getTileCount();
    }

    /**
     * Return the random tile in this TileCollection.
     *
     * @return tile  the random tile in this TileCollection
     *               or null for can't select tile.
     */
    public Tile selectRandomTile()
    {
        Tile randomTile = tiles.getRandom();
        if (!tiles.removeTile(randomTile))
        {
            randomTile = null;
        }

        return randomTile;
    }
}
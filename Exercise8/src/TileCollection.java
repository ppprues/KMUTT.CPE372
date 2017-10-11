import java.util.*;
/**
 *  TileCollection.java
 * 
 *  A TileCollection is a group of Scrabble tiles with constraints
 *  on the number of tiles it can contain. TileCollection encapsulates
 *  access to groups of tiles.
 *    Created by Sally Goldin, 2 October 2017
 */
public class TileCollection
{
    /**
     * Collection of tiles sorted by score
     */
    protected TreeSet<Tile> tiles = new TreeSet<Tile>(new TileComparator());

    /**
     * minimum number of tiles in this collection
     */
    protected int minTiles=0;


    /**
     * maximum number of tiles in this collection
     */
    protected int maxTiles=100;

    /**
     * Constructor sets the min and max to something other than
     * the default.
     * @param  min      minimum number of tiles allowed
     * @param  max      maximum number of tiles allowed
     */
    public TileCollection(int min, int max)
    {
	minTiles = min;
	maxTiles = max;
    }

    /**
     * Print all the tiles in the collection, in order from smallest
     * to largest, ten per row.
     */
    public void printTiles()
    {
	Iterator<Tile> it = tiles.iterator();
	int count = 0;
	while (it.hasNext())
	{
	    Tile thisTile = it.next();
	    System.out.print(thisTile + "  ");
	    count++;
	    if (count % 10 == 0)
		System.out.println("");
	}
	System.out.println("");
    }


    /**
     * Return the maximum number of tiles
     * @return  max number of tiles
     */
    public int getMaxTiles()
    {
	return maxTiles;
    }

    /**
     * Return the minimum number of tiles
     * @return  min number of tiles
     */
    public int getMinTiles()
    {
	return minTiles;
    }


    /**
     * Return the current number of tiles
     * @return  current size of the tiles collection
     */
    public int getTileCount()
    {
	return tiles.size();
    }

    /**
     * Add a tile to the collection, preserving the constraints
     * @param newTile   Tile to add
     * @return true if successful, false if would violate the max constraint
     *         returns false if tile already in the set as well
     */
    public boolean addTile(Tile newTile)
    {
	if (tiles.size() == maxTiles)
	{
	    return false;
	}
	else
	{
	    return tiles.add(newTile);
	}
    }

    /**
     * Removes a tile from the collection
     * @param tile   Tile to remove
     * @return true for success, false if tile not in the collection
     *         or if this would violate the minimum constraing
     */
    public boolean removeTile(Tile tile)
    {
	if (tiles.contains(tile))
	{
	    if ((tiles.size() - 1) >=  minTiles)
	    {
	        tiles.remove(tile);
	        return true;
	    }
	    else
	    {
		return false;
	    }
	}
	else
	{
	    return false;
	}
    }

    /**
     * Delete all tiles in the collection 
     */
    public void clear()
    {
	tiles.clear();
    }

    /**
     * Get the tile with the highest score 
     * Note this just gets a reference; it does not change the
     * contents of the collection
     * @return tile with highest score or null if collection is empty
     */
    public Tile getHighest()
    {
	if (tiles.isEmpty())
	    return null;
	else 
	    return tiles.last();  /* treeset is in ascending order */
    }

    /**
     * Get the tile with the lowest score 
     * Note this just gets a reference; it does not change the
     * contents of the collection
     * @return tile with highest score or null if collection is empty
     */
    public Tile getLowest()
    {
	if (tiles.isEmpty())
	    return null;
	else 
	    return tiles.first();  /* treeset is in ascending order */
    }

    /**
     * Get a random tile 
     * Note this just gets a reference; it does not change the
     * contents of the collection
     * @return a randomly selected tile or null if collection is empty
     */
    public Tile getRandom()
    {
	if (tiles.isEmpty())
	    return null;
	else 
	{
	    Object contents[] = tiles.toArray();
	    int index = (int) (Math.random() * 10000) % tiles.size();
	    //System.out.println("random index is " + index);
	    return (Tile) contents[index];
	}
    }

    /**
     * Test driver main
     */
    public static void main(String args[])
    {
	int i;
	boolean result;
	TileCollection c = new TileCollection(0,7);
	Tile[] tileArray = new Tile[10];
	tileArray[0] = new Tile("A",1);
	tileArray[1] = new Tile("A",1);
	tileArray[2] = new Tile("Q",10);
	tileArray[3] = new Tile("T",1);
	tileArray[4] = new Tile("X",9);
	tileArray[5] = new Tile("B",2);
	tileArray[6] = new Tile("P",3);
	tileArray[7] = new Tile("E",1);
	tileArray[8] = new Tile("E",1);
	tileArray[9] = new Tile("U",1);
	for (i = 0; i < 10; i++)
	{
	    result = c.addTile(tileArray[i]);
	    System.out.println("Tried to add " + tileArray[i] + " result " +
			       result);
	}
	for (i = 0; i < 4; i++)
        {
	    Tile t = c.getRandom();
	    System.out.println("Got random tile " + t);
	}

	for (i = 0; i < 4; i++)
        {
	    Tile t = c.getLowest();
	    System.out.println("Got lowest " + t);
	    if (t != null)
	    {
		result = c.removeTile(t);
		System.out.println("removed result is " + result +
				   " current count is " + c.getTileCount());
	    }
	}
	for (i = 0; i < 4; i++)
        {
	    Tile t = c.getHighest();
	    System.out.println("Got highest " + t);
	    if (t != null)
	    {
		result = c.removeTile(t);
		System.out.println("removed result is " + result +
				   " current count is " + c.getTileCount());
	    }
	}

    }

}
/**
 * Tile class to keep each tile including letter, value and count
 *
 * Created by Pongnut Jittipanyakul (Prues) ID 58070503419
 *
 * 1 October 2017
 */

public class Tile implements Comparable<Tile>
{
    /** tile's letter */
    private String tileLetter;

    /** tile's value */
    private int tileValue;

    /** tile's count */
    private int tileCount;

    /**
     * Constructor creates a new tile
     * by specifying letter, value and count.
     *
     * @param letter    tile's letter
     * @param value     tile's value
     * @param count     tile's count
     */
    public Tile(String letter, int value, int count)
    {
        tileLetter = letter;
        tileValue = value;
        tileCount = count;
    }

    /**
     * Return tile's letter
     *
     * @return tileLetter tile's letter
     */
    public String getLetter()
    {
        return tileLetter;
    }

    /**
     * Return tile's value
     *
     * @return tileValue tile's value
     */
    public int getValue()
    {
        return tileValue;
    }

    /**
     * Return tile's count
     *
     * @return tileCount tile's count
     */
    public int getCount()
    {
        return tileCount;
    }

    @Override
    public int compareTo(Tile o)
    {
        if (this.getLetter().equals(o.getLetter()))
        {
            return Integer.compare(this.getCount(), o.getCount());
        }
        else
        {
            return this.getLetter().compareTo(o.getLetter());
        }
    }
}
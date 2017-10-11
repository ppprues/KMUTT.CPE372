/**
 * Tile.java
 *
 * A Tile represents a single letter in Scrabble.
 *    Created by Sally Goldin, 2 October 2017
 */
public class Tile
{
    /**
     * Static counter so we can create unique sequence numbers
     */
    private static int counter = 0;

    /** Letter associated with this tile. "-" means a blank tile. */
    private String tileLetter = "";

    /** Point score associated with this tile */
    private int tileValue = 0;

    /** Sequence number so we can distinguish different instances of the
     *   same letter.
     */
    private int sequence;


    /**
     * Constructor sets the tile letter and score.
     * We should probably validate to make sure the letter is legal 
     * but it's akward to deal with errors in constructors.
     * @param  letter   Tile letter
     * @param  score    Tile score
     */
    public Tile(String letter,int score)
    {
	tileLetter = letter;
	tileValue = score;
	counter++;
	sequence = counter;
    }

    /**
     * Getter for letter 
     * @return tile letter
     */
    public String getTileLetter()
    {
	return tileLetter;
    }

    /**
     * Getter for score 
     * @return tile score
     */
    public int getTileValue()
    {
	return tileValue;
    }


    /**
     * Getter for sequence 
     * @return sequence for this tile
     */
    public int getSequence()
    {
	return sequence;
    }

    /**
     * Override toString so we can easily print a tile
     * @return String to print
     */
    public String toString()
    {
	return new String(tileLetter + "(" + tileValue + ")");
    }

    /**
     * Override equals() so we can distinguish different tiles with
     * the same letter.
     * @param otherTile   Tile we are checking
     * @return true if current instance equals otherTile else false
     */
    public boolean equals(Tile otherTile)
    {
	if ((otherTile.getTileLetter().compareTo(tileLetter) == 0) &&
	    (otherTile.getSequence() == sequence) &&
	    (otherTile.getTileValue() == tileValue))
	    return true;
	else
	    return false;
    }

}
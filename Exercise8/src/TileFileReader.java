/**
 * Class to read info about Scrabble tiles from a file
 * and create tiles.
 *
 * Each line of the file has the following structure
 *
 *  TILE A 1 10
 *
 *  First field is keyword - lines that do not start with TILE are ignored
 *  Second field is the tile letter
 *  Third field is the tile score
 *  Fourth field is the count of this tile in the game.
 *
 * Created by Sally Goldin, 2 October 2017
 */
public class TileFileReader extends TextFileReader
{

    /** Count multiple tiles of the same type */
    private int tileCount = -1;

    /** Current letter for tiles */
    private String currentLetter = null;

    /** Current score for tiles */
    private int currentScore = -1;

    /**
     * Try to convert a string to an integer.
     * @param stringToConvert    String that we think should be an integer
     * @return integer value or -999 if conversion error occurred.
     */
    private int convertToInt(String stringToConvert)
    {
	int value = -999; /* start by assuming bad value */
	try
	{
	   value = Integer.parseInt(stringToConvert);
	}
	catch (NumberFormatException nfe)
	{
	}
	return value;
    }


    /**
     * Get the next tile. This method reads a line (if necessary)
     * then creates and returns a Tile as specified. It automatically
     * handles the field indicating multiple tiles of the same letter.
     * @return new Tile, or null if the file is finished
     */
    public Tile getTile()
    {
	Tile newTile = null;
	//System.out.println("getTile - currentLetter=" + currentLetter + 
	//		   " tileCount=" + tileCount);
	if (tileCount <= 0)  /* we are not already processing a line */
	{
	    String line = null;
	    do
	    {
		line = getNextLine();
		if (line == null)
		{
		    tileCount = 0;
		}
		else
		{
		    if (line.startsWith("TILE"))
		    {
			String fields[] = line.split(" ");
			currentLetter = fields[1];
			currentScore = convertToInt(fields[2]);
			tileCount = convertToInt(fields[3]);
			break;
		    }
		}
	    } while (line != null);
	}
	/* now create and return a tile */
	if (tileCount > 0)
	{
	    newTile = new Tile(currentLetter,currentScore);
	    tileCount--;
	}
	return newTile;  /* will be null if we've reached EOF */
    }









}
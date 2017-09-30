import java.util.*;

/**
 * Class that reads from a text file defining shapes and
 * creates instances of AbstractShape subclasses.
 * Possible lines in the file include:
 * TRIANGLE x1 y1 x2 y2 x3 y3
 * SQUARE x y side
 * DIAMOND x y vaxis haxis
 * CIRCLE x y radius
 *
 * Created by Sally Goldin, 29 August 2017 for Exercise 4
 */
public class TileReader extends TextFileReader
{
    /**
     * Try to convert a string to an integer.
     *
     * @param stringToConvert String that we think should be an integer
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
     * check line from shape file to make sure it has correct shape
     * type and correct arguments.
     *
     * @param line String read from the file
     * @return The shape specified by the command line, or null
     * if the line contains any errors.
     */
    private Tile parseCheckShapeCommand(String line)
    {
        Tile newTile = null;
        String fields[] = line.split(" ");
        if (fields.length == 3)  /* should be three fields */
        {
            newTile = new Tile(fields[1], convertToInt(fields[2]));
        }
        else
        {
            System.out.println("\t\tLine has too few fields");
        }
        return newTile;  /* could be null */
    }

    /**
     * Read the next line from the file.
     * Parse it and return the appropriate type of shape
     * based on the content of the line.
     * If an error is found, just skips to the next line,
     * until it gets to a good line or the end of the file.
     *
     * @return specific subclass instance of AbstractShape, or null
     * if the end of the file.
     */
    public Tile readTile()
    {
        Tile newTile = null;
        boolean bError = false;
        String line;
        do
        {
            line = getNextLine();
            if (line != null)
            {
                newTile = parseCheckShapeCommand(line);
                if (newTile == null)
                {
                    System.out.println("\t\tBad line: '" + line + "' ==> Skipping");
                }
            }
        }
        while ((newTile == null) && (line != null));
        return newTile;
    }
}
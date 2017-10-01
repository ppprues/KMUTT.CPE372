/**
 * TileReader class to reads from a text file defining tiles
 * and creates TileCollection for initial letter distributions.
 *
 * Initial text file format:
 *      E 1 24 means letter "E" scores 1 point and contains 24 tiles.
 *
 * Created by Pongnut Jittipanyakul (Prues) ID 58070503419
 *
 * 1 October 2017
 */

public class TileReader extends TextFileReader
{
    /* initial TileCollection */
    private TileCollection allTiles = new TileCollection(0, 200);

    /**
     * Create tile for each line from text file.
     * @param fields    Array of strings parsed from file line.
     */
    private void createTiles(String fields[])
    {
        int totalDuplicate = Integer.parseInt(fields[2]);
        for (int i = 0; i < totalDuplicate; i++)
        {
            allTiles.addTile(new Tile(fields[0], Integer.parseInt(fields[1]), i));
        }
    }

    /**
     * Check line from text file to make sure it has correct format.
     *
     * @param line  String read from the file
     * @return bOK  true, unless that line can't be used to create.
     */
    private boolean parseCheckTileCommand(String line)
    {
        boolean bOK = true;
        String fields[] = line.split(" ");
        if (fields.length == 3)  /* should be three fields */
        {
            System.out.println("  readTile returned an object: \"" + fields[0] + "\" Value: " + fields[1] + " Total Number of Tiles: " + fields[2]);

            if (fields[0].equals("[blank]"))
            {
                fields[0] = " ";
            }

            if (Integer.parseInt(fields[1]) >= 0 && Integer.parseInt(fields[2]) > 0)
            {
                createTiles(fields);
            }
            else /* not a valid line */
            {
                System.out.println("\t\tInvalid tile command");
            }
        }
        else
        {
            System.out.println("\t\tLine has too few fields");
            bOK = false;
        }
        return bOK;
    }

    /**
     * Read all line from the file.
     * Parse each line and return the success or failure
     * based on the content of the line.
     * If an error is found, just skips to the next line,
     * until it gets to a good line or the end of the file.
     */
    public void readTiles()
    {
        boolean bError = false;
        String line;
        line = getNextLine();
        while (line != null)
        {
            if (!parseCheckTileCommand(line))
            {
                System.out.println("\t\tBad line: '" + line + "' ==> Skipping");
            }
            line = getNextLine();
        }
    }

    /**
     * Return this TileCollection.
     *
     * @return allTiles allTiles in TileCollection
     */
    public TileCollection getAllFiles()
    {
        return allTiles;
    }
}
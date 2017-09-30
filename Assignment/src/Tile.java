public class Tile
{
    private String tileLetter;
    private int tileValue;

    Tile(String letter, int value)
    {
        tileLetter = letter;
        tileValue = value;
    }

    public String getLetter()
    {
        return tileLetter;
    }

    public int getValue()
    {
        return tileValue;
    }
}
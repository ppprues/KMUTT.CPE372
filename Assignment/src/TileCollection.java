import java.util.TreeSet;

public class TileCollection
{
    private TreeSet<Tile> tiles;
    private int maxTiles;
    private int minTiles;

    TileCollection(int minTiles, int maxTiles)
    {
        tiles = new TreeSet<Tile>();
        tiles.first();
        this.maxTiles = maxTiles;
        this.minTiles = minTiles;
    }

    public void printTiles()
    {

    }

    /*public int getTileCount()
    {
        return tiles.size();
    }

    public boolean addTile(Tile tile)
    {

    }

    public boolean removeTile(Tile tile)
    {

    }
*/
    public Tile getHighest()
    {
        return tiles.last();
    }

    public Tile getLowest()
    {
        return tiles.first();
    }

    /*public Tile getRandom()
    {

    }*/
}
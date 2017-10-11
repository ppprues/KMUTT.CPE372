/**
 *  TileManagerTester.java
 *
 *   Test to see if we can create an instance of TileManager
 *   
 *   Created by Sally Goldin, 3 October 2017
 */

public class TileManagerTester
{
    /** Main method */
    public static void main(String args[])
    {
        TileManager tm1 = new TileManager();
	tm1.initialize();
	TileManager tm2 = new TileManager();
	tm2.initialize();
	System.out.println("Instance one has " + tm1.getTilesRemaining() + " tiles");
	System.out.println("Instance two has " + tm2.getTilesRemaining() + " tiles");

    }	

}
import java.util.*;
/**
 *  TileComparator.java
 *
 *   Class to compare Tile objects.
 *
 *   Created by Sally Goldin, 2 October 2017
 *   Note this comparator imposes orderings that are not consistent with 
 *   equals. It considers only the score.
 */
public class TileComparator implements Comparator
{
	/**
	 * Fundamental method compares two tiles
	 * @param  tile1    First tile
	 * @param  tile2    Second tile
	 * @return -1 if tile1 score < tile2, 1 if tile1 > tile2, 0 if equal
	 */
	public int compare(Object tile1, Object tile2)
	{
		Tile t1 = (Tile) tile1;
		Tile t2 = (Tile) tile2;
		int score1 = t1.getTileValue();
		int score2 = t2.getTileValue();
		int seq1 = t1.getSequence();
		int seq2 = t2.getSequence();
		if (score1 < score2)
			return -1;
		else if (score1 > score2)
			return 1;
		else
			return (int) Math.signum(seq1 - seq2);
	}

}
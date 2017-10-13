/**
 * Board.java
 *
 * This class represents a board in the Scrabble game.
 * Currently this class is incomplete. All it can do is
 * return the board image.
 *
 * Created by Pongnut Jittipanyakul (Prues) ID: 58070503419
 *
 * 15 October 2017
 */

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Board
{
    private static final String boardFileName = "ScrabbleBoard.jpg";

    private static Image boardImage = null;

    /**
     * Read image file to Image object
     */
    public static void initialize()
    {
        try
        {
            boardImage = ImageIO.read(new File(boardFileName));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("Board initialized");
    }

    /**
     * Return the board image
     * @return board's image
     */
    public static Image getBoardImage()
    {
        return boardImage;
    }
}
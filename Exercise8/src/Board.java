import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Board
{
    public Image getBoardImage()
    {
        try
        {
            Image boardImage = ImageIO.read(new File("ScrabbleBoard.jpg"));
            System.out.println(boardImage);
            return boardImage;
        }
        catch (IOException e)
        {
            String workingDir = System.getProperty("user.dir");
            System.out.println("Current working directory : " + workingDir);
            e.printStackTrace();
        }
        return null;
    }

    public boolean addWord(Word word)
    {
        return true;
    }

    public boolean removeWord(Word word)
    {
        return true;
    }
}

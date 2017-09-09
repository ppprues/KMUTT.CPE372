import java.io.*;
import java.util.*;

/**
 * Test program to create and display squares.
 *
 * Created by Pongnut Jittipanyakul (Prues)
 * ID 58070503419
 *
 * 18 August 2017
 */
public class SquareTesterGraphics
{
    /**
     * Keep hold of the last square we created so we can move
     * it using the mouse.
     */
    protected static Square latestSquare = null;

    /**
     * Keep hold of all squares in ArrayList
     */
    protected static ArrayList<Square> allSquares = null;

    /**
     * FigureViewer for drawing canvas
     */
    protected static FigureViewer viewer = null;

    /**
     * Asks for one integer value, and returns it
     * as the function value.
     * @param prompt String to print, telling which coordinate
     * @return the value. Exits with error if user types in
     * something that can't be read as an integer
     */
    protected static int getOneInteger(String prompt)
    {
        int value = 0;
        String inputString;
        int readBytes = 0;
        byte buffer[] = new byte[200];
        System.out.println(prompt);
        try
        {
            readBytes = System.in.read(buffer, 0, 200);
        }
        catch (IOException ioe)
        {
            System.out.println("Input/output exception - Exiting");
            System.exit(1);
        }
        inputString = new String(buffer);
        try
        {
            int pos = inputString.indexOf("\n");
            if (pos > 0)
                inputString = inputString.substring(0, pos);
            value = Integer.parseInt(inputString);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("Bad number entered - Exiting");
            System.exit(1);
        }
        return value;
    }

    /**
     * Asks for a string, and returns it
     * as the function value.
     * @param prompt String to print, telling which coordinate
     * @return the string value entered, without a newline
     */
    protected static String getOneString(String prompt)
    {
        String inputString;
        int readBytes = 0;
        byte buffer[] = new byte[200];
        System.out.println(prompt);
        try
        {
            readBytes = System.in.read(buffer, 0, 200);
        }
        catch (IOException ioe)
        {
            System.out.println("Input/output exception - Exiting");
            System.exit(1);
        }
        inputString = new String(buffer);
        int pos = inputString.indexOf("\n");
        if (pos > 0)
            inputString = inputString.substring(0, pos);
        return inputString;
    }

    /* Main method first creates the viewer. Then it
     * asks for coordinates, creates new triangles, and displays them.
     * Then prints the perimeter and area as well.
     */
    public static void main(String arguments[])
    {
        boolean bContinue = true;
        allSquares = new ArrayList<Square>();
        viewer = new FigureViewer();
        viewer.pack();
        viewer.setVisible(true);

        while (bContinue)
        {
            int x, y;    /* coordinates of upper left point of square */
            int length; /* length of one side */
            x = getOneInteger("Enter x for upper left point (negative to exit): ");
            if (x < 0)
            {
                bContinue = false;
            }
            else
            {
                y = getOneInteger("Enter y for upper left point: ");
                length = getOneInteger("Length of each side of square: ");
                latestSquare = new Square(x, y, length);
                latestSquare.draw(false);
                double perim = latestSquare.calcPerimeter();
                System.out.println("Perimeter is " + perim);
                double area = latestSquare.calcArea();
                System.out.println("Area is " + area + "\n\n");
                System.out.println("-----------------------------");
                String move = getOneString("Want to move the square (Y/N)?");
                if (move.startsWith("Y"))
                {
                    x = getOneInteger("New X: ");
                    y = getOneInteger("New Y: ");
                    latestSquare.setX(x);
                    latestSquare.setY(y);
                    viewer.clear();
                    try
                    {
                        Thread.sleep(1000); // Wait for clear to complete
                    }
                    catch (InterruptedException ie)
                    {
                    }
                    latestSquare.draw(true);
                }
                System.out.println("-----------------------------\n");
            }
            FigureViewer.counter = 0;
            Square.drawAllSquares();
        }
    }
}
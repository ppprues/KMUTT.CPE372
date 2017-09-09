import java.awt.*;

/**
 * Simple class representing a square object.
 *
 * Created by Pongnut Jittipanyakul (Prues)
 * ID 58070503419
 *
 * Modified for Exercise 5
 * - Call calcBoundingBox() for the bounding box.
 *
 * 10 September 2017
 */

public class Square extends AbstractShape
{
   /* A square can be defined by an upper left corner point plus
    * the length of a side. We will also store the four Point object
    * in the superclass array 'vertices'
    */

    /**
     * keep the length of one side
     */
    protected int oneside = 0;

    /**
     * Constructor creates a new Square by setting the
     * values of the sets of vertex coordinates.
     *
     * @param x    Upper left corner X
     * @param y    Upper left corner Y
     * @param side Length of one side
     */
    public Square(int x, int y, int side)
    {
        super();
        oneside = side;
        anchor = new Point(x, y);
        vertices.add(new Point(x, y));
        vertices.add(new Point(x + side, y));  // upper right
        vertices.add(new Point(x + side, y + side));  // lower right
        vertices.add(new Point(x, y + side)); // lower left
        calcBoundingBox();
    }

    /* draw, move, and drawAll are handled by the superclass */

    /**
     * calculate the perimeter of this square
     *
     * @return perimeter value
     */
    public double calcPerimeter()
    {
        return (double) oneside * 4;
    }

    /**
     * calculate the area of this square
     *
     * @return area value
     */
    public double calcArea()
    {
        return (double) oneside * oneside;
    }

    /**
     * Override toString to give more informative information
     */
    public String toString()
    {
        String value = "Square " + shapeId + ": upper left at (" + anchor.x + "," + anchor.y + ") with sides " + oneside;
        return value;
    }
}
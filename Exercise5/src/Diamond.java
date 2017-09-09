import java.awt.*;

/**
 * Simple class representing a diamond object.
 *
 * Created by Pongnut Jittipanyakul (Prues)
 * ID 58070503419
 *
 * Modified for Exercise 5
 * - Call calcBoundingBox() for the bounding box.
 *
 * 10 September 2017
 */

public class Diamond extends AbstractShape
{
    /**
     * keep horizontal axis for perimeter calculations
     */
    private int horizontalAxis;

    /**
     * keep vertical axis for perimeter calculations
     */
    private int verticalAxis;

    /**
     * Constructor creates a new diamond by specifying an x,y
     * for the top point of the diamond, plus vertical and
     * horizontal axis lengths.
     *
     * @param x     X coord of first vertex
     * @param y     Y coord of first vertex
     * @param vAxis Vertical axis length
     * @param hAxis Horizontal axis length
     */
    public Diamond(int x, int y, int vAxis, int hAxis)
    {
        super();
        // make the axes be even numbers
        if ((vAxis % 2) > 0)
        {
            vAxis += 1;
        }
        if ((hAxis % 2) > 0)
        {
            hAxis += 1;
        }
        horizontalAxis = hAxis;
        verticalAxis = vAxis;
        anchor = new Point(x, y);
        vertices.add(anchor);
        vertices.add(new Point(x + hAxis / 2, y + vAxis / 2));
        vertices.add(new Point(x, y + vAxis));
        vertices.add(new Point(x - hAxis / 2, y + vAxis / 2));
        calcBoundingBox();
    }

    /**
     * Calculate the perimeter of this diamond.
     * This is four times the length of one side.
     *
     * @return perimeter value
     */
    public double calcPerimeter()
    {
        Point p1 = anchor;
        Point p2 = vertices.get(1);
        double len = Math.sqrt(Math.pow(p1.x - p2.x, 2) +
                Math.pow(p1.y - p2.y, 2));
        return len * 4;
    }

    /**
     * Calculate the area of this diamond
     * This is the product of the axes, divided by 2.
     *
     * @return area value
     */
    public double calcArea()
    {
        return (double) (horizontalAxis * verticalAxis) / 2;
    }

    /**
     * Override toString to give more informative information
     */
    public String toString()
    {
        String value = "Diamond " + shapeId + ": top point at (" + anchor.x + "," + anchor.y + ") with v axis " + verticalAxis + ", h axis " +
                horizontalAxis;
        return value;
    }
}
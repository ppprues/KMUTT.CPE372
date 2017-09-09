import java.awt.*;

/**
 * Simple class representing a circle object.
 *
 * Created by Pongnut Jittipanyakul (Prues)
 * ID 58070503419
 *
 * Modified for Exercise 5
 * - Add calcBoundingBox() specific for circle.
 * - Add draw(Graphics2D graphics, Color fillColor) specific for circle.
 *
 * 10 September 2017
 */

public class Circle extends AbstractShape
{
    /**
     * keep radius
     */
    private int radius;

    /**
     * Constructor creates a new circle by specifying an x,y
     * for the center of the circle, plus a radius value.
     *
     * @param x      X coord of center point
     * @param y      Y coord of center point
     * @param radius Radius length
     */
    public Circle(int x, int y, int radius)
    {
        super();
        anchor = new Point(x, y);
        vertices.add(anchor);
        this.radius = radius;
        calcBoundingBox(x, y, radius);
    }

    public void calcBoundingBox(int x, int y, int radius)
    {
        minX = x - radius;
        maxX = x + radius;
        minY = y - radius;
        maxY = y + radius;
    }

    /**
     * Calculate the perimeter of this circle
     * This is 2*PI*radius.
     *
     * @return perimeter value
     */
    public double calcPerimeter()
    {
        return (double) Math.PI * 2.0 * radius;
    }

    /**
     * Calculate the area of this circle
     * This is PI times the radius squared
     *
     * @return area value
     */
    public double calcArea()
    {
        return (double) Math.PI * Math.pow(radius, 2);
    }

    /**
     * Override draw to specify circle
     */
    public void draw(Graphics2D graphics)
    {
        graphics.setPaint(drawColor);
       /* drawOval takes UPPER LEFT plus width and height */
        int x = anchor.x - radius;
        int y = anchor.y - radius;
        graphics.drawOval(x, y, 2 * radius, 2 * radius);
       /* label it near the anchor point */
        int labelx = anchor.x + 5;
        int labely = anchor.y - 5;
        graphics.drawString(new String(" " + shapeId), labelx, labely);
    }

    /**
     * Override draw to specify circle and fill color
     */
    public void draw(Graphics2D graphics, Color fillColor)
    {
        draw(graphics);
        int x = anchor.x - radius;
        int y = anchor.y - radius;
        graphics.setPaint(fillColor);
        graphics.fillArc(x, y, 2 * radius, 2 * radius, 0, 360);
    }

    /**
     * Override toString to give more informative information
     */
    public String toString()
    {
        String value = "Circle " + shapeId + ": center at (" + anchor.x + "," + anchor.y + ") with radius " + radius;
        return value;
    }
}
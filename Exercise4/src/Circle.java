import java.awt.*;

/**
 * Simple class representing a circle object.
 *
 * Created by Pongnut Jittipanyakul (Prues)
 * ID 58070503419
 *
 * 3 September 2017
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
	 * @param y      Y coord of centerpoint
	 * @param radius Radius length
	 */
	public Circle(int x, int y, int radius)
	{
		super();
		anchor = new Point(x, y);
		vertices.add(anchor);
		this.radius = radius;
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
	 * Override the draw method because it won't work
	 * for a circle
	 *
	 * @param graphics Graphics context for drawing
	 */
	public void draw(Graphics2D graphics)
	{
		graphics.setPaint(drawColor);
		/* draw oval takes center plus width and height */
		graphics.drawOval(anchor.x, anchor.y, 2 * radius, 2 * radius);
		/* label it near the anchor point */
		int labelx = anchor.x + 5;
		int labely = anchor.y - 5;
		graphics.drawString(new String(" " + shapeId), labelx, labely);
	}

	/**
	 * Return all information of circle in String.
	 *
	 * @return description of circle
	 */
	public String toString()
	{
		return String.format("Circle at x=%d, y=%d with radius %d", anchor.x, anchor.y, radius);
	}
}
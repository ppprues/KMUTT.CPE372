import java.awt.*;

/**
 * Simple class representing a square figure. Designed
 * to show the idea of visibility, methods, class data, etc.
 *
 * Created by Pongnut Jittipanyakul (Prues)
 * ID 58070503419
 *
 * 27 August 2017
 */
public class Square extends AbstractShape
{
	/* A square can be defined by an upper left corner point plus
	 * the length of a side. However, for drawing purposes it is
     * more convenient to have four corner points in order.
     */

	/**
	 * figure number for a particular square
	 */
	private int figureNumber = -1;

	/**
	 * Constructor creates a new Square by setting the
	 * values of the sets of vertex coordinates.
	 * Also increments the counter and sets the figureNumber.
	 *
	 * @param x    Upper left corner X
	 * @param y    Upper left corner Y
	 * @param side Length of one side
	 */
	public Square(int x, int y, int side)
	{
		vertices.add(new Point(x, y));
		vertices.add(new Point(x + side, y));
		vertices.add(new Point(x + side, y + side));
		vertices.add(new Point(x, y + side));
		anchor = vertices.get(0);
		pointCount = 4;
		color = colors[counter % 5]; // set so will always be same color
		counter++;
		figureNumber = counter;
		allFigures.add(this);
	}

	/**
	 * Move the square somewhere else, determined by new anchor.
	 * The function re-initializes the other coordinates in the array
	 * to keep the figure square.
	 *
	 * @param newAnchor x,y coordinates of new reference/anchor point
	 */
	public void move(Point newAnchor)
	{
		anchor = newAnchor;
		int offsetX = 0;
		int offsetY = 0;
		offsetX = newAnchor.x - vertices.get(0).x;
		offsetY = newAnchor.y - vertices.get(0).y;

		for (int i = 0; i < 4; i++)
		{
			vertices.get(i).x += offsetX;
			vertices.get(i).y += offsetY;
		}
	}

	/**
	 * Draw the square. The passed graphics2D contains
	 * the information necessary for this.
	 *
	 * @param graphics Class with info to do the drawing
	 */
	public void draw(Graphics2D graphics)
	{
		graphics.setPaint(color);
		/* cycle around the outside of the square
	 	 * starting at the upper left. Get the current
	 	 * corner and the next corner, then draw
	 	 * a line between them.
	 	 */
		for (int i = 0; i < 4; i++)
		{
			int pt1 = i;
			int pt2 = ((i + 1) % 4);
			graphics.drawLine(vertices.get(pt1).x * 10, vertices.get(pt1).y * 10, vertices.get(pt2).x * 10, vertices.get(pt2).y * 10);
		}
		/* label in the center */
		graphics.setColor(Color.BLACK);
		graphics.drawString(new String(" " + figureNumber), (vertices.get(0).x * 10 + 10), (vertices.get(0).y * 10 - 10));
	}

	/**
	 * calculate the perimeter of this square
	 *
	 * @return perimeter value
	 */
	public double calcPerimeter()
	{
		return Math.abs(vertices.get(1).x - vertices.get(0).x) * 4;
	}

	/**
	 * calculate the area of this square
	 *
	 * @return area value
	 */
	public double calcArea()
	{
		return Math.pow((vertices.get(1).x - vertices.get(0).x), 2);
	}
}

import java.awt.*;

/**
 * Simple class representing a diamond figure. Designed
 * to show the idea of visibility, methods, class data, etc.
 *
 * Created by Pongnut Jittipanyakul (Prues)
 * ID 58070503419
 *
 * 27 August 2017
 */
public class Diamond extends AbstractShape
{
	/* A diamond can be defined by the top point plus
	 * the vertical axis length and the horizontal axis length.
     */

	/**
	 * vertical axis length for a diamond
	 */
	private double verticalLength = 0;

	/**
	 * horizontal axis length for a diamond
	 */
	private double horizontalLength = 0;

	/**
	 * figure number for a diamond
	 */
	private int figureNumber = -1;

	/**
	 * Constructor creates a new Triangle by setting the
	 * values of the sets of vertex coordinates.
	 * Also increments counter, sets drawing color adn stores in allFigures.
	 *
	 * @param x         X coord of top vertex
	 * @param y         Y coord of top vertex
	 * @param verLength vertical axis length
	 * @param horLength horizontal axis length
	 */
	public Diamond(int x, int y, int verLength, int horLength)
	{
		verticalLength = (double) verLength;
		horizontalLength = (double) horLength;
		if(verLength % 2 == 1)
		{
			verLength++;
		}
		if (horLength % 2 == 1)
		{
			horLength++;
		}
		vertices.add(new Point(x, y));
		vertices.add(new Point(x + horLength / 2, y + verLength / 2));
		vertices.add(new Point(x, y + verLength));
		vertices.add(new Point(x - horLength / 2, y + verLength / 2));
		anchor = vertices.get(0);
		pointCount = 4;
		color = colors[counter % 5]; // set so will always be same color
		counter++;
		figureNumber = counter;
		allFigures.add(this);
	}

	/**
	 * Calculate the length of one side of the diamond.
	 * This is private method used by calcPerimeter and calcArea.
	 *
	 * @return length of side, or -1 if 'which' is out of range.
	 */
	private double calcLength()
	{
		return Math.sqrt(Math.pow(vertices.get(0).x - vertices.get(1).x, 2) + Math.pow(vertices.get(0).y - vertices.get(1).y, 2));
	}

	/**
	 * Move the diamond somewhere else, determined by new anchor.
	 * The function re-initializes the other coordinates in the array
	 * to keep the figure diamond.
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
	 * Draw the diamond. The passed graphics2D contains
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
	 * calculate the perimeter of this diamond
	 *
	 * @return perimeter value
	 */
	public double calcPerimeter()
	{
		return 2 * Math.sqrt(Math.pow(verticalLength, 2) + Math.pow(horizontalLength, 2));
	}

	/**
	 * calculate the area of this diamond
	 *
	 * @return area value
	 */
	public double calcArea()
	{
		return verticalLength * horizontalLength / 2;
	}
}

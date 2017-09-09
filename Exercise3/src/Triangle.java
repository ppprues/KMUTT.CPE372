import java.awt.*;

/**
 * Simple class representing a triangle figure. Designed
 * to show the idea of visibility, methods, class data, etc.
 *
 * Created by Pongnut Jittipanyakul (Prues)
 * ID 58070503419
 *
 * 27 August 2017
 */
public class Triangle extends AbstractShape
{
	/* A triangle can be defined by three corner points in order.
	 */

	/**
	 * figure number for a triangle
	 */
	private int figureNumber = -1;

	/**
	 * Constructor creates a new Triangle by setting the
	 * values of the sets of vertex coordinates.
	 * Also increments counter, sets drawing color adn stores in allFigures.
	 *
	 * @param x1 X coord of first vertex
	 * @param y1 Y coord of first vertex
	 * @param x2 X coord of second vertex
	 * @param y2 Y coord of second vertex
	 * @param x3 X coord of third vertex
	 * @param y3 Y coord of third vertex
	 */
	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3)
	{
		vertices.add(new Point(x1, y1));
		vertices.add(new Point(x2, y2));
		vertices.add(new Point(x3, y3));
		anchor = vertices.get(0);
		pointCount = 3;
		color = colors[counter % 5]; // set so will always be same color
		counter++;
		figureNumber = counter;
		allFigures.add(this);
	}

	/**
	 * Calculate the length of one side of the triangle.
	 * This is private method used by calcPerimeter and calcArea.
	 *
	 * @param which 1,2 or 3, for which side
	 * @return length of side, or -1 if 'which' is out of range.
	 */
	private double calcLength(int which)
	{
		double len = -1;
		int index1 = -1;
		int index2 = -1;
		switch (which)
		{
			case 1:
				index1 = 0;
				index2 = 1;
				break;
			case 2:
				index1 = 1;
				index2 = 2;
				break;
			case 3:
				index1 = 0;
				index2 = 2;
				break;
			default:
				System.out.println("Invalid argument to calcLength!");
		}
		if (index1 >= 0)
		{
			len = Math.sqrt(Math.pow(vertices.get(index1).x - vertices.get(index2).x, 2) + Math.pow(vertices.get(index1).y - vertices.get(index2).y, 2));
		}
		return len;
	}

	/**
	 * Move the triangle somewhere else, determined by new anchor.
	 * The function re-initializes the other coordinates in the array
	 * to keep the figure triangle.
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

		for (int i = 0; i < 3; i++)
		{
			vertices.get(i).x += offsetX;
			vertices.get(i).y += offsetY;
		}
	}

	/**
	 * Draw the triangle. The passed graphics2D contains
	 * the information necessary for this.
	 *
	 * @param graphics Class with info to do the drawing
	 */
	public void draw(Graphics2D graphics)
	{
		graphics.setPaint(color);
		for (int i = 0; i < 3; i++)
		{
			int pt1 = i;
			int pt2 = (i + 1) % 3;
			graphics.drawLine(vertices.get(pt1).x * 10, vertices.get(pt1).y * 10, vertices.get(pt2).x * 10, vertices.get(pt2).y * 10);
		}
		/* label in the center */
		graphics.setColor(Color.BLACK);
		graphics.drawString(new String(" " + figureNumber), (vertices.get(2).x * 10 + vertices.get(0).x * 10) / 2, (vertices.get(2).y * 10 + vertices.get(0).y * 10) / 2);
	}

	/**
	 * calculate the perimeter of this triangle
	 *
	 * @return perimeter value
	 */
	public double calcPerimeter()
	{
		double perimeter = 0;
		for (int i = 1; i < 4; i++)
		{
			perimeter = perimeter + calcLength(i);
		}
		return perimeter;
	}

	/**
	 * calculate the area of this triangle
	 *
	 * @return area value
	 */
	public double calcArea()
	{
		/* area formula is
		|Ax(By - Cy) + Bx(Cy - Ay) + Cx(Ay - By)|/2
        */
		int numerator = vertices.get(0).x * (vertices.get(1).y - vertices.get(2).y);
		numerator += vertices.get(1).x * (vertices.get(2).y - vertices.get(0).y);
		numerator += vertices.get(2).x * (vertices.get(0).y - vertices.get(1).y);
		return (double) Math.abs(numerator) / 2;
	}
}

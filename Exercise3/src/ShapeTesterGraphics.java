import java.awt.*;
import java.io.*;

/**
 * Test program to create and display shapes.
 *
 * Created by Pongnut Jittipanyakul (Prues)
 * ID 58070503419
 *
 * 27 August 2017
 */
public class ShapeTesterGraphics
{
	/**
	 * Keep hold of the last square we created
	 */
	protected static AbstractShape latestFigure = null;

	/**
	 * Asks for one integer value, and returns it
	 * as the function value.
	 *
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
	   /* modify to work for both Windows and Linux */
			int pos = inputString.indexOf("\r");
			if (pos <= 0)
			{
				pos = inputString.indexOf("\n");
			}
			if (pos > 0)
			{
				inputString = inputString.substring(0, pos);
			}
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
	 *
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
	   /* modify to work for both Windows and Linux */
		int pos = inputString.indexOf("\r");
		if (pos <= 0)
		{
			pos = inputString.indexOf("\n");
		}
		if (pos > 0)
		{
			inputString = inputString.substring(0, pos);
		}
		return inputString;
	}

	/* Main method first creates the viewer. Then it
	 * asks for coordinates, creates new triangles, and displays them.
	 * Then prints the perimetr and area as well.
	 */
	public static void main(String arguments[])
	{
		boolean bContinue = true;
		int x1, x2, x3;
		int y1, y2, y3;
		int choice;
		int length;		/* length of one side */
		int verticalLength, horizontalLength;

		FigureViewer viewer = new FigureViewer();
		viewer.pack();
		viewer.setVisible(true);

		while (bContinue)
		{
			System.out.println("  1 - Create and draw triangle");
			System.out.println("  2 - Create and draw square");
			System.out.println("  3 - Create and draw diamond");
			System.out.println("  4 - Draw all shapes");
			System.out.println("  5 - Exit");
			choice = getOneInteger("Enter your choice: ");

			switch (choice)
			{
				case 1:
					x1 = getOneInteger("Enter x for point 1 of triangle: ");
					y1 = getOneInteger("Enter y for point 1 of triangle: ");
					x2 = getOneInteger("Enter x for point 2 of triangle: ");
					y2 = getOneInteger("Enter y for point 2 of triangle: ");
					x3 = getOneInteger("Enter x for point 3 of triangle: ");
					y3 = getOneInteger("Enter y for point 3 of triangle: ");
					latestFigure = new Triangle(x1, y1, x2, y2, x3, y3);
					break;
				case 2:
					x1 = getOneInteger("Enter x for upper left corner of square: ");
					y1 = getOneInteger("Enter y for upper left corner of square: ");
					length = getOneInteger("Length of each side of square: ");
					latestFigure = new Square(x1, y1, length);
					break;
				case 3:
					x1 = getOneInteger("Enter x for the top of diamond: ");
					y1 = getOneInteger("Enter y for the top of diamond: ");
					verticalLength = getOneInteger("Enter the vertical axis length of diamond: ");
					horizontalLength = getOneInteger("Enter the horizontal axis length of diamond: ");
					latestFigure = new Diamond(x1, y1, verticalLength, horizontalLength);
					break;
				case 4:
					AbstractShape.drawAll(viewer.getViewerGraphics());
					break;
				default:
					bContinue = false;
			}
			latestFigure.draw(viewer.getViewerGraphics());
			System.out.println("Perimeter: " + latestFigure.calcPerimeter() + " Area: " + latestFigure.calcArea() + "\n");
			if (bContinue && choice != 4)
			{
				String move = getOneString("Move it? ");
				if ((move.startsWith("Y")) || (move.startsWith("y")))
				{
					int x, y;	/* coordinates of new position */
					x = getOneInteger("Enter x coordinate of new position: ");
					y = getOneInteger("Enter y coordinate of new position: ");
					latestFigure.move(new Point(x, y));
					viewer.clear();
					try
					{
						Thread.sleep(1000); // Wait for clear to complete
					}
					catch (InterruptedException ie)
					{
					}
					latestFigure.draw(viewer.getViewerGraphics());
				}
			}
			System.out.println("\n");
		}
		System.out.println("About to draw all figures");
		AbstractShape.drawAll(viewer.getViewerGraphics());
		String dummy = getOneString("Press return to exit.");
		System.exit(0);
	}
}

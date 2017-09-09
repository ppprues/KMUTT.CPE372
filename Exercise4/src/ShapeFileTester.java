/**
 * Test program to read and calculate shapes.
 *
 * Created by Pongnut Jittipanyakul (Prues)
 * ID 58070503419
 *
 * 3 September 2017
 */
public class ShapeFileTester
{
	/**
	 * Main - exists just for testing
	 */
	public static void main(String args[])
	{
		if (args.length != 1)
		{
			System.out.println("You must specify a shape data file as a command line argument");
			System.exit(0);
		}

		ShapeReader pReader = new ShapeReader();
		boolean bOk = pReader.open(args[0]);

		if (bOk)
		{
			System.out.println("Trying to open file '" + args[0] + "‘.... success!");
			AbstractShape shape = null;
			while ((shape = pReader.readShape()) != null || pReader.getLineExist())
			{
				if (shape != null)
				{
					System.out.println("  readShape returned an object: " + shape.getClass());
					System.out.println("\t toString: " + shape.toString());
					System.out.println("\t perimeter: " + shape.calcPerimeter());
				}
			}
			pReader.close();
			System.out.println("\nClosing file and exiting");
		}
		else
		{
			System.out.println("Trying to open file '" + args[0] + "‘.... failure!");
			System.exit(1);
		}
	}
}
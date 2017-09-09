/**
 * Simple class for read and returns instances of
 * the AbstractShape class.
 *
 * Created by Pongnut Jittipanyakul (Prues)
 * ID 58070503419
 *
 * 3 September 2017
 */
public class ShapeReader extends TextFileReader
{
	/**
	 * keep the boolean that is line exist or not
	 */
	private boolean bLineExist = false;

	/**
	 * keep the line count of one file
	 */
	private int lineCount = 0;

	/**
	 * Return that there is line or not
	 *
	 * @return boolean that is line exist or not
	 */
	public boolean getLineExist()
	{
		return bLineExist;
	}

	/**
	 * Return line count
	 *
	 * @return line count
	 */
	public int getLineCount()
	{
		return lineCount;
	}

	/**
	 * Read the next line and parse it to get data for a shape
	 *
	 * @return AbstractShape object or null if an error occurred (including
	 * a line that doesn't match the expected format
	 */
	public AbstractShape readShape()
	{
		AbstractShape shape = null;
		String lineRead = getNextLine(); /* try to read the next line */
		lineCount++;
		if (lineRead != null)
		{
			bLineExist = true;
			String fields[] = lineRead.split(" ");
			try
			{
				/* good format */
				if (fields[0].equals("CIRCLE") && fields.length == 4)
				{
					shape = new Circle(Integer.parseInt(fields[1]), Integer.parseInt(fields[2]), Integer.parseInt(fields[3]));
				}
				else if (fields[0].equals("DIAMOND") && fields.length == 5)
				{
					shape = new Diamond(Integer.parseInt(fields[1]), Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), Integer.parseInt(fields[4]));
				}
				else if (fields[0].equals("SQUARE") && fields.length == 4)
				{
					shape = new Square(Integer.parseInt(fields[1]), Integer.parseInt(fields[2]), Integer.parseInt(fields[3]));
				}
				else if (fields[0].equals("TRIANGLE") && fields.length == 7)
				{
					shape = new Triangle(Integer.parseInt(fields[1]), Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), Integer.parseInt(fields[4]), Integer.parseInt(fields[5]), Integer.parseInt(fields[6]));
				}
				else if (!fields[0].equals("CIRCLE") && !fields[0].equals("DIAMOND") && !fields[0].equals("SQUARE") && !fields[0].equals("TRIANGLE"))
				{
					System.out.println("  Line " + lineCount + ": Invalid Shape Name");
				}
				else
				{
					System.out.println("  Line " + lineCount + ": Invalid Shape Format");
				}
			}
			catch (NumberFormatException nfe)
			{
				System.out.println("  Line " + lineCount + ": Invalid Number Format");
			} /* end if the right number of fields */
		} /* end if we got a line from the file */
		else
		{
			bLineExist = false;
		}
		return shape; /* will be null if any error occurred */
	}
}
import java.util.*;
/** 
 * Class that reads from a text file defining shapes and
 * creates instances of AbstractShape subclasses.
 * Possible lines in the file include:
 *   TRIANGLE x1 y1 x2 y2 x3 y3
 *   SQUARE x y side
 *   DIAMOND x y vaxis haxis
 *   CIRCLE x y radius
 * 
 *   Created by Sally Goldin, 29 August 2017 for Exercise 4
 */
public class ShapeReader extends TextFileReader
{


    /**
     * Try to convert a string to an integer.
     * @param stringToConvert    String that we think should be an integer
     * @return integer value or -999 if conversion error occurred.
     */
    private int convertToInt(String stringToConvert)
    {
	int value = -999; /* start by assuming bad value */
	try
	{
	   value = Integer.parseInt(stringToConvert);
	}
	catch (NumberFormatException nfe)
	{
	}
	return value;
	
    }

    /**
     * Determine if the fields are correct for a triangle,
     * and if so, create one.
     * @param fields  Array of strings parsed from file line.
     *                We have already checked the first field is 'TRIANGLE'
     * @return Triangle instance or null if specification has some error.
     */
    private AbstractShape createTriangle(String fields[])
    {
	AbstractShape shape = null;
	if (fields.length == 7)  /* commmand plus 3 x,y points */
	{
	    int[] x = new int[3];
	    int[] y = new int[3];
            for (int i=0; i < 3; i++)
	    {
		x[i] = convertToInt(fields[i*2+1]);
		y[i] = convertToInt(fields[i*2+2]);
		if ((x[i] < 0) || (y[i] < 0))
		{    
		    System.out.println("\t\tInvalid integer in triangle specification");
		    return shape; // null 
                }
	    }
	    shape = new Triangle(x[0],y[0],x[1],y[1],x[2],y[2]);
	}
	return shape;  // will be null if not 7 fields
    }


    /**
     * Determine if the fields are correct for a square,
     * and if so, create one.
     * @param fields  Array of strings parsed from file line.
     *                We have already checked the first field is 'SQUARE'
     * @return Square instance or null if specification has some error.
     */
    private AbstractShape createSquare(String fields[])
    {
	AbstractShape shape = null;
	if (fields.length == 4)  /* commmand plus x,y point and side */
	{
	    int[] val = new int[3];
            for (int i=0; i < 3; i++)
	    {
		val[i] = convertToInt(fields[i+1]);
		if (val[i] < 0)
		{    
		    System.out.println("\t\tInvalid integer in square specification");
		    return shape; // null 
                }
	    }
	    shape = new Square(val[0],val[1],val[2]);
	}
	return shape;  // will be null if not 4 fields
    }


    /**
     * Determine if the fields are correct for a diamond,
     * and if so, create one.
     * @param fields  Array of strings parsed from file line.
     *                We have already checked the first field is 'DIAMOND'
     * @return Diamond instance or null if specification has some error.
     */
    private AbstractShape createDiamond(String fields[])
    {
	AbstractShape shape = null;
	if (fields.length == 5)  /* commmand plus x,y point, vaxis, haxis */
	{
	    int[] val = new int[4];
            for (int i=0; i < 4; i++)
	    {
		val[i] = convertToInt(fields[i+1]);
		if (val[i] < 0)
		{    
		    System.out.println("\t\tInvalid integer in diamond specification");
		    return shape; // null 
                }
	    }
	    shape = new Diamond(val[0],val[1],val[2],val[3]);
	}
	return shape;  // will be null if not 5 fields
    }


    /**
     * Determine if the fields are correct for a circle,
     * and if so, create one.
     * @param fields  Array of strings parsed from file line.
     *                We have already checked the first field is 'CIRCLE'
     * @return Circle instance or null if specification has some error.
     */
    private AbstractShape createCircle(String fields[])
    {
	AbstractShape shape = null;
	if (fields.length == 4)  /* commmand plus x,y point and radius */
	{
	    int[] val = new int[3];
            for (int i=0; i < 3; i++)
	    {
		val[i] = convertToInt(fields[i+1]);
		if (val[i] < 0)
		{    
		    System.out.println("\t\tInvalid integer in circle specification");
		    return shape; // null 
                }
	    }
	    shape = new Circle(val[0],val[1],val[2]);
	}
	return shape;  // will be null if not 4 fields
    }


    /** 
     * check line from shape file to make sure it has correct shape 
     * type and correct arguments.
     * @param   line   String read from the file
     * @return  The shape specified by the command line, or null
     *          if the line contains any errors.
     */
    private AbstractShape parseCheckShapeCommand(String line)
    {
	AbstractShape newShape = null;
	String fields[] = line.split(" ");
	if (fields.length >= 4)  /* should be at least four fields */
	{
	    if (fields[0].equalsIgnoreCase("TRIANGLE"))
	    {
		newShape = createTriangle(fields);
	    }
	    else if (fields[0].equalsIgnoreCase("SQUARE"))
	    {
		newShape = createSquare(fields);
	    }
	    else if (fields[0].equalsIgnoreCase("DIAMOND"))
	    {
		newShape = createDiamond(fields);
	    }	
	    else if (fields[0].equalsIgnoreCase("CIRCLE"))
	    {
		newShape = createCircle(fields);
	    }	
	    else /* not a valid line */
	    {
		System.out.println("\t\tInvalid shape command");
	    }
	}
	else
	{
	    System.out.println("\t\tLine has too few fields");
	}
	return newShape;  /* could be null */
    }

    /**
     * Read the next line from the file.
     * Parse it and return the appropriate type of shape
     * based on the content of the line.
     * If an error is found, just skips to the next line,
     * until it gets to a good line or the end of the file.
     * @return specific subclass instance of AbstractShape, or null
     *         if the end of the file.
     */
    public AbstractShape readShape()
    {
	AbstractShape newShape = null;
	boolean bError = false;
	String line;
	do
	{
	    line = getNextLine();
	    if (line != null)
	    {
		newShape = parseCheckShapeCommand(line);
		if (newShape == null)
		    System.out.println("\t\tBad line: '" + line + "' ==> Skipping");
	    }
	} while ((newShape == null) && (line != null));
	return newShape;
    }

}

import java.util.ArrayList;
import java.awt.*;
/**
 *  AbstractShape class. Intended to serve as a superclass (generalization) for
 *  individual shapes like Triangle, Square, etc.
 *
 *  V2 - Created by Sally Goldin, 21 August 2017
 */
public abstract class AbstractShape
{
    /** Anchor point X,Y */
    protected Point anchor;   /* determines the "position" of a shape */
    /* Point is a class in package java.awt that has a public x and y member */

    /** list of points */
    protected ArrayList<Point> vertices = new ArrayList<Point>();

    /** how many points? */
    protected int pointCount;

    /** color */
    protected Color color;

    /** so we can count and label figures */ 
    protected static int counter = 0;
    
    /** collection of all squares */
    protected static ArrayList<AbstractShape> allFigures = new ArrayList<AbstractShape>();

    /** used to cycle through display colors */    
    protected static Color colors[] = {Color.RED, Color.GREEN, Color.BLUE,
			      Color.MAGENTA, Color.ORANGE};


    /**
     * Move the shape to a new location, specified by
     * the passed point.
     * @param  newAnchor    x,y coordinates of new reference/anchor point
     */
    public abstract void move(Point newAnchor);

    /**
     * Draw the shape.
     * @param  graphics    Graphics context for drawing
     */
    public abstract void draw(Graphics2D graphics);

    /**
     * Calculate and return the perimeter.
     * @return  Length of shape boundary
     */
    public abstract double calcPerimeter();

    /**
     * Calculate and return the area of the shape.
     * @return  area
     */
    public abstract double calcArea();

    /** static method to draw all the shapes of this category 
     * that have been created so far.
     * @param  graphics   Graphics context for drawing.
     */
    public static void drawAll(Graphics2D graphics)
    {
	for (int i=0; i < counter; i++)
	{
	    AbstractShape shape = allFigures.get(i);
	    shape.draw(graphics);
	}
    }


}
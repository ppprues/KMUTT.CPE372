import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 * FigureViewer
 *
 * Simple graphical application to display simple geometric figures
 *
 * Created by Pongnut Jittipanyakul (Prues)
 * ID 58070503419
 *
 * 18 August 2017
 */
public class FigureViewer extends JFrame implements ActionListener
{
    /* so we can count and label all figures */
    public static int counter = 0;

    /* UI objects */
    private DrawingCanvas drawCanvas = null;
    private JButton clearButton = null;
    private JButton exitButton = null;

    /* used to cycle through display colors */
    public static Color colors[] = {Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.ORANGE};

    /**
     * Constructor creates the User Interface.
     */
    public FigureViewer()
    {
        super("Figure Viewer");
        buildUI();
    }

    /**
     * Create the visible part of the user interface.
     */
    private void buildUI()
    {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        JPanel controlPanel = new JPanel(new FlowLayout());
        controlPanel.setBorder(new EtchedBorder());

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        controlPanel.add(clearButton);

        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        controlPanel.add(exitButton);
        mainPanel.add(controlPanel, BorderLayout.NORTH);

        drawCanvas = new DrawingCanvas(400, 400);
        drawCanvas.setBorder(new EtchedBorder());
        drawCanvas.setBackground(Color.white);
        mainPanel.add(drawCanvas, BorderLayout.CENTER);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
    }

    /**
     * This is the method required for the ActionListener
     * interface. It handles the necessary actions when
     * buttons are pressed.
     */
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if (source == exitButton)
        {
            System.exit(0);
        }
        else if (source == clearButton)
        {
            drawCanvas.clear();
            counter = 0;
        }
    }

    /**
     * Return Graphic2D instance
     * @return graphics Graphics2D
     */
    public Graphics2D getGraphics2D()
    {
        Graphics2D graphics = (Graphics2D) drawCanvas.getGraphics();
        return graphics;
    }

    /**
     * Clear the drawing panel.
     */
    public void clear()
    {
        drawCanvas.clear();
    }
}
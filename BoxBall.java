import java.awt.*;
import java.awt.geom.*;
import java.util.Random;
/**
 * Write a description of class BoxBall here.
 *
 * @author Liam Marquis
 * @version 2019.3.25
 */
public class BoxBall
{
    // instance variables
    Random rng = new Random();
    private Canvas canvas;
    private Ellipse2D.Double circle;
    private Color ballColor;
    private int xPosition = rng.nextInt(40) + 1;
    private int yPosition = rng.nextInt(60) + 1;
    private int xSpeed = rng.nextInt(20) + 1;
    private int ySpeed = rng.nextInt(20) + 1;
    private int ballDiameter;
    private final int northBoundary;
    private final int southBoundary;
    private final int westBoundary;
    private final int eastBoundary;

    /**
     * Constructor for objects of class BoxBall
     *
     * @param drawingCanvas  the canvas to draw this ball on
     * @param northBoundary  the position of the north boundary (where the wall will bounce)
     * @param southBoundary  the position of the south boundary (where the wall will bounce)
     * @param westBoundary  the position of the west boundary (where the wall will bounce)
     * @param eastBoundary  the position of the east boundary (where the wall will bounce)
     */
    public BoxBall(Canvas drawingCanvas, int northBoundary,int southBoundary,int westBoundary,int eastBoundary) {
        Random rng = new Random();
        canvas = drawingCanvas;
        this.northBoundary = northBoundary;
        this.southBoundary = southBoundary;
        this.westBoundary = westBoundary;
        this.eastBoundary = eastBoundary;
        ballDiameter = rng.nextInt(25) + 25;
        xPosition = (rng.nextInt(401) + 50)-ballDiameter;
        yPosition = (rng.nextInt(501) + 50)-ballDiameter;
        ballColor = new Color(rng.nextInt(256),rng.nextInt(256),rng.nextInt(256));
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(ballColor);
        canvas.fillCircle(xPosition, yPosition, ballDiameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, ballDiameter);
    }   

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void move() {
        erase();
        
        xPosition += xSpeed;
        yPosition += ySpeed;
        
        //set north boundary
        //if (yPosition - ySpeed <= -20) {
        if (yPosition - ballDiameter <= -50) {
            yPosition = -50 + ballDiameter;
            xPosition += xSpeed;
            ySpeed = ySpeed *-1;
        
        }
        
        //set south boundary
        if (yPosition + ballDiameter >= 500) {
            yPosition = 500 - ballDiameter;
            xPosition += xSpeed;
            ySpeed = ySpeed *-1;
        
        }
        
        //set west boundary
        if (xPosition - ballDiameter <= -50) {
            xPosition = -50 + ballDiameter;
            yPosition += ySpeed;
            xSpeed = xSpeed *-1;
        
        }
        
        //set east boundary
        if (xPosition + ballDiameter > 600) {
            xPosition = 600 - ballDiameter;
            yPosition += ySpeed;
            xSpeed = xSpeed *-1;
        
        }
        
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
    
    /**
     * return the vertical position of this ball
     */
    public void initalSpeed() {
        Random rng = new Random();
        xSpeed = rng.nextInt(30) + 1;
        ySpeed = rng.nextInt(30) + 1;
    }
}

import java.awt.Color;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Liam Marquis
 * @version 2019.03.25
 *
 * @author Bill Crosbie
 * @version 2015-March-BB
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
    
    public void boxBounce() {
        int northBoundary = 50,westBoundary = 50;
        int southBoundary = 450, eastBoundary = 550;
        BoxBall bb = new BoxBall(myCanvas,northBoundary,southBoundary,westBoundary,eastBoundary);
        
        
        //create boundaries
        myCanvas.drawLine(50, southBoundary, 550, southBoundary);
        myCanvas.drawLine(50, northBoundary, 550, northBoundary);
        myCanvas.drawLine(eastBoundary, 50, eastBoundary, 450);
        myCanvas.drawLine(westBoundary, 50, westBoundary, 450);
        
        
        while(true){
            bb.move();
            myCanvas.wait(50);
        }
        
        
    }
    
    
}

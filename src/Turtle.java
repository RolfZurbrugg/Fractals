import java.awt.*;

/**
 * @author ps
 * Simple Turtle class which allows the turtle to move in a container.
 * The upper-left corner has always the coordinates (0,0) while the
 * lower-right corner has coordinates (1,1);
 *  
 */
class Turtle {
    private double x;
    private double y;
    private int height;
    private int width;
    private double scaleX;
    private double scaleY;
    private double alpha;
    private Container c;
    private Graphics g;

    /**
     * Creates a Turtle object and places it into the container
     * All coordinates should be in the range 0..1
     * The turtle looks into the positive x direction
     * @param ct the Container where the turtle moves
     * @param x the starting x coordinate (0..1) of the turtle 
     * @param y the starting x coordinate (0..1) of the turtle
     */
    public Turtle(Container ct, double x, double y) {
        c = ct;
        height = c.getHeight();
        width = c.getWidth();
        scaleX = width;
        scaleY = height;
        g = c.getGraphics();
        g.setColor(Color.black);
        this.x = x*scaleX;
        this.y = y*scaleY;
        alpha = 0;
    }

    /**
     * Moves the turtle directly to a given point without changing the
     * orientation.
     * @param x coordinate of the target point
     * @param y coordinate of the target point
     * @param penDown turtle will draw a line while moving if true
     */
    public void goTo(double x, double y, boolean penDown){
    	if (penDown){
    		g.drawLine((int)this.x, (int)this.y, (int)(x*scaleX), (int)(y*scaleY));
    	}
		this.x = x*scaleX;
		this.y = y*scaleY;
    }
    
    /**
     * Turtle moves the distance 'dist' into its 
     * current direction and draws a line while moving
     * @param dist the distance to move
     */
    public void move (double dist) {
        double aa = alpha * Math.PI / 180;
        double dx = dist * Math.cos(aa)*scaleX;
        double dy = dist * Math.sin(aa)*scaleY;
        g.drawLine((int)x, (int) y, (int) (x+dx), (int) (y+dy));
        x+=dx;
        y+=dy;
    }

    /**
     * Turtle moves the distance 'dist' into its 
     * current direction.
     * Wether a line is drawn is specified by the second parameter
     * 
     * @param dist  the distance to move
     * @param penDown will draw a line if true else no line is drawn
     */
    public void move (double dist, boolean penDown) {
    	if ( ! penDown){
    		double aa = alpha * Math.PI / 180;
    		double dx = dist * Math.cos(aa)*scaleX;
    		double dy = dist * Math.sin(aa)*scaleY;
    		x+=dx;
    		y+=dy;
    	}
    	else move(dist);
    }

    /**
     * Turtle moves the distance 'dist' into its 
     * current negative direction and draws a line while moving. 
     * The turtle keeps its orientation (in foreward direction) 
     * @param dist the distance to move
     */
    public void moveBackwards(double dist) {
        double aa = alpha * Math.PI / 180;
        double dx = -dist * Math.cos(aa)*scaleX;
        double dy = -dist * Math.sin(aa)*scaleY;
        g.drawLine((int)x, (int) y, (int) (x+dx), (int) (y+dy));
        x+=dx;
        y+=dy;
    }

    /**
     * Turtle moves the distance 'dist' into its 
     * current negative direction and draws a line while moving. 
     * The turtle keeps its orientation (in foreward direction). 
     * Wether a line is drawn is specified by the second parameter
     * @param dist the distance to move
     * @param penDown will draw a line if true else no line is drawn 
     */
    public void moveBackwards(double dist, boolean penDown) {
    	if (penDown){
    		double aa = alpha * Math.PI / 180;
    		double dx = -dist * Math.cos(aa)*scaleX;
    		double dy = -dist * Math.sin(aa)*scaleY;
    		x+=dx;
    		y+=dy;
    	}
    	else moveBackwards(dist);
    }
    
    /**
     * Thre turtle turns clockwise.
     * (counter-clockwise if negative angle)  
     * @param angle rotation angle (0..360)
     */
    public void turn(double angle) {
        alpha = alpha - angle;
    }
}

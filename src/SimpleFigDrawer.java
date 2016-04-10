import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;

/**
 * Simple class which can draw triangles and rectangles into a container.
 * The upper-left corner has always the coordinates (0,0) while the
 * lower-right corner has coordinates (1,1).
 * 
 * @author ps
 *
 */
public class SimpleFigDrawer {
    int height;
    int width;
    double scaleX;
    double scaleY;
    double alpha;
    Container c;
    Graphics g;

    /**
     * Creates a SimpleFigDrawer object capable to
     * draw (arbitrary) oriented triangles and (x,y)-oriented rectangles to
     * the container 'ct'
     * @param ct container where to draw
     */
    SimpleFigDrawer(Container ct) {
        c = ct;
        height = c.getHeight();
        width = c.getWidth();
        scaleX = width;
        scaleY = height;
        g = c.getGraphics();
        g.setColor(Color.black);
        alpha = 0;
    }
    
    /**
     * Draws a triangle
     * 
     * @param x1 first points x coordinate
     * @param y1 first points y coordinate
     * @param x2 second points x coordinate
     * @param y2 second points y coordinate
     * @param x3 third points x coordinate
     * @param y3 third points y coordinate
     * @param filled The triangle will be filled if true
     */
    public void triangle(double x1, double y1, double x2, double y2, double x3, double y3, boolean filled){
    	int [] xPoints;
    	int [] yPoints; 
    	xPoints = new int []{(int)(x1*scaleX),(int)(x2*scaleX),(int)(x3*scaleX)};
    	yPoints = new int []{(int)(y1*scaleY),(int)(y2*scaleY),(int)(y3*scaleY)};
    	if (filled){g.fillPolygon(xPoints, yPoints, 3);}
    	else g.drawPolygon(xPoints, yPoints, 3);
    }
    
    /**
     * @param xUL x coordinate of the upper left corner
     * @param yUL y coordinate of the upper left corner
     * @param xLR x coordinate of the lower right corner
     * @param yLR y coordinate of the lower right corner
     * @param filled rectangle will be filled if true
     */
    public void rectangle(double xUL,double yUL, double xLR, double yLR, boolean filled){
    	int [] xPoints;
    	int [] yPoints; 
    	xPoints = new int []{(int)(xUL*scaleX),(int)(xUL*scaleX),(int)(xLR*scaleX),(int)(xLR*scaleX)};
    	yPoints = new int []{(int)(yUL*scaleY),(int)(yLR*scaleY),(int)(yLR*scaleY),(int)(yUL*scaleY)};
    	if (filled){g.fillPolygon(xPoints, yPoints, 4);}
    	else g.drawPolygon(xPoints, yPoints, 4);
    }   
}

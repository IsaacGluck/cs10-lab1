import java.awt.*;

/**
 * Ellipse.java
 * Class for an ellipse.
 * 
 * @author Tom Cormen
 * @author YOU
 * @see Shape
 */
public class Ellipse extends Shape {
	int x, y, width, height;
	
	/**
	 *  Constructor for Ellipse. 
	 * @param x the x coordinate of the upper left corner of bounding box
	 * @param y the y coordinate of the upper left corner of bounding box
	 * @param width the width of the  of bounding box
	 * @param height the height of the  of bounding box
	 * @param rectColor the color of the Ellipse
	 */
	public Ellipse(int x, int y, int width, int height, Color eColor) {
		super(eColor);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	// Helper method that returns whether Point p is in an Ellipse with the given
	// top left corner and size.
	private static boolean pointInEllipse(Point p, int left, int top, int width,
			int height) {
		double a = width / 2.0;			// half of the width
		double b = height / 2.0;		// half of the height
		double centerx = left + a;	// x-coord of the center
		double centery = top + b;		// y-coord of the center
		double x = p.x - centerx;		// horizontal distance between p and center
		double y = p.y - centery;		// vertical distance between p and center

		// Now we just apply the standard geometry formula.
		// (See CRC, 29th edition, p. 178.)
		return Math.pow(x / a, 2) + Math.pow(y / b, 2) <= 1;
	}
	
	
	/**
	 * Have the Shape draw itself.
	 *
	 * @param page the page you wish to draw on
	 */
	public void drawShape(Graphics page){
		page.fillOval(x, y, width, height);
	}

	/**
	 * Return true if the Shape contains Point p, false otherwise.
	 * 
	 * @param p point tested for containment
	 */
	public boolean containsPoint(Point p){
		return pointInEllipse(p, x, y, width, height);
	}

	/**
	 * Have the Shape move itself.
	 * 
	 * @param deltaX new x coordinate
	 * @param deltaY new y coordinate
	 */
	public void move(int deltaX, int deltaY){
		x += deltaX;
		y += deltaY;
	}

	/**
	 * Return the Shape's center.
	 * @return the center of the Shape
	 */
	public Point getCenter(){
		int cX, cY;
		cX = (x + width) / 2;
		cY = (y + height) / 2;
		return new Point(cX, cY);
	}
}

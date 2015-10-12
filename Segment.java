import java.awt.*;

/**
 * Segment.java
 * Class for a line segment.
 * 
 * Written by THC for CS 10 Lab Assignment 1.
 *
 * @author Tom Cormen
 * @author Maxwell Coleman, Isaac Gluck
 * collaborated with Anish Chadalavada
 * @see Shape
 */
public class Segment extends Shape {
	private Point point1, point2;

	public Segment(int x1, int y1, int x2, int y2, Color color){
		super(color);
		point1 = new Point(x1, y1);
		point2 = new Point(x2, y2);
	}

	/**
	 * Return true if the Shape contains Point p, false otherwise.
	 * 
	 * @param p point tested for containment
	 */
	public boolean containsPoint(Point p){
		int left, right, top, bottom, tolerance;
		tolerance = 3;
		if (point1.x < point2.x){
			left = point1.x;
			right = point2.x;
		} else {
			left = point2.x;
			right = point1.x;
		}
		if (point1.y < point2.y){
			top = point1.y;
			bottom = point2.y;
		} else {
			top = point2.y;
			bottom = point1.y;
		}

		return almostContainsPoint(p, left, top, right, bottom, tolerance) && 
				( distanceToPoint(p, point1.x, point1.y, point2.x, point2.y) < tolerance);
	}

	// Helper method that returns true if Point p is within a tolerance of a
	// given bounding box. Here, the bounding box is given by the coordinates of
	// its left, top, right, and bottom.
	private static boolean almostContainsPoint(Point p, int left, int top, int right, int bottom, double tolerance) {
		return p.x >= left - tolerance && p.y >= top - tolerance
				&& p.x <= right + tolerance && p.y <= bottom + tolerance;
	}

	// Helper method that returns the distance from Point p to the line
	// containing a line segment whose endpoints are given.
	private static double distanceToPoint(Point p, int x1, int y1, int x2,
			int y2) {
		if (x1 == x2) // vertical segment?
			return (double) (Math.abs(p.x - x1)); // yes, use horizontal distance
		else if (y1 == y2) // horizontal segment?
			return (double) (Math.abs(p.y - y1)); // yes, use vertical distance
		else {
			// Here, we know that the segment is neither vertical nor
			// horizontal.
			// Compute m, the slope of the line containing the segment.
			double m = ((double) (y1 - y2)) / ((double) (x1 - x2));

			// Compute mperp, the slope of the line perpendicular to the
			// segment.
			double mperp = -1.0 / m;

			// Compute the (x, y) intersection of the line containing the
			// segment and the line that is perpendicular to the segment and that
			// contains Point p.
			double x = (((double) y1) - ((double) p.y) - (m * x1) + (mperp * p.x))
					/ (mperp - m);
			double y = m * (x - x1) + y1;

			// Return the distance between Point p and (x, y).
			return Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2));
		}
	}


	/**
	 * Have the Shape draw itself.
	 *
	 * @param page the page you wish to draw on
	 */
	public void drawShape(Graphics page){
		page.drawLine(point1.x, point1.y, point2.x, point2.y);
	}


	/**
	 * Have the Shape move itself.
	 * 
	 * @param deltaX new x coordinate
	 * @param deltaY new y coordinate
	 */
	public void move(int deltaX, int deltaY){
		point1.x += deltaX;
		point2.x += deltaX;
		point1.y += deltaY;
		point2.y += deltaY;
	}


	/**
	 * Return the Shape's center.
	 * @return the center of the Shape
	 */
	public Point getCenter(){
		int cX = (point1.x + point2.x) / 2;
		int cY = (point1.y + point2.y) / 2;
		return new Point(cX, cY);
	} 
}
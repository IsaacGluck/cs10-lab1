import java.awt.*;

/**
 * Rect.java
 * Class for a rectangle.
 * 
 * Written by THC for CS 10 Lab Assignment 1.
 *
 * @author Tom Cormen
 * @author Maxwell Coleman, Isaac Gluck
 * collaborated with Anish Chadalavada
 * @see Shape
 */
public class Rect extends Shape {
	private int x, y, width, height;
	private Color rectColor;


	/**
	 *  Constructor for Rect. 
	 * @param x the x coordinate of the upper left corner
	 * @param y the y coordinate of the upper left corner
	 * @param width the width of the rectangle
	 * @param height the height of the rectangle
	 * @param rectColor the color of the rectangle
	 */
	public Rect(int x, int y, int width, int height, Color rectColor) {
		super(rectColor);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}

	/**
	 * Have the Shape draw itself.
	 *
	 * @param page the page you wish to draw on
	 */
	public void drawShape(Graphics page){
		page.setColor(rectColor);
		page.fillRect(x, y, width, height);
	}

	/**
	 * Return true if the Shape contains Point p, false otherwise.
	 * 
	 * @param p point tested for containment
	 */
	public boolean containsPoint(Point p){
		boolean inX, inY;
		if (width > 0)
			inX = (p.x > this.x) && (p.x < this.x + width);
		else
			inX = (p.x < this.x) && (p.x > this.x + width);

		if (height > 0)
			inY = (p.y > this.y) && (p.y < this.y + height);
		else
			inY = (p.y < this.y) && (p.y > this.y + height);

		return inX && inY;
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
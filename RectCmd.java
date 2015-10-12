import java.awt.*;

/**
 * RectCmd class
 * 
 * @author Maxwell Coleman, Isaac Gluck
 * collaborated with Anish Chadalavada
 * 
 * This class allows rectangles to be drawn
 * in our GUI when the corresponding rectangle
 * button is pushed.
 */

public class RectCmd extends Command {
	private Point originalPoint; // The original point from which to draw the rectangle
	private int dWidth, dHeight; // Width and height of rectangle
	private Rect rect = null; // Start with the rectangle as null untill they drag it out
		
	public void executePress(Point p, Drawing dwg){
		originalPoint = p; // set the original point where they press their mouse
	}
	
	
	public void executeDrag(Point p, Drawing dwg){
		if (rect != null)
			dwg.remove(rect); // before adding the updated rectangle, remove the old one
		
		dWidth = Math.abs(p.x - originalPoint.x);
		dHeight = Math.abs(p.y - originalPoint.y);

		rect = new Rect(Math.min(originalPoint.x, p.x), Math.min(originalPoint.y, p.y),
				dWidth, dHeight, dwg.getColor()); // Choose the correct top left corner to draw from
		
		dwg.add(rect);
	}
	
	public void executeRelease(Point P, Drawing dwg){
		rect = null; // After they release, set the default back to null so the Shape isn't deleted when the function is called again
	}

}
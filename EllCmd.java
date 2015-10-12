import java.awt.*;

/**
 * DelCommand class
 * 
 * @author Maxwell Coleman, Isaac Gluck
 * collaborated with Anish Chadalavada
 * 
 * This class allows us to draw ellipses on
 * our GUI when the ellipse buton is pressed.
 */

public class EllCmd extends Command {
	private Point originalPoint; // The original point from which to draw the rectangle
	private int dWidth, dHeight; // Width and height of rectangle
	private Ellipse ell = null; // Start with the ellipse as null until they drag it out
		
	public void executePress(Point p, Drawing dwg){
		originalPoint = p; // set the original point where they press their mouse
	}
	public void executeDrag(Point p, Drawing dwg){
		if (ell != null)
			dwg.remove(ell); // before adding the updated ellipse, remove the old one
		
		dWidth = Math.abs(p.x - originalPoint.x);
		dHeight = Math.abs(p.y - originalPoint.y);
	
		ell = new Ellipse(Math.min(originalPoint.x, p.x), Math.min(originalPoint.y, p.y),
				dWidth, dHeight, dwg.getColor()); // Choose the correct top left corner to draw from
		
		dwg.add(ell);
	}
	
	public void executeRelease(Point P, Drawing dwg){
		ell = null; // After they release, set the default back to null so the Shape isn't deleted when the function is called again
	}
}
import java.awt.*;

/**
 * SegCmd class
 * 
 * @author Maxwell Coleman, Isaac Gluck
 * collaborated with Anish Chadalavada
 * 
 * this class allows us to draw line segments
 * in our GUI when the seg button is pushed.
 */

public class SegCmd extends Command {
	private Point point1, point2; // The original point where they click, and they point they are dragging to
	private Segment seg = null;

	public void executeClick(Point p, Drawing dwg){}

	public void executePress(Point p, Drawing dwg){
		point1 = p; // set the first point to where they first press their mouse
	}
	public void executeDrag(Point p, Drawing dwg){
		point2 = p; // set the second point to where they are dragging their mouse
		
		if (seg != null)
			dwg.remove(seg); // while they are still dragging the mouse, remove the old line to make room
		
		seg = new Segment(point1.x, point1.y, point2.x, point2.y, dwg.getColor());
		dwg.add(seg); // add the new line to the Shapes list
	}
	
	public void executeRelease(Point P, Drawing dwg){
		seg = null; // After they release, set the default back to null so the Shape isn't deleted when the function is called again
	}


}
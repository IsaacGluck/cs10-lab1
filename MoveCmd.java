import java.awt.*;

/**
 * MoveCmd class
 * 
 * @author Maxwell Coleman, Isaac Gluck
 * collaborated with Anish Chadalavada
 * 
 * The MoveCmd class allows us to click and hold on shapes
 * and drag them around in our GUI page.
 * 
 */

public class MoveCmd extends Command{
	private Point prev;
	private Shape s;

	public void executePress(Point p, Drawing dwg){
		s = dwg.getFrontmostContainer(p);//get top level shape

		if (s != null){//set previous point equal to parameter p
			prev = p;
		}
	}

	public void executeDrag(Point p, Drawing dwg){
		if (s != null){

			int deltaX = (p.x - prev.x);//calculating horizontal displacement
			int deltaY = (p.y - prev.y);//calculating vertical displacement
			s.move(deltaX,  deltaY);//move s by corresponding amounts
			prev = p;//reset p
		}
	}			

}

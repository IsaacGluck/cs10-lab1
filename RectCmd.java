import java.awt.*;

public class RectCmd extends Command {
	private int initialX, initialY, dWidth, dHeight;
	private Rect rect = null;
	

	public void executeClick(Point p, Drawing dwg){}
	
	public void executePress(Point p, Drawing dwg){
		initialX = p.x;
		initialY = p.y;
	}
	public void executeDrag(Point p, Drawing dwg){
		if (rect != null)
			dwg.remove(rect);
		
		if (p.x > initialX)
			dWidth = initialX - p.x;
		else
			dWidth = p.x - initialX;
		
		if (p.y > initialY)
			dHeight = initialY - p.y;
		else
			dHeight = p.y - initialY;
		
		rect = new Rect(initialX, initialY, dWidth, dHeight, dwg.getColor());
		
		dwg.add(rect);
	}
	
	public void executeRelease(Point P, Drawing dwg){
		rect = null;
	}

}

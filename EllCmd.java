import java.awt.*;

public class EllCmd extends Command {
	private int initialX, initialY, dWidth, dHeight;
	private Ellipse ell = null;
	
	
	public void executeClick(Point p, Drawing dwg){}

	public void executePress(Point p, Drawing dwg){
		initialX = p.x;
		initialY = p.y;
	}
	public void executeDrag(Point p, Drawing dwg){
		if (ell != null)
			dwg.remove(ell);
		
		if (p.x > initialX)
			dWidth = initialX - p.x;
		else
			dWidth = p.x - initialX;
		
		if (p.y > initialY)
			dHeight = initialY - p.y;
		else
			dHeight = p.y - initialY;
		
		ell = new Ellipse(initialX, initialY, dWidth, dHeight, dwg.getColor());
		
		dwg.add(ell);
	}
	
	public void executeRelease(Point P, Drawing dwg){
		ell = null;
	}
}

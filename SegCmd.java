import java.awt.*;

public class SegCmd extends Command {
	private Point point1, point2;
	private Segment seg = null;

	public void executeClick(Point p, Drawing dwg){}

	public void executePress(Point p, Drawing dwg){
		point1 = p;
	}
	public void executeDrag(Point p, Drawing dwg){
		point2 = p;
		
		if (seg != null)
			dwg.remove(seg);
		
		seg = new Segment(point1.x, point1.y, point2.x, point2.y, dwg.getColor());
		dwg.add(seg);
	}
	
	public void executeRelease(Point P, Drawing dwg){
		seg = null;
	}


}

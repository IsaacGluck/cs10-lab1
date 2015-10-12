import java.awt.*;

/**
 * ColorCmd class
 * 
 * @author Maxwell Coleman, Isaac Gluck
 * collaborated with Anish Chadalavada
 * 
 * this class allows the different color buttons to be accessed
 * in order to draw rectangles, ellipses, and lines in colors
 */

public class ColorCmd extends Command {
	
	public void executeClick(Point p, Drawing dwg) {
		Shape s = dwg.getFrontmostContainer(p);//Get top level shape
		if(s != null){
			s.setColor(dwg.getColor());//if top shape is not null, change the color
		}
		
	}
}	
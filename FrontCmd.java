import java.awt.*;


/**
 * FrontCmd.java
 * Command class to perform an back command.
 * 
 * @author Maxwell Coleman, Isaac Gluck
 * collaborated with Anish Chadalavada
 * 
 *  * @see Command
 */
public class FrontCmd extends Command {
	  public void executeClick(Point p, Drawing dwg){
		  Shape s = dwg.getFrontmostContainer(p); // get shape clicked on
		  if (s!=null)
			  dwg.moveToFront(s); // move the clicked on shape to the front of the list
	  }

}

import java.awt.Point;


/**
 * BackCmd.java
 * Command class to perform an back command.
 * 
 *  * @see Command
 *  @author Maxwell Coleman, Isaac Gluck
 *  collaborated with Anish Chadalavada
 */
public class BackCmd extends Command {
	  public void executeClick(Point p, Drawing dwg){
		  Shape s = dwg.getFrontmostContainer(p); // get clicked on shape
		  if (s!=null)
			  dwg.moveToBack(s); // move the shape to the back of the list
	  }

}

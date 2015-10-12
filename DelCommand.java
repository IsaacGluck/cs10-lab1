import java.awt.*;

/**
 * DelCommand class
 * 
 * @author Maxwell Coleman, Isaac Gluck
 * collaborated with Anish Chadalavada
 * 
 * This class allows us to use the delete button.
 * When the delete button is pressed in our GUI,
 * if we click on any given shape, it will be removed
 * from the page.
 */

public class DelCommand extends Command {

	public void executeClick(Point p, Drawing dwg) { 
		Shape toDel = dwg.getFrontmostContainer(p);//get top level shape

		if (toDel != null)
			dwg.remove(toDel);//if shape is not null, remove
	}

}
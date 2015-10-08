import java.awt.*;

public class DelCommand extends Command {

	public void executeClick(Point p, Drawing dwg) { 
		Shape toDel = dwg.getFrontmostContainer(p);

		if (toDel != null)
			dwg.remove(toDel);
	}

}

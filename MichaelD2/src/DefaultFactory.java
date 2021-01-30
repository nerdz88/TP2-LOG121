import javax.swing.AbstractButton;
import javax.swing.JToggleButton;

public class DefaultFactory implements Factory {

	@Override
	public AbstractButton[][] createButtons() {
		AbstractButton grid[][] = new AbstractButton[NUM_ROW][NUM_COLUMN];
		for (int i = 0; i < NUM_ROW; i++) {
			for (int j = 0; j < NUM_COLUMN; j++) {
				grid[i][j] = new JToggleButton();
			}	
		}
		return grid;
	}
}

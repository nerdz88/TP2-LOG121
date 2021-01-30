import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Dialog extends JDialog {
	
	private static final long serialVersionUID = 1L;

	public Dialog(Frame owner, Factory factory) {
		super(owner, "Dialogue");
		
		/*
		 * Set dialog main panel with a grid layout.
		 */
		LayoutManager layoutManager = new GridLayout(Factory.NUM_ROW, Factory.NUM_COLUMN);
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(layoutManager);
		add(panel);
		
		/*
		 * Fill the dialog panel with a grid of JComponents
		 */
		
		JComponent[][] grid = factory.createButtons();
		for (int i = 0; i < Factory.NUM_ROW; i++) {
			for (int j = 0; j < Factory.NUM_COLUMN; j++) {
				panel.add(grid[i][j]);
			}	
		}

		/*
		 * Adjust screen size and display dialog
		 */
		setBounds(100, 100, 534, 300);
		setVisible(true);
	}
}

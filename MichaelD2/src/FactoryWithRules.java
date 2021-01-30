import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;

import javax.swing.JToggleButton;

public class FactoryWithRules implements Factory, ActionListener {

	private Mediator mediator;

	public FactoryWithRules(Rules rules) {

		if (rules.equals(Rules.MAX_1_PERIODS_PER_DAY)) {
			mediator = new MediatorUn();

		} else {
			mediator = new MediatorDix();
		}
	}

	@Override
	public AbstractButton[][] createButtons() {
		AbstractButton grid[][] = new AbstractButton[NUM_ROW][NUM_COLUMN];
		for (int i = 0; i < NUM_ROW; i++) {
			for (int j = 0; j < NUM_COLUMN; j++) {
				grid[i][j] = new JToggleButton();
				grid[i][j].addActionListener(this);
	
			}
		}
		return grid;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AbstractButton ab = (AbstractButton) e.getSource();
		System.out.println(ab.getX());
		mediator.regle(ab);

	}

}

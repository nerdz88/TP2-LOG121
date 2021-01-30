import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MainView extends JFrame {

	private static final long serialVersionUID = 1L;

	public MainView() {
		super("Devoir 2");

		/*
		 * Set main window layout, size and defaut exit behavior 
		 */

		setBounds(100, 100, 534, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new BorderLayout(0, 0));
		add(panel);

		/* 
		 * Create check box
		 */

		JCheckBox checkBox = new JCheckBox("Administrateur");
		checkBox.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(checkBox, BorderLayout.CENTER);

		/* 
		 * Create button
		 */

		JButton button = new JButton("Afficher Dialogue");
		button.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(button, BorderLayout.SOUTH);

		button.addActionListener(l -> {
			Rules rules;
			if (checkBox.getModel().isSelected()) {
				rules = Rules.MAX_10_PERIODS_PER_WEEK;
			}
			else {				
				rules = Rules.MAX_1_PERIODS_PER_DAY;
			}
			//Factory factory = new DefaultFactory();
		Factory factory = new FactoryWithRules(rules);
			new Dialog(this, factory);
		});

		/*
		 * Display main window (JFrame)
		 */
		setVisible(true);
	}
}

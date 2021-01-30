import javax.swing.AbstractButton;

public interface Factory {
	public static final int NUM_ROW = 4;
	public static final int NUM_COLUMN = 5;
	
	public AbstractButton[][] createButtons();
}

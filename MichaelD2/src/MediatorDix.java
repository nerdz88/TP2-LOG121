import javax.swing.AbstractButton;


public class MediatorDix implements Mediator{
	
	private int MAX_CLICK=10;
	private int counter=0;
	
	@Override
	public void regle(AbstractButton ab) {
	
		if(ab.isSelected()) {
			counter++;
			if(counter > MAX_CLICK) {
				ab.setSelected(false);
				counter--;
			}
		}else {
			counter--;
		}


}
}
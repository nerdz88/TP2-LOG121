import javax.swing.AbstractButton;

public class MediatorUn implements Mediator{

	private boolean[] isAvailable = new boolean[5];

	public MediatorUn() {
		initIsAvailale();
	}

	private void initIsAvailale() {
		for(int i = 0; i< isAvailable.length; i++) {
			isAvailable[i] = true;
		}
	}

	@Override
	public void regle(AbstractButton ab) {
		System.out.println("ab is selected in MediatorUn");
		if(ab.isSelected() && checkColumn(ab.getX()) ) {
			ab.setSelected(true);
			setColumn(false,ab.getX());
		} else if(!ab.isSelected() && !checkColumn(ab.getX())){
			ab.setSelected(false);
			setColumn(true,ab.getX());
		} else {
			ab.setSelected(false);
		}
	}
	
	private boolean checkColumn(int ab) {
		boolean verif = true;
		switch(ab) {
			case 5:
				verif = isAvailable[0];
				break;
			case 107:
				verif = isAvailable[1];
				break;
			case 209 :
				verif = isAvailable[2];
				break;
			case 311 :
				verif = isAvailable[3];
				break;
			case 413:
				verif = isAvailable[4];
				break;
		}
		return 	verif;
	}

	private void setColumn(boolean b, int ab) {
		switch(ab) {
			case 5:
				isAvailable[0] = b;
				break;
			case 107:
				isAvailable[1] = b;
				break;
			case 209 :
				isAvailable[2] = b;
				break;
			case 311 :
				isAvailable[3] = b;
				break;
			case 413:
				isAvailable[4] = b;
				break;
		}
	}
}
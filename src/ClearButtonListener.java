package drawing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearButtonListener implements ActionListener {

	Drawing drawing;
	
	public ClearButtonListener(Drawing drawing){
		this.drawing = drawing;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		drawing.clear();
	}

}

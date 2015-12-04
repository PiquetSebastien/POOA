import java.awt.event.*;

public class DuplicateButtonListener implements ActionListener {

		Drawing drawing;
		
		public DuplicateButtonListener(Drawing drawing){
			this.drawing = drawing;
		}
		
		public void actionPerformed(ActionEvent e){
			
			drawing.duplication();
		}
}

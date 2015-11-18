import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Classe abstraite (Template Pattern) pour les listeners des boutons de
 * cr�ation de formes.
 */
public abstract class ShapeButtonListener implements ActionListener, MouseListener {

	Drawing drawing;
	Point origin;
	Point destination;
	
	public ShapeButtonListener(Drawing drawing){
		this.drawing = drawing;
	}
	
	/**
	 * Ajouter un MouseListener pour le type de forme courant
	 */
	public void actionPerformed(ActionEvent e) {
		drawing.addMouseListener(this);
	}
	
	/**
	 * Une fois la souris relach�e, cr�e la forme � la bonne dimension 
	 * et enl�ve le MouseListener.
	 * Template Pattern
	 */
	public void mouseReleased(MouseEvent arg0) {
		destination = arg0.getPoint();
		Shape s = createShape();
		drawing.addShape(s);
		drawing.removeMouseListener(this);
	}
	
	/**
	 * Retiens le point d'origine du mouvement de la forme.
	 */
	public void mousePressed(MouseEvent arg0) {
		origin = arg0.getPoint();
	}
	
	/**
	 * M�thode de cr�ation de la forme, � red�finir dans les sous classes.
	 * Template Pattern
	 */
	protected  abstract Shape createShape();

	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}


}

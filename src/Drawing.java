package drawing;

import javax.swing.*;
import java.awt.*;
import java.util.*;
/**
 * JPanel pouvant afficher des objets de type Shape
 */
public class Drawing extends JPanel implements Iterable<Shape> {

	private static final long serialVersionUID = 1L;
	
	ArrayList<Shape> shapes;
	
	public Drawing(){
		super();
		shapes = new ArrayList<Shape>();
	}
	
	/**
	 * Implémentation de l'interface Iterable<Shape>
	 */
	public Iterator<Shape> iterator(){
		return shapes.iterator();
	}
	
	/**
	 * Ajoute une forme au dessin et redessine
	 */
	public void addShape(Shape s){
		shapes.add(s);
		this.repaint();
	}
	
	/** 
	 * Redéfinition de la méthode paintComponent() de JComponent
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Shape s : shapes){
			s.paint(g);
		}
	}
	
	/**
	 * Enlève toutes les formes et redessine
	 */
	public void clear(){
		shapes.clear();
		this.repaint();
	}
	
	
}

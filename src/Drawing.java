import javax.swing.*;
import java.awt.*;
import java.util.*;
/**
 * JPanel pouvant afficher des objets de type Shape
 */
public class Drawing extends JPanel implements Iterable<Shape>, Observable {

	private static final long serialVersionUID = 1L;
	
	ArrayList<Shape> shapes;
	Collection<Observer> observers = new ArrayList<Observer>() ;
	private int state = 0;
	
	public Drawing(){
		super();
		shapes = new ArrayList<Shape>();
	}
	
	/**
	 * Impl�mentation de l'interface Iterable<Shape>
	 */
	public Iterator<Shape> iterator(){
		return shapes.iterator();
	}
	
	public int getSelectedShapeSize(){
		return shapes.size();
	}
	
	/**
	 * Ajoute une forme au dessin et redessine
	 */
	public void addShape(Shape s){
		shapes.add(s);
		this.repaint();
		this.notifyObservers();
	}
	
	public int getNbShapes(){
		return shapes.size();
	}
	
	/** 
	 * Red�finition de la m�thode paintComponent() de JComponent
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Shape s : shapes){
			s.paint(g);
		}
	}
	
	/**
	 * Enl�ve toutes les formes et redessine
	 */
	public void clear(){
		shapes.clear();
		this.repaint();
		this.notifyObservers();
	}
	
	//Oberserver
	
	public void addObserver(Observer o){
		observers.add(o);
	}
	
	public void removeObserver(Observer o){
		observers.remove(o);
	}
	
	public void notifyObservers(){
		for(Observer obs: observers) obs.update(this);
	}
	
	public int getState(){ return this.state;}
	
	public void setState(int state) {
		this.state = state;
		notifyObservers();
	}
	
	
}

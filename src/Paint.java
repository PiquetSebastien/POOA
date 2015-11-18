import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;
import javax.swing.border.BevelBorder;

/**
 * Classe Interface graphique pour l'application de dessin
 */
public class Paint implements Observer {

	private JFrame frame;
	private JButton clearButton;
	private JButton circleButton;
	private JButton rectangleButton;
	private JPanel buttonPanel;
	private JPanel mainPanel;
	private Drawing drawing;
	private JPanel statusPanel;
	private JPanel southPanel;
	private JLabel statusBar;
	
	public void run(){
		
		frame = new JFrame("Paint");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new JPanel(new BorderLayout());
		southPanel = new JPanel(new BorderLayout());
		
		drawing = new Drawing();
		drawing.setBackground(Color.WHITE);
		drawing.addObserver(this);
		clearButton = new JButton("Clear");
		circleButton = new JButton("Circle");
		rectangleButton = new JButton("Rectangle");
		
		buttonPanel = new JPanel();
		buttonPanel.add(clearButton);
		buttonPanel.add(circleButton);
		buttonPanel.add(rectangleButton);
		
		int nbShapes = drawing.getNbShapes();
		
		statusBar = new JLabel("Nombre de formes graphique dessinees: "+ nbShapes);
		statusPanel = new JPanel();
		statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		statusPanel.add(statusBar);
				
		southPanel.add(buttonPanel, BorderLayout.NORTH);
		southPanel.add(statusPanel, BorderLayout.SOUTH);
		
		
		mainPanel.add(drawing, BorderLayout.CENTER);
		mainPanel.add(southPanel, BorderLayout.SOUTH);
		
		//listeners pour les boutons
		clearButton.addActionListener(new ClearButtonListener(drawing));
		circleButton.addActionListener(new CircleButtonListener(drawing));
		rectangleButton.addActionListener(new RectangleButtonListener(drawing));
		
		//listeners pour la zone de dessin
		DrawingMouseListener l = new DrawingMouseListener(drawing);
		drawing.addMouseListener(l);
		drawing.addMouseMotionListener(l);

		frame.getContentPane().add(mainPanel);
		frame.setSize(640,480);
		frame.setVisible(true);
	}
	
	//Le Patron utilisé est le patron Observer
	public void update(Observable o){
		int nbS = ((Drawing)o).getNbShapes();
		statusBar.setText("Nombre de formes graphique dessinees: "+ nbS);
	}
	
	public static void main(String[] args){
				Paint app = new Paint();
				app.run();
	}
}

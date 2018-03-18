package proba;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;



public class StartPageFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton earthButton;
	JButton marsButton;
	JButton moonButton;
	JButton newPlanetButton;
	
	public StartPageFrame() {
		setSize(700,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Symulacja rzutu ukoœnego");
		
		earthButton= new JButton("Ziemia");
		marsButton= new JButton("Mars");
		moonButton= new JButton("Ksiê¿yc");
		newPlanetButton= new JButton("Twoja w³asna planeta");
		
		this.setLayout(new GridLayout(2,2));
		this.add(earthButton);
		this.add(marsButton);
		this.add(moonButton);
		this.add(newPlanetButton);
		
		earthButton.addActionListener(new EarthButtonActionListener());
		marsButton.addActionListener(new MarsButtonActionListener());
		moonButton.addActionListener(new MoonButtonActionListener());
		newPlanetButton.addActionListener(new NewPlanetButtonActionListener());
	}
	
	public class EarthButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

		}
	}
	
	public class MarsButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

		}
	}
	
	public class MoonButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

		}
	}
	
	public class NewPlanetButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

		}
	}
	
	public static void main(String[] args) {
		StartPageFrame frame= new StartPageFrame();
		frame.setVisible(true);
	}
}

package planetsFrame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class StartPageFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	JButton earthButton;
	JButton marsButton;
	JButton moonButton;
	JButton newPlanetButton;
	MainFrame planetFrame;
	JButton plLangButton;
	JButton engLangButton;
	
    Locale currentLocale;
    ResourceBundle messages;
	
	public StartPageFrame(Locale currentLocale) {
		setSize(700,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Symulacja rzutu ukośnego");
		this.currentLocale = currentLocale;
		messages = ResourceBundle.getBundle("lang/MessagesBundle", currentLocale);
		
		earthButton= new JButton(messages.getString("earth"));
		marsButton= new JButton(messages.getString("mars"));
		moonButton= new JButton(messages.getString("moon"));
		newPlanetButton= new JButton(messages.getString("newplanet"));
		URL plFlagResource = getClass().getResource("obrazki/polishFlag.png");        
		String plFlagImage = "<img src=\"" + plFlagResource
				+ "\" height=200 width=300>";
		URL engFlagResource = getClass().getResource("obrazki/englishFlag.png");        
		String engFlagImage = "<img src=\"" + engFlagResource
				+ "\" height=200 width=300>";
		plLangButton = new JButton("<html><center>" + plFlagImage + "</center></html>");
		engLangButton = new JButton("<html>" + engFlagImage + "</html>");
		
		this.setLayout(new GridLayout(3,2));
		this.add(earthButton);
		this.add(marsButton);
		this.add(moonButton);
		this.add(newPlanetButton);
		this.add(plLangButton);
		this.add(engLangButton);
		
		earthButton.addActionListener(new EarthButtonActionListener());
		marsButton.addActionListener(new MarsButtonActionListener());
		moonButton.addActionListener(new MoonButtonActionListener());
		newPlanetButton.addActionListener(new NewPlanetButtonActionListener());
		plLangButton.addActionListener(new PlLangButtonActionListener());
		engLangButton.addActionListener(new EngLangButtonActionListener());
		
		this.setVisible(true);
	}
	
	public class EarthButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			double mass = 10;
			double acceleration = 9.81;
			double angle = 45;
			double velocity = 10;
			double airResistance = 8;
			int choice = 1;
			planetFrame = new MainFrame(currentLocale, acceleration, mass, velocity, angle, airResistance, choice);

		}
	}
	
	public class MarsButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			double mass = 10;
			double acceleration = 3.7;
			double angle = 45;
			double velocity = 10;
			double airResistance = 10;
			int choice = 2;
			planetFrame = new MainFrame(currentLocale, acceleration, mass, velocity, angle, airResistance, choice);

		}
	}
	
	public class MoonButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			double mass = 10;
			double acceleration = 1.62;
			double angle = 45;
			double velocity = 10;
			double airResistance = 0.0001;
			int choice = 3;
			planetFrame = new MainFrame(currentLocale, acceleration, mass, velocity, angle, airResistance, choice);

		}
	}
	
	public class NewPlanetButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			double mass = 0;
			double acceleration = 0;
			double angle = 0;
			double velocity = 0;
			double airResistance = 0;
			int choice = 4;
			planetFrame = new MainFrame(currentLocale, acceleration, mass, velocity, angle, airResistance, choice);
			StartPageFrame.this.dispose();

		}
	}
	public class PlLangButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			currentLocale = new Locale("pl", "PL");
			messages = ResourceBundle.getBundle("lang/MessagesBundle", currentLocale);
			earthButton.setText(messages.getString("earth"));
			marsButton.setText(messages.getString("mars"));
			moonButton.setText(messages.getString("moon"));
			newPlanetButton.setText(messages.getString("newplanet"));

		}
	}
	public class EngLangButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			currentLocale = new Locale("en", "ENG");
			messages = ResourceBundle.getBundle("lang/MessagesBundle", currentLocale);
			earthButton.setText(messages.getString("earth"));
			marsButton.setText(messages.getString("mars"));
			moonButton.setText(messages.getString("moon"));
			newPlanetButton.setText(messages.getString("newplanet"));

		}
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				StartPageFrame frame= new StartPageFrame(new Locale("pl", "PL"));
				
			}
			
		});
		
	}
}

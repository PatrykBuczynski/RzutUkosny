package planetsFrame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;



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
			currentLocale = new Locale("en", "ENG");
			messages = ResourceBundle.getBundle("lang/MessagesBundle", currentLocale);
			earthButton.setText(messages.getString("earth"));
			marsButton.setText(messages.getString("mars"));
			moonButton.setText(messages.getString("moon"));
			newPlanetButton.setText(messages.getString("newplanet"));

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
			planetFrame = new MainFrame(currentLocale);
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
		StartPageFrame frame= new StartPageFrame(new Locale("pl", "PL"));
	}
}

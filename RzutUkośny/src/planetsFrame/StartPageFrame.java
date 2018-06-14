package planetsFrame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
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
		this.currentLocale = currentLocale;
		messages = ResourceBundle.getBundle("lang/MessagesBundle", currentLocale);
		setTitle(messages.getString("title"));
		
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
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel"); 
            getRootPane().getActionMap().put("Cancel", new AbstractAction(){
                public void actionPerformed(ActionEvent e)
                {
                    System.exit(1);
                }
            });
		
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
			final int choice = 1;
			planetFrame = new MainFrame(currentLocale, acceleration, mass, velocity, angle, airResistance, choice);
			StartPageFrame.this.dispose();
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
			final int choice = 2;
			planetFrame = new MainFrame(currentLocale, acceleration, mass, velocity, angle, airResistance, choice);
			StartPageFrame.this.dispose();
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
			final int choice = 3;
			planetFrame = new MainFrame(currentLocale, acceleration, mass, velocity, angle, airResistance, choice);
			StartPageFrame.this.dispose();
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
			final int choice = 4;
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
			setTitle(messages.getString("title"));

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
			setTitle(messages.getString("title"));

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

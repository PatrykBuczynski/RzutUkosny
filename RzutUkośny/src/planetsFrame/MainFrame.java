package planetsFrame;
import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;

public class MainFrame extends JFrame {

	LineEndPanel lineEnd;
	CenterPanel center;
	StartPageFrame frame;
	ChartPanel trajectoryPanel;
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem importItem;
	JMenuItem exportItem;
	JMenuItem backItem;
	JMenuItem aboutItem;
	JMenuItem newItem;
	private BufferedImage image;
	
    Locale currentLocale;
    ResourceBundle messages;
    
    double acceleration;
    double mass;
    double velocity;
    double angle;
    double airResistance;
    int choice;
	
	public MainFrame(Locale currentLocale, double acceleration, double mass, double velocity, double angle, double airResistance, int choice) throws HeadlessException {
		// TODO Auto-generated constructor stub
		this.setSize(900, 700);
		this.currentLocale = currentLocale;
		this.acceleration = acceleration;
		this.mass = mass;
		this.velocity = velocity;
		this.angle = angle;
		this.airResistance = airResistance;
		this.choice = choice;
		messages = ResourceBundle.getBundle("lang/MessagesBundle", currentLocale);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle(messages.getString("title"));
		menuBar = new JMenuBar();
		menu = new JMenu(messages.getString("menu"));
		this.setJMenuBar(menuBar);
		menuBar.add(menu);
		importItem = new JMenuItem(messages.getString("import"));
		exportItem = new JMenuItem(messages.getString("export"));
		backItem = new JMenuItem (messages.getString("back"));
		aboutItem = new JMenuItem (messages.getString("about"));
		newItem = new JMenuItem (messages.getString("new"));
		menu.add(newItem);
		menu.add(importItem);
		menu.add(exportItem);
		menu.add(aboutItem);
		menu.add(backItem);
		lineEnd = new LineEndPanel(this, currentLocale);
		center = new CenterPanel(this);
		
		this.add(center, BorderLayout.CENTER);
		this.add(lineEnd, BorderLayout.LINE_END);
		
		this.setVisible(true);
		newItem.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(MainFrame.this.choice == 1) {
					double mass = 10;
					double acceleration = 9.81;
					double angle = 45;
					double velocity = 10;
					double airResistance = 8;
					final int choice = 1;
					MainFrame planetFrame = new MainFrame(currentLocale, acceleration, mass, velocity, angle, airResistance, choice);
				}
				if(MainFrame.this.choice == 2) {
					double mass = 10;
					double acceleration = 3.7;
					double angle = 45;
					double velocity = 10;
					double airResistance = 10;
					final int choice = 2;
					MainFrame planetFrame = new MainFrame(currentLocale, acceleration, mass, velocity, angle, airResistance, choice);
				}
				if(MainFrame.this.choice == 3) {
					double mass = 10;
					double acceleration = 1.62;
					double angle = 45;
					double velocity = 10;
					double airResistance = 0.0001;
					final int choice = 3;
					MainFrame planetFrame = new MainFrame(currentLocale, acceleration, mass, velocity, angle, airResistance, choice);
				}
				if(MainFrame.this.choice == 4) {
					double mass = 10;
					double acceleration = 1.62;
					double angle = 45;
					double velocity = 10;
					double airResistance = 0.0001;
					final int choice = 3;
					MainFrame planetFrame = new MainFrame(currentLocale, acceleration, mass, velocity, angle, airResistance, choice);
				}
				MainFrame.this.dispose();
			}
			
		});
		
		backItem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				frame = new StartPageFrame(currentLocale);
				MainFrame.this.dispose();
			}
		});
		aboutItem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				URL resource = getClass().getResource("obrazki/logoFizyka.jpg");        
		        String credits = "<img src=\"" + resource
                        + "\" height=200 width=200>";
				JOptionPane.showMessageDialog(MainFrame.this, "<html><center>" + credits  + messages.getString("aboutdialog") , messages.getString("aboutdialogtitle"), JOptionPane.PLAIN_MESSAGE);
			}
		});
	}

	public MainFrame(GraphicsConfiguration arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public MainFrame(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public MainFrame(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	

}

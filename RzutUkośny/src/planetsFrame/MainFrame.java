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

public class MainFrame extends JFrame {

	LineEndPanel lineEnd;
	CenterPanel center;
	StartPageFrame frame;
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
	
	public MainFrame(Locale currentLocale) throws HeadlessException {
		// TODO Auto-generated constructor stub
		this.setSize(1000,800);
		this.currentLocale = currentLocale;
		messages = ResourceBundle.getBundle("lang/MessagesBundle", currentLocale);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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

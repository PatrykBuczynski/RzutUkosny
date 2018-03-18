package planetsFrame;
import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainFrame extends JFrame {


	LineEndPanel lineEnd;
	CenterPanel center;
	
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem importItem;
	JMenuItem exportItem;
	JMenuItem backItem;
	JMenuItem aboutItem;
	JMenuItem newItem;
	
	public MainFrame() throws HeadlessException {
		// TODO Auto-generated constructor stub
		this.setSize(1000,800);
		menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		menu.setMnemonic(KeyEvent.VK_M);
		this.setJMenuBar(menuBar);
		menuBar.add(menu);
		importItem = new JMenuItem("Import");
		exportItem = new JMenuItem("Export");
		backItem = new JMenuItem ("Powrót");
		aboutItem = new JMenuItem ("Opis programu");
		newItem = new JMenuItem ("Nowa symulacja");
		menu.add(newItem);
		menu.add(importItem);
		menu.add(exportItem);
		menu.add(aboutItem);
		menu.add(backItem);
		lineEnd = new LineEndPanel(this);
		center = new CenterPanel(this);
		
		this.add(center, BorderLayout.CENTER);
		this.add(lineEnd, BorderLayout.LINE_END);
		
		this.setVisible(true);
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame frame = new MainFrame();

	}
	
	

}

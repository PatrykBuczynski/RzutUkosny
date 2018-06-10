package planetsFrame;
import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class MainFrame extends JFrame {

	LineEndPanel lineEnd;
	//CenterPanel center;
	StartPageFrame frame;
	ChartPanel trajectoryPanel;
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem importItem;
	JMenu exportItem;
	JMenuItem backItem;
	JMenuItem aboutItem;
	JMenuItem newItem;
	JMenuItem exportChart;
	JMenuItem exportData;
	JFileChooser chooser;
	
	
	
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
		exportItem = new JMenu(messages.getString("export"));
		backItem = new JMenuItem (messages.getString("back"));
		aboutItem = new JMenuItem (messages.getString("about"));
		newItem = new JMenuItem (messages.getString("new"));
		exportChart = new JMenuItem("chart");
		exportData = new JMenuItem("data");
		menu.add(newItem);
		menu.add(importItem);
		menu.add(exportItem);
		menu.add(aboutItem);
		menu.add(backItem);
		exportItem.add(exportChart);
		exportItem.add(exportData);
		lineEnd = new LineEndPanel(this, currentLocale);
		//center = new CenterPanel(this);
		
		
		//this.add(center, BorderLayout.CENTER);
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
		
		exportData.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				chooser = new JFileChooser();
				
				int returnVal = chooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					try {
						FileWriter fw = new FileWriter(file);
						BufferedWriter bw = new BufferedWriter(fw);
						int sz = TrajectoryClass.getxPosition().size();
						bw.write("xPosition || yPositition");
						bw.newLine();
						for(int i=0; i<sz; i++) {
							bw.write(TrajectoryClass.getxPosition().get(i).toString() + " || " + TrajectoryClass.getyPosition().get(i).toString());
							bw.newLine();
						}
						bw.close();
						} catch (IOException e) {
							e.printStackTrace();
					
						}
					
				}		
				
			}
		});
		
		exportChart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(null, "png");
				fileChooser.setFileFilter(filter);
				int returnVal = fileChooser.showOpenDialog(MainFrame.this);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
				       
				if(TrajectoryClass.chart == null) {
						JOptionPane.showMessageDialog(MainFrame.this, "Brak wykresu", "Error!", JOptionPane.ERROR_MESSAGE);

				}
				else {
				    	try {
								ChartUtilities.saveChartAsPNG(fileChooser.getSelectedFile(), TrajectoryClass.chart, 700, 500);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
				    	}
				    }
			}
		});
		
		importItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				chooser = new JFileChooser();
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter(null, "txt");
				    chooser.setFileFilter(filter);
				    int returnVal = chooser.showOpenDialog(MainFrame.this);
				    if(returnVal == JFileChooser.APPROVE_OPTION) {
				    	try {
							FileReader fr = new FileReader(chooser.getSelectedFile());
							BufferedReader bfr = new BufferedReader(fr);
							String line = bfr.readLine();
							StringTokenizer tokenizer = new StringTokenizer(line);
							
							LineEndPanel.massTextField.setText(tokenizer.nextToken());
							LineEndPanel.accelerationTextField.setText(tokenizer.nextToken());
							LineEndPanel.angleTextField.setText(tokenizer.nextToken());
							LineEndPanel.velocityTextField.setText(tokenizer.nextToken());
							LineEndPanel.airResistanceTextField.setText(tokenizer.nextToken());
						
							bfr.close();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				    }
				
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

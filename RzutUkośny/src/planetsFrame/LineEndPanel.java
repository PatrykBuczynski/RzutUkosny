package planetsFrame;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LineEndPanel extends JPanel {

	public LineEndPanel(MainFrame frame, Locale currentLocale) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
		this.currentLocale = currentLocale;
		messages = ResourceBundle.getBundle("lang/MessagesBundle", currentLocale);
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		velocityLabel = new JLabel(messages.getString("velocity"), JLabel.CENTER);
		massLabel = new JLabel(messages.getString("mass"), JLabel.CENTER);
		angleLabel = new JLabel(messages.getString("angle"), JLabel.CENTER);
		accelerationLabel = new JLabel(messages.getString("acceleration"), JLabel.CENTER);
		airResistanceLabel = new JLabel(messages.getString("airresistance"), JLabel.CENTER);
		velocityLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		massLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		angleLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		accelerationLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		airResistanceLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		accelerationTextField = new JTextField("" + frame.acceleration);
	    accelerationTextField.setHorizontalAlignment(JTextField.CENTER);
		massTextField = new JTextField("" + frame.mass);
		massTextField.setHorizontalAlignment(JTextField.CENTER);
		angleTextField = new JTextField("" + frame.angle);
		angleTextField.setToolTipText(messages.getString("angleHint"));
		angleTextField.setHorizontalAlignment(JTextField.CENTER);
		velocityTextField = new JTextField("" + frame.velocity);
		velocityTextField.setHorizontalAlignment(JTextField.CENTER);
		airResistanceTextField = new JTextField("" + frame.airResistance);
		
		if(frame.choice < 4) {
			accelerationTextField.setEnabled(false);
			accelerationLabel.setEnabled(false);
		}
		if(frame.choice == 3) {
			airResistanceLabel.setEnabled(false);
			airResistanceTextField.setEnabled(false);
		}
		airResistanceTextField.setHorizontalAlignment(JTextField.CENTER);
		colorChangeButton = new JButton(messages.getString("colorchange"));
		activationButton = new JButton(messages.getString("activationButton"));
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		

		colorChangeButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				if(trajectoryIsPresent) {
					Color newColor = JColorChooser.showDialog(null,"Choose Color",trajectory.getChartColor());
					trajectory.setChartColor(newColor);
					trajectory.recolorChart();
				}
				
			}
		});
		activationButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				if(!trajectoryIsPresent) {
					double velocity = Double.parseDouble(velocityTextField.getText());
					double acceleration = Double.parseDouble(accelerationTextField.getText());
					double angle = Double.parseDouble(angleTextField.getText());
					double airResistance = Double.parseDouble(airResistanceTextField.getText());
					double mass = Double.parseDouble(massTextField.getText());
					if(frame.choice == 4) {
						velocityLabel.setEnabled(false);
						massLabel.setEnabled(false);
						angleLabel.setEnabled(false);
						airResistanceLabel.setEnabled(false);
						accelerationLabel.setEnabled(false);
						velocityTextField.setEnabled(false);
						massTextField.setEnabled(false);
						accelerationTextField.setEnabled(false);
						angleTextField.setEnabled(false);
						airResistanceTextField.setEnabled(false);
					}
					else {
						if(frame.choice == 3) {
							velocityLabel.setEnabled(false);
							massLabel.setEnabled(false);
							angleLabel.setEnabled(false);
							velocityTextField.setEnabled(false);
							massTextField.setEnabled(false);
							angleTextField.setEnabled(false);
						}
						else {
							velocityLabel.setEnabled(false);
							massLabel.setEnabled(false);
							angleLabel.setEnabled(false);
							airResistanceLabel.setEnabled(false);
							velocityTextField.setEnabled(false);
							massTextField.setEnabled(false);
							angleTextField.setEnabled(false);
							airResistanceTextField.setEnabled(false);
						}
					}
					trajectory = new TrajectoryClass(acceleration, angle, mass, velocity, airResistance, frame, frame.currentLocale);
					trajectoryIsPresent = true;

					trajectory.calculate();
				}
				else {
					if(trajectory.getIsCanceled() == false) {
						trajectory.getWorker().cancel(true);
						trajectory.setIsCanceled(true);
					}
					else {
						trajectory.calculate();
					}
				}
				
			}
			
		});
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weighty = 1.0;
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 10;
		this.add(velocityLabel, c);
		c.gridx = 1;
		c.ipadx = 50;
		c.ipady = 10;
		this.add(velocityTextField, c);
		c.gridx = 0;
		c.gridy = 1;
		this.add(massLabel, c);
		c.gridx = 1;
		this.add(massTextField, c);
		c.gridx = 0;
		c.gridy = 2;
		this.add(angleLabel, c);
		c.gridx = 1;
		this.add(angleTextField, c);
		c.gridx = 0;
		c.gridy = 3;
		this.add(accelerationLabel, c);
		c.gridx = 1;
		this.add(accelerationTextField, c);
		c.gridx = 0;
		c.gridy = 4;
		this.add(airResistanceLabel, c);
		c.gridx = 1;
		this.add(airResistanceTextField,c);
		c.gridx = 0;
		c.gridy = 5;
		c.ipady = 40;
		c.gridwidth = 2;
		this.add(colorChangeButton, c);
		c.gridy = 6;
		this.add(activationButton, c);
		
		
		
	}

	public LineEndPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public LineEndPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public LineEndPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}
	MainFrame frame;
	JLabel accelerationLabel;
	JLabel massLabel;
	JLabel angleLabel;
	JLabel velocityLabel;
	JLabel airResistanceLabel;
	JTextField accelerationTextField;
	JTextField massTextField;
	JTextField angleTextField;
	JTextField velocityTextField;
	JTextField airResistanceTextField;
	JButton colorChangeButton;
	JButton activationButton;
	TrajectoryClass trajectory;
	boolean trajectoryIsPresent = false;
	boolean isON = false;
	boolean isChart = false;
	
    Locale currentLocale = new Locale("pl", "PL");
    ResourceBundle messages;

}

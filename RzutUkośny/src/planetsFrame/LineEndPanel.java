package planetsFrame;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LineEndPanel extends JPanel {

	public LineEndPanel(MainFrame frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		velocityLabel = new JLabel("Prêdkoœæ", JLabel.CENTER);
		massLabel = new JLabel("Masa", JLabel.CENTER);
		angleLabel = new JLabel("K¹t nachylenia do osi OX", JLabel.CENTER);
		accelerationLabel = new JLabel("Przyœpieszenie grawitacyjne", JLabel.CENTER);
		velocityLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		massLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		angleLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		accelerationLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		accelerationTextField = new JTextField("" + 0);
	    accelerationTextField.setHorizontalAlignment(JTextField.CENTER);
		massTextField = new JTextField("" + 0);
		massTextField.setHorizontalAlignment(JTextField.CENTER);
		angleTextField = new JTextField("" + 0);
		angleTextField.setHorizontalAlignment(JTextField.CENTER);
		velocityTextField = new JTextField("" + 0);
		velocityTextField.setHorizontalAlignment(JTextField.CENTER);
		colorChangeButton = new JButton("Przycisk zmiany t³a");
		activationButton = new JButton("ON/OFF");
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		

		
		
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
		c.ipady = 40;
		c.gridwidth = 2;
		this.add(colorChangeButton, c);
		c.gridx = 0;
		c.gridy = 5;
		this.add(activationButton, c);
		
//		this.add(velocityLabel);
//		this.add(velocityTextField);
//		this.add(massLabel);
//		this.add(massTextField);
//		this.add(angleLabel);
//		this.add(angleTextField);
//		this.add(accelerationLabel);
//		this.add(accelerationTextField);
		
		
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
	JTextField accelerationTextField;
	JTextField massTextField;
	JTextField angleTextField;
	JTextField velocityTextField;
	JButton colorChangeButton;
	JButton activationButton;

}

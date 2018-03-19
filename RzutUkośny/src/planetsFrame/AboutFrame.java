package planetsFrame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutFrame extends JFrame {

	public AboutFrame() throws HeadlessException {
		// TODO Auto-generated constructor stub
		this.setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("O programie");
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		credits = new JLabel("Symulacja rzutu ukośnego. Program przygotowany przez Patryka Buczyńskiegi i"
				+ " Klaudie Echolc, studentów Wydziału Fizyki Politechniki Warszawskiej");
		imagePanel = new ImagePanel();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.ipady = 20;
		this.add(credits, c);
		c.gridy = 1;
		c.gridx = 2;
		c.ipady = 0;
		c.gridwidth = 0;
		this.add(imagePanel, c);

		this.setVisible(true);
	}

	public AboutFrame(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public AboutFrame(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public AboutFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}
	JLabel credits;
	ImagePanel imagePanel;
}

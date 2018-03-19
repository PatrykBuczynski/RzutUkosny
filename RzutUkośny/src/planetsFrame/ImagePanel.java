package planetsFrame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

		
	public ImagePanel() {
        URL resource = getClass().getResource("obrazki/logoFizyka.jpg");        
        try {
            image = ImageIO.read(resource);
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }
 
        Dimension dimension = new Dimension(image.getWidth(), image.getHeight());
        setPreferredSize(dimension);
			
	}
		@Override
		public void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D)g;
			g2d.drawImage(image, 50, 50, image.getWidth()/2 ,image.getHeight()/2, this);
			}


	private BufferedImage image;
}

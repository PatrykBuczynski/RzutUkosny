package planetsFrame;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class CenterPanel extends JPanel {

	public CenterPanel(MainFrame frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
		this.setBackground(Color.WHITE);
	}

	public CenterPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public CenterPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public CenterPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}
	MainFrame frame;
}

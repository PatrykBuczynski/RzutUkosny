package planetsFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.SwingWorker;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class TrajectoryClass {
	
	private double acceleration;
	private double angle;
	private double airResistance;
	private double angleInRad;
	private double mass;
	private double velocity;
	private double betaFactor;
	private double xVelocity;
	private double yVelocity;
	private double ksi;
	private double eta;
	private ArrayList <Double> xPosition;
	private ArrayList <Double> yPosition;
	private MainFrame frame;
	private SwingWorker<Void, ChartPanel> worker;
	private JFreeChart chart;
	private Color chartColor = null;

	public TrajectoryClass(double acceleration, double angle, double mass, double velocity, double airResistance, MainFrame frame) {
		// TODO Auto-generated constructor stub
		this.acceleration = acceleration;
		this.angle = angle;
		this.mass = mass;
		this.velocity = velocity;
		this.airResistance = airResistance;
		this.frame = frame;
		angleInRad = Math.toRadians(angle);
		betaFactor = airResistance/mass;
		xVelocity = velocity * Math.cos(angleInRad);
		yVelocity = velocity * Math.sin(angleInRad);
		xPosition = new ArrayList<Double>();
		yPosition = new ArrayList<Double>();
		xPosition.add(0.0);
		yPosition.add(0.0);
		eta = this.acceleration/(betaFactor*betaFactor); // zastosowano podstawienie w celu uproszczenia wzoru

	}
	public void calculate() {
		
		XYSeries series = new XYSeries("Nazwa serii");
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		chart = ChartFactory.createXYLineChart(
			"Trajekoria lotu ciała",//Tytul
			"Położenie x", // opisy osi
			"Położenie y", 
			dataset, // Dane 
			PlotOrientation.VERTICAL, // Orjentacja wykresu /HORIZONTAL
			false, // legenda
			false, // tooltips
			false
		);
		ChartPanel panel = new ChartPanel(chart);
		chart.getPlot().setBackgroundPaint(chartColor);
		frame.remove(frame.center);
		frame.add(panel, BorderLayout.CENTER);
		series.add(0, 0);

		worker = new SwingWorker<Void, ChartPanel>(){

			@Override
			protected Void doInBackground() throws Exception {
				// TODO Auto-generated method stub
				do {
					//System.out.println(xPosition.size() + " " + yPosition.size());
					xPosition.add(xPosition.get(xPosition.size() - 1) + 0.001);
					ksi = betaFactor * xPosition.get(xPosition.size() - 1) / xVelocity; // zastosowano podstawienie w celu uproszczenia wzoru
					yPosition.add((yVelocity/betaFactor + eta)* ksi + (eta*Math.log(1.0 - ksi)));
					
					if(yPosition.get(yPosition.size() - 1).isNaN() || yPosition.get(yPosition.size() - 1) < 0) {
						yPosition.set(yPosition.size() - 1, 0.0);
					}
					
					series.add(xPosition.get(xPosition.size() - 1), yPosition.get(yPosition.size() - 1));
					System.out.println(xPosition.get(xPosition.size() - 1) + ", " + yPosition.get(yPosition.size() - 1));
					frame.validate();
					Thread.sleep(1);
					
				} while(yPosition.get(yPosition.size() - 1) > 0);
				
				return null;
			}
			@Override
			protected void done() {
	
				frame.lineEnd.trajectoryIsPresent = false;
				if(frame.choice == 4) {
					frame.lineEnd.velocityLabel.setEnabled(true);
					frame.lineEnd.massLabel.setEnabled(true);
					frame.lineEnd.angleLabel.setEnabled(true);
					frame.lineEnd.airResistanceLabel.setEnabled(true);
					frame.lineEnd.accelerationLabel.setEnabled(true);
					frame.lineEnd.velocityTextField.setEnabled(true);
					frame.lineEnd.massTextField.setEnabled(true);
					frame.lineEnd.accelerationTextField.setEnabled(true);
					frame.lineEnd.angleTextField.setEnabled(true);
					frame.lineEnd.airResistanceTextField.setEnabled(true);
				}
				else {
					if(frame.choice == 3) {
						frame.lineEnd.velocityLabel.setEnabled(true);
						frame.lineEnd.massLabel.setEnabled(true);
						frame.lineEnd.angleLabel.setEnabled(true);
						frame.lineEnd.velocityTextField.setEnabled(true);
						frame.lineEnd.massTextField.setEnabled(true);
						frame.lineEnd.angleTextField.setEnabled(true);
					}
					else {
						frame.lineEnd.velocityLabel.setEnabled(true);
						frame.lineEnd.massLabel.setEnabled(true);
						frame.lineEnd.angleLabel.setEnabled(true);
						frame.lineEnd.airResistanceLabel.setEnabled(true);
						frame.lineEnd.velocityTextField.setEnabled(true);
						frame.lineEnd.massTextField.setEnabled(true);
						frame.lineEnd.angleTextField.setEnabled(true);
						frame.lineEnd.airResistanceTextField.setEnabled(true);
					}
				}
			}
			
			
			
		};
		
		worker.execute();
	}
	
	public void setChartColor(Color newColor) {
		chartColor = newColor;
	}
	public void recolorChart() {
		chart.getPlot().setBackgroundPaint(chartColor);
	}
	public SwingWorker<Void, ChartPanel> getWorker() {
		return worker;
		
	}


}

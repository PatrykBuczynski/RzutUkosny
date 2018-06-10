package planetsFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;


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
	private static ArrayList <Double> xPosition;
	private static ArrayList <Double> yPosition;
	private MainFrame frame;
	private SwingWorker<Void, ChartPanel> worker;
	static JFreeChart chart;
	private ChartPanel panel;
	private XYSeries series;
	private XYSeriesCollection dataset;
	private Color chartColor = null;
	private Locale currentLocale;
	private ResourceBundle messages;
	private boolean isCanceled = false;


	public TrajectoryClass(double acceleration, double angle, double mass, double velocity, double airResistance, MainFrame frame, Locale currentLocale) {

		// TODO Auto-generated constructor stub
		
		this.acceleration = acceleration;
		this.angle = angle;
		this.mass = mass;
		this.velocity = velocity;
		this.airResistance = airResistance;
		this.frame = frame;
		this.currentLocale = currentLocale;
		messages = ResourceBundle.getBundle("lang/MessagesBundle", currentLocale);
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
		
		if(isCanceled == false) {
			
			series = new XYSeries(messages.getString("data"));
			dataset = new XYSeriesCollection();
			dataset.addSeries(series);
			chart = ChartFactory.createXYLineChart(
					messages.getString("charttitle"),//Tytul
					messages.getString("xaxis"), // opisy osi
					messages.getString("yaxis"), 
					dataset, // Dane 
					PlotOrientation.VERTICAL, // Orjentacja wykresu /HORIZONTAL
					false, // legenda
					true, // tooltips
					false
					);
			panel = new ChartPanel(chart);
			chart.getPlot().setBackgroundPaint(chartColor);
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
						
						
						//System.out.println(xPosition.get(xPosition.size() - 1) + ", " + yPosition.get(yPosition.size() - 1));
						frame.validate();
						Thread.sleep(1);
						
						
						
					} while(yPosition.get(yPosition.size() - 1) > 0);
					
					
					
					
					return null;
					
					
				}
				
				@Override
				protected void done() {
					if(yPosition.get(yPosition.size() -1) == 0) {
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
				}
				
				
				
			};
			
			worker.execute();
		}
		else {
			isCanceled = false;
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
						
						
						//System.out.println(xPosition.get(xPosition.size() - 1) + ", " + yPosition.get(yPosition.size() - 1));
						frame.validate();
						Thread.sleep(1);
						
						
						
					} while(yPosition.get(yPosition.size() - 1) > 0);
					
					
					
					
					return null;
					
					
				}
				
				@Override
				protected void done() {
					if(yPosition.get(yPosition.size() -1) == 0) {
						
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
				}
				
				
				
			};
			
			worker.execute();
		}
	}
	
	public void setChartColor(Color newColor) {
		chartColor = newColor;
	}
	public void recolorChart() {
		chart.getPlot().setBackgroundPaint(chartColor);
		panel.revalidate();
		
	}
	public SwingWorker<Void, ChartPanel> getWorker() {
		return worker;
		
	}
	public Color getChartColor() {
		return chartColor;
	}
	public static ArrayList <Double> getxPosition(){
		return xPosition;
		
	}
	public static ArrayList <Double> getyPosition(){
		return yPosition;
		
	}
	public boolean getIsCanceled() {
		return isCanceled;
	}
	public void setIsCanceled(boolean newBoolean) {
		isCanceled = newBoolean;
	}
	
	

}

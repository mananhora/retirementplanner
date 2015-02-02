import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.UIManager;


public class Graph extends JPanel{
	
	double [] values;
	
	private static JLabel year = new JLabel("Year");
	private static JLabel savings = new JLabel("Savings");
	private static JLabel cA = new JLabel(String.valueOf(Data.getcA()));
	
	
	
	public static JLabel getYear(){
		return year;
	}
	
	
	public static JLabel getSavings(){
		return savings;
	}
	
	
	public static JLabel getcA(){
		return cA;
	}
	
	
	
	public Graph(JLabel label, JLabel label_1, JLabel textPane){
		this.year = label;
		this.savings = label_1;
		this.cA = textPane;
		setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		setPreferredSize(new Dimension(380, 236));   //GRAPH SIZE
		values = new double[Data.getrA()-Data.getcA()];
		for(int i= 0; i<Data.getrA()-Data.getcA(); i++){
			values[i] = Data.CalcFund(Data.getdS(), Data.geti(),  Data.getcS(),  Data.getcA()+i, Data.getcA(), Data.getInf());
	}
		
		
	}
		
	
	
	
public void paintComponent(Graphics page){
	super.paintComponent(page);
	//coordinate transform
	int w = this.getWidth()-100;
	int h = this.getHeight()-100;
	int mid = h/2;
	int bwidth = w/values.length;
	double min = getMin(values);
	double max = getMax(values);
	double factor = mid/Math.max(Math.abs(min), Math.abs(max));
	//to here
	
	for(int i = 0; i<values.length;i++){
		int bheight = (int) Math.floor(factor*values[i]);
		if(values[i]>=0){
			page.setColor(Color.ORANGE);
			page.fillRect(i*bwidth, mid-bheight, bwidth, bheight);
			page.setColor(Color.black);
			page.drawRect(i*bwidth,mid-bheight, bwidth, bheight);
		}
		else{
			page.setColor(Color.red);
			page.fillRect(i*bwidth, mid, bwidth, -bheight);
			page.setColor(Color.black);
			page.drawRect(i*bwidth,mid, bwidth, -bheight);
		}
		
	}
	page.setColor(Color.white);
	page.drawString((int)RetirementPanel.gettotal()+ " ",5, 15);
	page.drawString("-" + (int)RetirementPanel.gettotal(), 5, h-15);
	page.drawString("Years", 5, 80);
	page.drawString("Accumulated", 280, 30);
	page.drawString("savings", 280, 40);

	

   
    
    

}

//Method to get min
	public static double getMin(double[] a){
			double r = a[0];
			for(int i = 0; i<a.length; i++){
				r = ((r>a[i])?a[i]:r);
			}
			return r;
		}
		
		
	//Method to get Max
	public  static  double getMax(double[] a){
		double r = a[0];
		for(int i=0; i<a.length; i++){
			r = ((r<a[i])?a[i]:r);
		}
		return r;
	}



}

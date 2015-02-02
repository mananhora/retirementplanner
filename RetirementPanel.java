import javax.swing.JPanel;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class RetirementPanel extends JPanel implements ActionListener {
	private JTextField currentage;
	private JTextField dailysavings;
	private JTextField retirementage;
	private JTextField currentsavings;
	private JLabel savingslabel;
	private JLabel incomelabel;
	private JButton btnNewButton = new JButton("Calculate");
	JPanel panel = new JPanel();
	private JLabel inflationlabel;
	private JTextField lifeexpectancy;
	private JTextField inflation;
	private JTextField rateofreturn;
	private JLabel totalsavings;
	private static double total;
	private JLabel desiredaRI;
	private JTextField ri;
	private final JLabel result = new JLabel("");
	
	public static void settotal(double input){
		total = input;
	}
	
	public static double gettotal(){
		return total;
	}

	public RetirementPanel() {
		setForeground(new Color(0, 0, 0));

		
		btnNewButton.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		btnNewButton.setBounds(296, 302, 102, 29);
		btnNewButton.addActionListener(this);
		setLayout(null);

		//DAILY SAVINGS TEXT FIELD
		dailysavings = new JTextField();
		dailysavings.setBounds(292, 47, 166, 28);
		add(dailysavings);
		dailysavings.setColumns(10);
		
		//DAILY SAVINGS ACTIONLISTENER
		dailysavings.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == dailysavings) {
					String DSavings = dailysavings.getText(); //getting text from dailysavings textfield
					Data.setdS(Double.parseDouble(DSavings)); //setting value of dailysavings 
					String Inf = inflation.getText();  //getting text from inflation textfield
					Data.setInf(Double.parseDouble(Inf)); //setting value of inflation
				
					//CALCULATION
					double aRI = Data.CalcaRI(Data.getdS(), Data.geti(),
							Data.getcS(), Data.getrA(), Data.getcA(),
							Data.getInf());  //calculating annual retirement income

					total = Data.CalcFund(Data.getdS(), Data.geti(),
							Data.getcS(), Data.getrA(), Data.getcA(),
							Data.getInf()); //calculating accumulated savings
					
					//OUTPUT
					totalsavings.setText("Accumulated savings are $"
							+ String.valueOf((int) total)); //setting label to result 
					
					incomelabel.setText("Expected Annual Retirement Income is $"
									+ String.valueOf((int) aRI));  //setting label to result
					
					//GRAPH
					Graph g = new Graph(Graph.getYear(), Graph.getSavings(),
							Graph.getcA()); //object of graph class
					panel.removeAll(); //removing the graph
					panel.add(g, SpringLayout.SOUTH); //adding the graph
					validate();
					repaint();
					String income = ri.getText();
					int inc = (int)(Double.parseDouble(income));
					if(aRI>inc){
						result.setText("Congratulations!! You've planned well for retirement!");
					}
					else{
						result.setText("Your daily savings are not enough to give you your desired retirement income. You need to reduce your daily starbucks visits!");

					}

				}

			} // end actionperformed

		}); // end actionlistener

		
		//RETIREMENT AGE TEXTFIELD
		retirementage = new JTextField();
		retirementage.setBounds(292, 137, 166, 28);
		add(retirementage);
		retirementage.setColumns(10);
		
		//RETIREMENT AGE ACTIONLISTENER
		retirementage.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == retirementage) {
					String rAge = retirementage.getText(); 
					Data.setrA(Integer.parseInt(rAge));//setting retirement age
					String Inf = inflation.getText();
					Data.setInf(Double.parseDouble(Inf)); //setting inflation

					double aRI = Data.CalcaRI(Data.getdS(), Data.geti(),
							Data.getcS(), Data.getrA(), Data.getcA(),
							Data.getInf());  //calculating ARI

					total = Data.CalcFund(Data.getdS(), Data.geti(),
							Data.getcS(), Data.getrA(), Data.getcA(),
							Data.getInf());  //calculating total savings
					
					totalsavings.setText("Accumulated savings are $"
							+ String.valueOf((int) total)); //output 
					incomelabel
							.setText("Expected Annual Retirement Income is $"
									+ String.valueOf((int) aRI)); //output
					Graph g = new Graph(Graph.getYear(), Graph.getSavings(),
							Graph.getcA());
					panel.removeAll();
					panel.add(g, SpringLayout.SOUTH);
					validate();
					repaint();
					String income = ri.getText();
					int inc = (int)(Double.parseDouble(income));
					if(aRI>inc){
						result.setText("Congratulations!! You've planned well for retirement!");
					}
					else{
						result.setText("Your daily savings are not enough to give you your desired retirement income. You need to reduce your daily starbucks visits!");

					}


				} // end if

			} // end actionperformed

		}); // end actionlistener

		
		//CURRENT AGE TEXTFIELD
		currentage = new JTextField();
		currentage.setBounds(292, 109, 166, 28);
		add(currentage);
		currentage.setColumns(10);
		
		//CURRENT AGE ACTIONLISTENER
		currentage.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == currentage) {
					//Setting current age
					String cAge = currentage.getText();
					Data.setcA(Integer.parseInt(cAge));
					
					//Setting Inflation
					String Inf = inflation.getText();
					Data.setInf(Double.parseDouble(Inf));

					//CALCULATION
					double aRI = Data.CalcaRI(Data.getdS(), Data.geti(),
							Data.getcS(), Data.getrA(), Data.getcA(),
							Data.getInf());

					total = Data.CalcFund(Data.getdS(), Data.geti(),
							Data.getcS(), Data.getrA(), Data.getcA(),
							Data.getInf());
					
					//OUTPUT
					totalsavings.setText("Accumulated savings are $"
							+ String.valueOf((int) total));
					incomelabel
							.setText("Expected Annual Retirement Income is $"
									+ String.valueOf((int) aRI));
					
					//GRAPH
					Graph g = new Graph(Graph.getYear(), Graph.getSavings(),
							Graph.getcA());
					panel.removeAll();
					panel.add(g, SpringLayout.SOUTH);
					validate();
					repaint();
					
					String income = ri.getText();
					int inc = (int)(Double.parseDouble(income));
					if(aRI>inc){
						result.setText("Congratulations!! You've planned well for retirement!");
					}
					else{
						result.setText("Your daily savings are not enough to give you your desired retirement income. You need to reduce your daily starbucks visits!");

					}


				} // end if

			} // end actionperformed

		}); // end actionlistener

		JLabel dailysavingslabel = new JLabel("Daily savings     ($)");
		dailysavingslabel.setBounds(10, 53, 135, 16);
		add(dailysavingslabel);

		savingslabel = new JLabel("Current Savings   ($)");
		savingslabel.setBounds(10, 81, 135, 16);
		add(savingslabel);

		JLabel currentagelabel = new JLabel("Current Age  ");
		currentagelabel.setBounds(10, 115, 139, 16);
		add(currentagelabel);

		incomelabel = new JLabel(" ");
		incomelabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		incomelabel.setForeground(new Color(0, 0, 0));
		incomelabel.setBounds(482, 334, 404, 16);
		add(incomelabel);

		JLabel retireage = new JLabel("Retirement Age");
		retireage.setBounds(10, 143, 96, 16);
		add(retireage);
		panel.setBackground(new Color(238, 238, 238));
		panel.setBounds(482, 47, 380, 236);
		add(panel);

		double[] values;

		//setPreferredSize(new Dimension(716, 386));
		values = new double[Data.getrA() - Data.getcA()];
		for (int j = 0; j < Data.getrA() - Data.getcA(); j++) {
			values[j] = Data.CalcFund(Data.getdS(), Data.geti(), Data.getcS(),
					Data.getcA() + j, Data.getcA(), Data.getInf());
		}
		
		//CALCULATE BUTTON
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == btnNewButton) {
					String rAge = retirementage.getText();
					String cAge = currentage.getText();
					String DSavings = dailysavings.getText();
					String CSavings = currentsavings.getText();
					String interest = rateofreturn.getText();
					String Inf = inflation.getText();

					Data.seti(Double.parseDouble(interest));
					Data.setcS(Double.parseDouble(CSavings));
					Data.setcA(Integer.parseInt(cAge));
					Data.setrA(Integer.parseInt(rAge));
					Data.setdS(Double.parseDouble(DSavings));
					Data.setInf(Double.parseDouble(Inf));

					//CALCULATION
					double aRI = Data.CalcaRI(Data.getdS(), Data.geti(),
							Data.getcS(), Data.getrA(), Data.getcA(),
							Data.getInf());
					total = Data.CalcFund(Data.getdS(), Data.geti(),
							Data.getcS(), Data.getrA(), Data.getcA(),
							Data.getInf());
					
					//OUTPUT
					totalsavings.setText("Accumulated savings are $"
							+ String.valueOf((int) total));
					incomelabel
							.setText("Expected Annual Retirement Income is $"
									+ String.valueOf((int) aRI));
					
					//GRAPH
					Graph g = new Graph(Graph.getYear(), Graph.getSavings(),
							Graph.getcA());
					panel.removeAll();
					panel.add(g, SpringLayout.SOUTH);
					validate();
					repaint();
					String income = ri.getText();
					int inc = (int)(Double.parseDouble(income));
					if(aRI>inc){
						result.setText("Congratulations!! You've planned well for retirement!");
					}
					else{
						result.setText("Your daily savings are not enough to give you your desired retirement income. You need to reduce your daily starbucks visits!");

					}

				} // end if

			} // end actionperformed

		}); // end actionlistener

		add(btnNewButton);

		//Life expectancy label
		JLabel lifeex = new JLabel("Life Expectancy");
		lifeex.setBounds(10, 171, 135, 16);
		add(lifeex);

		//return of return label
		JLabel returnr = new JLabel("Estimated Rate of Return   (in %)");
		returnr.setBounds(10, 199, 210, 16);
		add(returnr);

		//inflation label
		inflationlabel = new JLabel("Estimated Rate of Inflation  (in %)");
		inflationlabel.setBounds(10, 227, 225, 16);
		add(inflationlabel);

		lifeexpectancy = new JTextField();
		lifeexpectancy.setBounds(292, 165, 166, 28);
		add(lifeexpectancy);
		lifeexpectancy.setColumns(10);

		//INFLATION
		inflation = new JTextField();
		inflation.setBounds(292, 221, 166, 28);
		inflation.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == inflation) {

					String CSavings = currentsavings.getText();
					String Inf = inflation.getText();
					
					Data.setInf(Double.parseDouble(Inf));
					Data.setcS(Double.parseDouble(CSavings));

					//CALCULATION
					double aRI = Data.CalcaRI(Data.getdS(), Data.geti(),
							Data.getcS(), Data.getrA(), Data.getcA(),
							Data.getInf());

					total = Data.CalcFund(Data.getdS(), Data.geti(),
							Data.getcS(), Data.getrA(), Data.getcA(),
							Data.getInf());
					
					//OUPUT
					totalsavings.setText("Accumulated savings are $"
							+ String.valueOf((int) total));
					incomelabel
							.setText("Expected Annual Retirement Income is $"
									+ String.valueOf((int) aRI));

					//GRAPH
					Graph g = new Graph(Graph.getYear(), Graph.getSavings(),
							Graph.getcA());
					panel.removeAll();
					panel.add(g, SpringLayout.SOUTH);
					validate();
					repaint();
					
					String income = ri.getText();
					int inc = (int)(Double.parseDouble(income));
					if(aRI>inc){
						result.setText("Congratulations!! You've planned well for retirement!");
					}
					else{
						result.setText("Your daily savings are not enough to give you your desired retirement income. You need to reduce your daily starbucks visits!");

					}


				} // end if

			} // end actionperformed

		}); // end actionlistener

		add(inflation);
		inflation.setColumns(10);

		//INTEREST RATE
		rateofreturn = new JTextField();
		rateofreturn.setBounds(292, 193, 166, 28);
		rateofreturn.setColumns(10);
		rateofreturn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == rateofreturn) {

					String interest = rateofreturn.getText();
					Data.seti(Double.parseDouble(interest));

					//CALCULATION
					double aRI = Data.CalcaRI(Data.getdS(), Data.geti(),
							Data.getcS(), Data.getrA(), Data.getcA(),
							Data.getInf());

					total = Data.CalcFund(Data.getdS(), Data.geti(),
							Data.getcS(), Data.getrA(), Data.getcA(),
							Data.getInf());
					
					//OUTPUT
					totalsavings.setText("Accumulated savings are $"
							+ String.valueOf((int) total));
					incomelabel
							.setText("Expected Annual Retirement Income is $"
									+ String.valueOf((int) aRI));
					
					//GRAPH
					Graph g = new Graph(Graph.getYear(), Graph.getSavings(),
							Graph.getcA());
					panel.removeAll();
					panel.add(g, SpringLayout.SOUTH);
					validate();
					repaint();
					String income = ri.getText();
					int inc = (int)(Double.parseDouble(income));
					if(aRI>inc){
						result.setText("Congratulations!! You've planned well for retirement!");
					}
					else{
						result.setText("Your daily savings are not enough to give you your desired retirement income. You need to reduce your daily starbucks visits!");

					}


				} // end if

			} // end actionperformed

		}); // end actionlistener

		add(rateofreturn);

		//CURRENT SAVINGS
		currentsavings = new JTextField();
		currentsavings.setBounds(292, 81, 166, 28);
		add(currentsavings);
		currentsavings.setColumns(10);
		currentsavings.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == currentsavings) {

					String CSavings = currentsavings.getText();
					Data.setcS(Double.parseDouble(CSavings));

					//CALCULATION
					double aRI = Data.CalcaRI(Data.getdS(), Data.geti(),
							Data.getcS(), Data.getrA(), Data.getcA(),
							Data.getInf());

					total = Data.CalcFund(Data.getdS(), Data.geti(),
							Data.getcS(), Data.getrA(), Data.getcA(),
							Data.getInf());
					
					//OUTPUT
					totalsavings.setText("Accumulated savings are $"
							+ String.valueOf((int) total));
					
					incomelabel
							.setText("Expected Annual Retirement Income is $"
									+ String.valueOf((int) aRI));

					//GRAPH
					Graph g = new Graph(Graph.getYear(), Graph.getSavings(),
							Graph.getcA());
					panel.removeAll();
					panel.add(g, SpringLayout.SOUTH);
					validate();
					repaint();
					
					String income = ri.getText();
					int inc = (int)(Double.parseDouble(income));
				
					if(aRI>inc){
						result.setText("Congratulations!! You've planned well for retirement!");
					}
					else{
						result.setText("Your daily savings are not enough to give you your desired retirement income. You need to reduce your daily starbucks visits!");

					}


				} // end if

			} // end actionperformed

		}); // end actionlistener

		totalsavings = new JLabel(" ");
		totalsavings.setForeground(new Color(0, 0, 0));
		totalsavings.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		totalsavings.setBounds(482, 306, 279, 16);
		add(totalsavings);

		JLabel header = new JLabel("Retirement Calculator");
		header.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		header.setBounds(193, 6, 218, 16);
		add(header);
		
		desiredaRI = new JLabel("Desired Annual Retirement Income ($)");
		desiredaRI.setBounds(10, 255, 247, 16);
		add(desiredaRI);
		
		ri = new JTextField();
		ri.setBounds(292, 249, 166, 28);
		add(ri);
		ri.setColumns(10);
		result.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		result.setBounds(22, 380, 700, 61);
		add(result);

	} // end constructor

	@Override
	public void actionPerformed(ActionEvent e) {

	}
} // class body

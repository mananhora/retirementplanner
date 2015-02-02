import javax.swing.JPanel;


public class Data extends JPanel {
	private static double dS;//daily savings
	private static double cS;//current savings
	private static int rA; //retirement age
	private static int cA; //current age
	private static double aRI; //annual retirement income
	private static double i ; //daily compound interest
	private static double inf ; //rate of inflation
	
	public Data(double dS, double cS, int rA, int cA, double aRI, double inf, double i){
		this.dS = dS;
		this.cS = cS;
		this.cA = cA;
		this.rA = rA;
		this.aRI = aRI;
		this.inf = inf;
		this.i = i;
	}
	
	
	//ACCESSORS AND MUTATORS
	
	//Daily Savings
	public static void setdS(double input){
		dS = input;
	}
	
	public static double getdS(){
		return dS;
	}
	
	//Rate of interest
	public static void seti(double input){
		i = input;
	}
	
	public static double geti(){
		return i;
	
	}
	
	//Inflation rate
	public static void setInf(double input) {
		 inf = input;
	}
	public static double getInf() {
		return inf;
	}
	
	//Retirement Age
	public static void setrA(int input){
		rA= input;
	}
	public static int getrA(){
		return rA;
	}
	
	//Current Age
	public static void setcA(int input){
		cA= input;
	}
	public static int getcA(){
		return cA;
	}

	//Current Savings
	public static void setcS(double input){
		cS = input;
	}
	public static double getcS(){
		return cS;
	}
	
	//Annual Retirement Income
	public static void setaRI(double input){
		aRI = input;
	}
	public static double getaRI(){
		return aRI;
	}
	
	
	
	
	//Define Methods here
	
	//Method to calculate fund at retirement given daily savings
	public static double CalcFund(double dS, double i, double cS, int rA, int cA, double inf){
		int n = (rA - cA)*365;
		double dr = (i/100)/365;
		double dinf = (inf/100)/365;
		double Amount = 0.0;
		if(inf ==0){
			Amount = (dS*(((Math.pow(1+dr, n))-1)/dr)) +  (cS*(Math.pow(1+dr, n)));

		}
		else{
			Amount = (dS*(((Math.pow(1+dr, n))-1)/dr)) +  (cS*(Math.pow(1+dr, n))) - (dS*(((Math.pow(1+dinf, n))-1)/dinf)) - (cS*(Math.pow(1+dr, n)));
		}
		return Amount;
	}
	   
	
	//Method to calculate expected annual retirement income given daily savings
	public static double CalcaRI(double dS, double i, double cS, int rA, int cA, double inf) {
		int l = 85;
		double aRI = (CalcFund(dS, i,  cS,  rA,  cA, inf)) / (l-rA);
		return aRI;
	}

	//Method to calculate required daily savings given fund at retirement
	public static double CalcdS(double i, double cS, int rA, int cA, int A){
		int n = (rA - cA)*365;
		double dS = (A - cS*(Math.pow(1+(.01*i/365), n)))*((1/365)*.01*i/(Math.pow((1+(.01*i/365)),n) - 1));
		return dS;
	}

	
}

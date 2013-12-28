import java.lang.Math;
public class Control {
    
	double[] AnsArr;
	static double Ans;
	static double Error;
    static double[] inputArr = new double[4];

    //Checking if error has been hit
    static  boolean errStatus = false;
    
    //Addition
	public static double[] Add(double[] inp) {
        double num1 = inp[0]; double err1 = inp[1]; double num2 = inp[2]; double err2 = inp[3];
		double ans = num1 + num2;
		double err = err1 + err2;
		Ans = num1 + num2;
		Error = err1 + err2;
		double[] AnsArr = {ans, err};
		return AnsArr;
	}
	//Subtraction
	public double[] Subtract(double num1, double err1, double num2, double err2) {
		double ans = num1 - num2;
		double err = err1 + err2;
		this.Ans = ans;
		this.Error = err;
		double[] AnsArr = {ans, err};
		return AnsArr;
	}
	//Multiply
	public double[] Multiply(double num1, double err1, double num2, double err2) {
		double ans = num1*num2;
		double err = ans*Math.pow(Math.pow(err1/num1, 2) + Math.pow(err2/num2, 2), 1/2);
		this.Ans = ans;
		this.Error = err;
		double[] AnsArr = {ans, err};
		return AnsArr;
	}
	//Division
	public double[] Divide(double num1, double err1, double num2, double err2) {
		double ans = num1/num2;
		double err = ans*Math.pow(Math.pow(err1/num1, 2) + Math.pow(err2/num2, 2), 1/2);
		this.Ans = ans;
		this.Error = err;
		double[] AnsArr = {ans, err};
		return AnsArr;
	}
	//Product of Powers
	public double[] ProdofPowers(double num1, double err1, double exp1, double errExp1, double num2, double err2, double exp2, double errexp2) {
		double ans = Math.pow(num1, exp1) * Math.pow(num2, exp2);
		double err = ans*Math.pow(Math.pow(exp1*err1/num1, 2) + Math.pow(exp2*err2/num2, 2), 2);
		this.Ans = ans;
		this.Error = err;
		double[] AnsArr = {ans, err};
		return AnsArr;
	}
	//Sin
	
	//Cos
		
	//Tan
	
	//Log
	
	//
}

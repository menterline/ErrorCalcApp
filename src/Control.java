
import java.lang.Math;

public class Control {
    
	double[] AnsArr;
	static double Ans;
	static double Error;
    static double[] inputArr = new double[4];
    static boolean doAdd = false;
    static boolean doMinus = false;
    static boolean doTimes = false;
    static boolean doDiv = false;
    
    //Checking if error has been hit
    static  boolean errStatus = false;
    
    //Addition
	public static double[] Add(double[] inp) {
        double num1 = inp[0]; double err1 = inp[1]; double num2 = inp[2]; double err2 = inp[3];
		double ans = num1 + num2;
		double err = err1 + err2;
    	double[] AnsArr = {ans, err};
		return AnsArr;
	}
	//Subtraction
	public static double[] Subtract(double[] inp) {
		double num1 = inp[0]; double err1 = inp[1]; double num2 = inp[2]; double err2 = inp[3];
		double ans = num1 - num2;
		double err = err1 + err2;
		double[] AnsArr = {ans, err};
		return AnsArr;
	}
	//Multiply
	public static double[] Multiply(double[] inp) {
		double num1 = inp[0]; double err1 = inp[1]; double num2 = inp[2]; double err2 = inp[3];
		double ans = num1*num2;
        double err = ans*(err1/num1 + err2/num2);
		double[] AnsArr = {ans, err};
		return AnsArr;
	}
	//Division
	public static double[] Divide(double[] inp) {
		double num1 = inp[0]; double err1 = inp[1]; double num2 = inp[2]; double err2 = inp[3];
		double ans = num1/num2;
	    double err = ans*(err1/num1+err2/num2);
        double[] AnsArr = {ans, err};
		return AnsArr;
	}
	
	//Sin
	
	//Cos
		
	//Tan
	
	//Log
	
	//
	
	//Find which operation to perform, and do it
	public static double[] doOperation(double[] inputArr) {
		double[] ans = {0,0};
		if (doAdd) {
			ans = Add(inputArr);	
		}
		if (doMinus) {
			ans = Subtract(inputArr);
		}
		if (doTimes) {
			ans= Multiply(inputArr);
		}
		if (doDiv) {
			ans = Divide(inputArr);
		}
		return ans;
	}
}

package f23_Scanner;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class t07_Read_of_double_with_point {
public static void main(String[] args) throws IOException {

	// На входе   2 0.5     Т.к. 0.5 с точкой, то Scanner не может его распознать, как Double (д.б.запятая) 
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	
	int n = sc.nextInt();
	double q = 0;
	if (sc.hasNextDouble()) {
		q = sc.nextDouble();} 
	else {
		String str1 = sc.next();
		str1 = str1.replace(',', '.');
	q = Double.valueOf(str1);
	}
	
	System.out.println("n = " + n + ",  q = " + q);  
	
		
	}
}
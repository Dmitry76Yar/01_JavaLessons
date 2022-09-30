package f23_Scanner;

import java.util.Scanner;

public class t03_Scanner_Vvod_data_one_by_one {
public static void main(String[] args) {
		 Scanner a = new Scanner(System.in);
	        double chislo = 1.0;
	        double katet1 = 0.0;
	        System.out.println("Введите katet1");
	        if (a.hasNextDouble() == true)  katet1 = a.nextDouble(); 
	        else System.out.println("Это не число");
	        
	        double katet2 = 1.0;
	        System.out.println("Введите katet2");
	        if (a.hasNextDouble() == true)  katet1 = a.nextDouble(); 
	        else System.out.println("Это не число");
	        
	        double hypot = 1.0;
	        System.out.println("Введите hypot");
	        if (a.hasNextDouble() == true)  hypot = a.nextDouble(); 
	        else System.out.println("Это не число");
	        
	        System.out.println(" Perimetr =  " + (katet1 + katet2 + hypot) );
	        System.out.println(" Plosad =  " + ((katet1*katet2)/2));
	        a.close();
	    }
	}
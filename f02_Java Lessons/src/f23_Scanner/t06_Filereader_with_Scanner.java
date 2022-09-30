package f23_Scanner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class t06_Filereader_with_Scanner {
public static void main(String[] args) {
	Scanner sc;
	try {
		sc = new  Scanner (new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
//		2 3 5 6 dd  ff 4555 kk 2.0 44
		while (sc.hasNext() == true) {
			if (sc.hasNextInt() == true) 	System.out.println("Целое число\t" + sc.nextInt());
			else sc.next();}
		}
	catch (FileNotFoundException e) { 
		e.printStackTrace(); }
	
	}
}

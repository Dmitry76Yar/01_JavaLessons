package f22_In_Out_Streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/* Программа для сравнения содержимого файлов.
Здесь сначала открываются два сравниваемых файла, а затем данные читаются из них и сравниваются по соответствующему количеству байтов.
Если на какой-то стадии операция сравнения дает отрицательный результат, это означает, что содержимое обоих файлов не одинаково. 
Если же конец обоих файлов достигается одновременно, это означает, что они содержат одинаковые данные. */

public class t09_CompareFiles {
public static void main(String[] args) {
	int a;		int d = 0;
	int b;		int e = 0;
	int c = 0;
	try (FileInputStream fr1 = new FileInputStream("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\DataIn");
		FileInputStream fr2 = new FileInputStream("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\DataIn")) {
			do {
				d = fr1.available();	System.out.print(d +"\t");
				e = fr2.available();	System.out.print(e +"\t");
					if (d!=e) {c = 1; break;}
					else {	a = fr1.read(); System.out.print((char)a +"\t");
							b = fr2.read(); System.out.print((char)b +"\t");
							if (a!= b) {c = 1; break;}	
						}
				System.out.println();}
			while ((d>0) && (e>0)); 
	}
				
	catch (FileNotFoundException e2) {
		System.out.println("Ошибка открытия файлов");
		e2.printStackTrace(); }
	catch (Exception e1) {
		e1.getStackTrace();
		System.out.println("Ошибка чтения"); }
	
	if (c == 1) System.out.println("Файлы имеют разный набора байтов");
	else if (c == 0) System.out.println("Файлы имеют одинаковый набора байтов");
	else System.out.println("ХЗ, что получилось"); 
	
	}
}

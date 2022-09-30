package f22_In_Out_Streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class t10_CompareFiles_in_com_str {
public static void main(String[] args) {
	int a;		int d = 0;
	int b;		int e = 0;
	int c = 0;
		// Проверка, что адреса файлов введены в командной строке
	if (args.length !=2) System.out.println("Вы не ввели 2 строки, означающие сравниваемые файлы");
	
/* Скомпилируем из командной строкиc: javac t10_CompareFiles_in_com_str.java 
  (Для выбора нужной директории в командной строки набираем cd C:...скопировать полный адрес до файла...  cd - change directory) 
           C:\Users\dkuli\Documents\My_works\Lessons\src\f22_In_Out_Streams> javac t10_CompareFiles_in_com_str.java
	           
  Затем нужно вернуться на уровень папки srs и вызвать имя класса с пакетом: java f22_In_Out_Streams.t10_CompareFiles_in_com_str  
  с названиями сравниваемых файлов
  C:\Users\dkuli\Documents\My_works\Lessons\src>java f22_In_Out_Streams.t10_CompareFiles_in_com_str CopyFrom.txt CopyFrom.txt */
		
	try (FileInputStream fr1 = new FileInputStream(args[0]);
		FileInputStream fr2 = new FileInputStream(args[1])) {
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

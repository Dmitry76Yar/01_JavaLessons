package f22_In_Out_Streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class t10_CompareFiles_in_com_str {
public static void main(String[] args) {
	int a;		int d = 0;
	int b;		int e = 0;
	int c = 0;
		// ��������, ��� ������ ������ ������� � ��������� ������
	if (args.length !=2) System.out.println("�� �� ����� 2 ������, ���������� ������������ �����");
	
/* ������������ �� ��������� ������c: javac t10_CompareFiles_in_com_str.java 
  (��� ������ ������ ���������� � ��������� ������ �������� cd C:...����������� ������ ����� �� �����...  cd - change directory) 
           C:\Users\dkuli\Documents\My_works\Lessons\src\f22_In_Out_Streams> javac t10_CompareFiles_in_com_str.java
	           
  ����� ����� ��������� �� ������� ����� srs � ������� ��� ������ � �������: java f22_In_Out_Streams.t10_CompareFiles_in_com_str  
  � ���������� ������������ ������
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
		System.out.println("������ �������� ������");
		e2.printStackTrace(); }
	catch (Exception e1) {
		e1.getStackTrace();
		System.out.println("������ ������"); }
	
	if (c == 1) System.out.println("����� ����� ������ ������ ������");
	else if (c == 0) System.out.println("����� ����� ���������� ������ ������");
	else System.out.println("��, ��� ����������"); 
	
	}
}

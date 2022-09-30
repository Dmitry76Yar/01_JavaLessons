package f22_In_Out_Streams.Tasks;

import java.io.*;

/* �������� ��������� ��� ����������� ��������� ������. ������������ �� ����� �������, ����� ��� ������� ���������� ��������. 
   ����������� ��� ��������� ��������� ������, �������������� �������� ������, � ����� ������������ ������ �������� ����� �����
   ������� ������ close () */

public class t02_Byte_Copy_files_with_change2 {
public static void main(String[] args) {
	String str = "aaaaa bbbb cccc dddddd eeeee fffff  ";
		// ������ ������ � ����
	BufferedOutputStream bfw = null;
	try {
		bfw = new BufferedOutputStream(new FileOutputStream ("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Example.txt")); 	
		bfw.write(str.getBytes());}
	catch (IOException e) {
		e.printStackTrace(); }
	try {bfw.close();}
	catch (IOException e) { e.printStackTrace(); }
	
		// ������ ����� � ������ ������ � ������ ����
	BufferedInputStream bis = null;
	BufferedOutputStream bfw2 = null;
	int a;
	try {
		bis = new BufferedInputStream(new FileInputStream("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Example.txt"));	
		bfw2 = new BufferedOutputStream(new FileOutputStream ("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Example2.txt")); 	
		while ((a = bis.read()) != -1)  {
			if ((char)a == ' ') bfw2.write('-');
			else bfw2.write((char)a);
		}
	}
	catch (IOException e) {
		e.printStackTrace(); }
	
	try {bfw2.close();
		 bis.close();}
	catch (IOException e) { e.printStackTrace(); }
	
	System.out.println("������ ���������");
	
	
	}
}

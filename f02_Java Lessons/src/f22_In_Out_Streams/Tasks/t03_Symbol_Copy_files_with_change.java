package f22_In_Out_Streams.Tasks;

import java.io.*;

/* �������� ��������� ��� ����������� ��������� ������. ������������ �� ����� �������, ����� ��� ������� ���������� ��������. 
   ����������� ��� ��������� ��������� ������, �������������� ���������� ������, � ����� ������������ ������ �������� ����� �����
   ������� ������ close () */

public class t03_Symbol_Copy_files_with_change {
public static void main(String[] args) {
	String str = "aaaaa bbbb cccc dddddd eeeee fffff dddd dddd ";
		// ������ ������ � ����
	BufferedWriter bfw = null;
	try {
		bfw = new BufferedWriter(new FileWriter("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Example.txt")); 	
		bfw.write(str);}
	catch (IOException e) {
		e.printStackTrace(); }
	try {bfw.close();}
	catch (IOException e) { e.printStackTrace(); }
	
		// ������ ����� � ������ ������ � ������ ����
	BufferedReader bis = null;
	BufferedWriter bfw2 = null;
	int a;
	try {
		bis = new BufferedReader(new FileReader("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Example.txt"));	
		bfw2 = new BufferedWriter(new FileWriter("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Example2.txt")); 	
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

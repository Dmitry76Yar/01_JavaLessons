package f22_In_Out_Streams;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/* FileReader � Scanner ���� ������
�� �������� � �����������, ���������, ��� FileReader � Scanner ���� ������. �� �� ��������� �� "�������" 
		������ Scanner
 - nextLine()   - ��� �����, ������� ��������� ������ (�� ENTER), � ���������� ��� ��������
 - hasNextLine() - �����, ������� ���������� boolean - true ��� false, ���������, ���� �� ��������� ������.
*/

public class t15_FileReader_with_Scanner {
public static void main(String[] args) {

		// ������������ ������ ������ � ������� FileWriter
	System.out.println("������������ ������ ������ � ������� FileWriter ��������");
	String str = "Recording \nwith FileWriter \nchar-by-char";
	try (FileWriter fwr = new FileWriter("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Copy1.txt")) {
		for (int i = 0; i<str.length(); i++) {
				fwr.write(str.charAt(i));
				System.out.print(str.charAt(i));}
	System.out.println("\n������ � ���� ���������\n"); 
}
catch (FileNotFoundException e) {System.out.println("����� �� �������");}
catch (IOException e2) { System.out.println("������ ����� - ������");} 
	
		// ������������ ������ ������ �� �����
	System.out.println("������ ������ �� ����� ��������");
	try (FileReader fr = new FileReader("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Copy1.txt");
		Scanner scan = new Scanner(fr)) {
			// � ������� �� FileWriter, FileReader �� ������������ ����:
			// ���������� �� �������, ��� ������� ����
		while (scan.hasNextLine() == true) {
				// hasNextLine() - �����, ������� ���������� boolean - true ��� false, ���������, ���� �� ��������� ������.
			System.out.println(scan.nextLine()); }
				//  nextLine()   - ��� �����, ������� ��������� ������ (�� ENTER), � ���������� ��� ��������
		System.out.println("������ �� ����� ���������");
	}
	catch (FileNotFoundException e) {
		System.out.println("����� �� �������");
		e.printStackTrace();}
	catch (IOException e1) {
		System.out.println("������ ������ ��� ������"); 
		e1.printStackTrace(); }
}
}
package f22_In_Out_Streams;
/*  ����� BufferedReader - ������� ����� ����������� ����, ��������� ������ Reader 
 	BufferedReader ������ ����� �� ������ ����� ��������, ��������� ����������� �������, ����� ���������� ����������� ���������� 
 ��������, �������� � �����. ����� ������� � ������������ ������ ���������� ������ ������.
 		������������: 
 - BufferedReader(Reader in)  - ������� �������� ����� ����� ��������, ������� ���������� ������ ������ �� ���������.
 - BufferedReader(Reader in, int sz) - ������� �������� ����� ����� ��������, ������� ���������� ��������� ������.
 		������
  - close() - ������� �����
  - mark(int readAheadLimit) -  �������� ������� � ������
  - markSupported() -  ������������ �� ������� ������
  - int read() - ��������� �����
  - int read(char[] cbuf, int off, int len) - ��������� �����
  - String readLine() - ��������� ������
  - boolean ready() - ����� �� ����� ������
  - reset()  - �������� �����
  - skip(long n) - ���������� �������
  
    ����� BufferedWriter - �������� ����� ����������� ����, ��������� ������ Writer
    FileWriter ����� ���������� ������ �� ���� � ������ ��� � ���� ����������, BufferedWriter �������� ��� ������� � �������� ������
����������.  ����� ����� ���������� ������ � ����, � ����� ������� ������ ����� �� ����.
	BufferedWriter ���������� ����� � ����� ������ ��������, ��������� ���������� �������, ����� ���������� ����������� 
������ ��������, �������� � �����. ����� ������� � ������������ ������ ���������� ������ ������.
		������������:
 - BufferedWriter(Writer out) - ������� �������� ����� ������ ��������, ������� ���������� ������ ������ �� ���������.
 - BufferedWriter(Writer out, int sz) - ������� �������� ����� ������ ��������, ������� ���������� ��������� ������.
		������: 
 - �lose()  - ������� �����
 - flush() - �������� ������ �� ������ �� Writer
 - newLine() - ������� �� ����� ������
 - write(char[] cbuf, int off, int len) - ������ � �����
 - write(int c) - ������ � �����
 - write(String s, int off, int len) - ������ � �����
  
  */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class t16_BufferedReader_BufferedWriter {
public static void main(String[] args) {
			// ���������� ������ ������ � ������� BufferedWriter
	System.out.println("���������� ������ ������ � ������� BufferedWriter ��������");
	String str = "Recording with BufferedWriter";
	try (BufferedWriter bfr = new BufferedWriter(new FileWriter("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Copy1.txt"))) {
		// ��� ������ FileWriter ��������� �������� BufferedWriter
		bfr.write(str);
		System.out.print(str);
		System.out.println("\n������ � ���� ���������\n"); 
	}
	catch (FileNotFoundException e) {System.out.println("����� �� �������");}
	catch (IOException e2) { System.out.println("������ ����� - ������");} 
		
			// ������ �� ����� � ������� BufferedReader
	System.out.println("������ �� ����� � ������� BufferedReader ��������");
	try (BufferedReader fr = new BufferedReader(new FileReader("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Copy1.txt"))) {
		// ��� ������ FileReader ��������� �������� BufferedReader, ������� ����� ����� readLine()
		int i = 0;
		while ((str  = fr.readLine())!= null) {
			System.out.print(str + i);
			i++;}
		}
	catch (FileNotFoundException e) {
		System.out.println("����� �� �������");
		e.printStackTrace();}
	catch (IOException e1) {
		System.out.println("������ ������ ��� ������"); 
		e1.printStackTrace(); }
			
	System.out.println(("\n����� �� ���������"));

	}

}

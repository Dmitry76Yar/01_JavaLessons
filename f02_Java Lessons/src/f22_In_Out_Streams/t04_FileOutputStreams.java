package f22_In_Out_Streams;
/* ��������� ����� � ����������� ����������� ������������ ������ ���������� ��� ������������������ ������, ��� ��������� �����/������
  ��������� �������� ������ � ������� ������� Fiieinputstream � FiieOutputstream. ��� �������� ������ ��� �������� ������, ��������
  ����-����, ������, �����������, ����.
 	�� ����� ����� ������ �������� ������, ������������ �� ��������. �������� �� ��, ��� ������� ����� ��������� � ��������� Unicode, 
  ��� ������ ���� ����� �������� � �������� ����������. ������� � ��� ��������� ������ ����� ������������ �������� ������.
  � ����� ������ �� ������� ��������� �������� ������������ �������������� ������ � ������� � �������.  */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class t04_FileOutputStreams {
public static void main(String[] args) {
	
	FileOutputStream fos = null;   	FileOutputStream fos1 = null;
	
	/*	����� ������� ���� ��� ������, ������� ������� ������ ���� FileOutputStream
	 	���������� 2 ������������:
	FileOutputStream(String ���_�����) throws FileNotFoundException
	FileOutputStream(String ���_�����, boolean append) throws FileNotFoundException
	� ������ ������������� �������� ����� ��������� ���������� FileNotFoundException. ���� ���� � ��������� ������ ��� ����������, �� 
� ��� �������, ����� ������������ ������ ����� ������������, ���� ���� ���������.  */
	
	try {fos = new FileOutputStream("FileOut.txt"); } // ���� FileOut.txt ��������� � ����� C:\Users\dkuli\Documents\My_works\Lessons
	catch (FileNotFoundException e) { 
		System.out.println("������ �������� �����");
		e.printStackTrace(); }
		
	/* FileOutputStream(String ���_�����, boolean append) ���������� �� FileOutputStream(String ���_�����) �������� append.
	���� append== true, �� ������������ ������ ����������� � ����� �����. � ��������� ������ ������  ������ � ����� ���������������� ������.  */
	
	try {fos1 = new FileOutputStream("FileOut1.txt", true); } 
	catch (FileNotFoundException e) { 
		System.out.println("������ �������� �����");
		e.printStackTrace(); }
	
	/* ��� ������ ������ � ���� ���������� ����� write (). �������� ������� - void write(int byteval) throws IOException 
������ ����� ���������� � ����� �������� ��������, ������������ � ������� ��������� byteva 1. �������� �� �� ��� ���� �������� 
�������� ��� int, ����������� ������ ������� 8 ��� ��� ��������. ���� � �������� ������ ��������� ������, ������������ ���������� IOException. */ 
	
	String input = "abcdefghikl";
	
	try { 
		for (int i = 0; i<input.length(); i++)  fos.write(input.charAt(i));	}		// ������ � ����
	catch (IOException e) {
		System.out.println("������ ������ � ����");
		e.printStackTrace();}
		
	 /*     �����, ���  close () ��������� � ����� finally. ������ ������ ����� �� ������������, ��� � ������ ���������� ���������� ���������
    ��-�� ������������� ����������, �� ���������� � ���������� �����-������, ���� ��� ����� ����� ����������� � ����� finally.*/
	finally {
		try {fos.close(); }
		catch (IOException e2) {
			System.out.println("������ �������� � ����");
			e2.printStackTrace();}
	}
	
	System.out.println("Main �������� �������");
	
	}
}
 
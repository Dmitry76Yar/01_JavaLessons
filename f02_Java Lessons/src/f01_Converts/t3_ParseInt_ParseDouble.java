package f01_Converts;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;


/*		 ������������� �������-�������� ��� �������������� �������� �����
 * 	� Java ����������� �����, ������� ����� �� �������� ������ � �������������� �� �� ���������� �������� �����.
 	��������, �� ���������� �������� ������ read () , ������� ����� �� �������� ������ "100" � ������������� �������������� �� � �����
�����, ��������� ��� �������� � ���������� ���� int. 
	����� ����� �������� �������������� �������������� � ������� ��� ���������� �������� ����� (��������� ��������) Java.
��������� �������� � Java ������������ ����� ������, ������� ������������� ������� ����. �������� ����� ����������, ��������� �������
���� �� �������� ���������, ��� ������������ �� ����������. ���, ������� ��� ������ �������� ������ �� ������.
	����� ����, � �������-��������� �������� ����� ���������� ������, ��������������� ��� �������������� �������� ����� � 
��������������� �������� �����������. ������ �� ��� ���������� �������� ��������, ��������������� ��������  ������.
 - Double - static double parseDouble (String str) throws NumberFormatException
 - Float - 	static float parseFloat (String str) throws NumberFormatException
 - Long - 	static long parseLong (String str) throws NumberFormatException
 - Integer - static int parse!nt (String str) throws NumberFormatException
 - Short - 	static short parseShort (String str) throws NumberFormatException
 - Byte - 	static byte parseByte(String str) throws NumberFormatException
 
 ���� �������� ������ ���������, ��������������� ���������e ��� ���� ����� ������� parseint () � parseDouble (). � ���� ���������
��������� ������� �������������� ���� �����, ��������� ������������� � ����������. 
	������� ������������ ������������ ������� ���������� ���������� ��������� �������� ��������, � ����� ��������� ������ ����� � 
����������, ��������� ����� readLine ( ) , � � ������� ������ parseint () ����������� ���������� ������ � ������������� ��������.
����� �������������� ���� �������� �������� � ����������� �� �������������� � ��� dou�e � ������� ������ parseDou�e ().	 */

public class t3_ParseInt_ParseDouble  {
public static void main(String[] args) throws IOException {
		// ������������� ��������� ������ �� ���������� � ����������
	int n = 0;
	double a = 0.0;
	BufferedReader bufstream = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("������� ����� ���� ��� ������� �������� ���������������");
	String str = bufstream.readLine();
		try {
			n = Integer.parseInt(str);}
		catch (NumberFormatException e) {
			System.out.println("� ������ ����� ���� ���������� �������");}
			
	System.out.println("�� ����� " + n);
	double Array[] = new double [n];
	System.out.println("������� �����");
		for (int i = 0; i<n; i++ ) {
			String a1;
			a1 = bufstream.readLine();
			try {
				a = Double.parseDouble(a1);
				Array[i] = a;}
			catch (NumberFormatException e) {
				System.out.println("� ������ ����� ���� ���������� �������");}
		}
	System.out.println(Arrays.toString(Array));
	double sum = 0.0;
	for (int i= 0; i<n; i++) { 	sum = sum + Array[i];	}
	System.out.println("������� �������� " + sum/n);
	
	}
}
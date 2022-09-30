package f22_In_Out_Streams;

import java.io.PrintWriter;

/* 	���������� ������
�������� ������ Java ���������� �������������� � ��������� �������������. �� �� ����, ��� �������� �����-������ ��������, ���
������ �� ������. ��� ����������� ����� ���������� � Java ���������� ������ ���������� �������.
	������ ������ � Java ��������� ���������� ���� � ����� 8-������ ������, � �� ����� ��� ������ �������� ������������ ��� ����� � ������
16-������� �������. �� ������ �� ��������� �������, ��������� � �������� ��������, �������� �������������� ������������� ��������� 
�������: FileReader � FileWriter. 
	�� ������ �� ��� ����, ��� ���������� FileReader ���������� FileInputStream, � FileWriter ���������� FileOutputStream, �������� 
�������� ������� � ���, ��� FileReader ���������� ���������� ���� ������ � ���������� ������ �������, � �� ����� ��� FileWriter 
���������� ������ ���� ������ �� �� �� �����.
			������, ������������ � ������ Reader
- abstract void close ()	- ��������� �������� �����. ���������� ������� ������ ����� ������������ ���������� IOException
- void mark (int numChars) - �������� � ������� ������� �������� ������ �����, ������� ����� ���������� ��� �� ��� ���, ���� �� ����� ��������� ���������� ������, ������������ ���������� numChars
- boolean markSupported () - ���������� �������� true, ���� ������ mark () � reset () �������������� ���������� �������
- int read()				- ���������� ������������� ������������� ���������� ������� � ���������� ������� ������. �� ���������� ����� ������ ������������ �������� -1
- int read(char buffer[])	- �������� ��������� buffer.length �������� � ������ buffer, ��������� ����������� ���������� ������� 
							  ����������� ��������. �� ���������� ����� ������ ������������ �������� -1
- abstract int read(char buffer[], int offset, int numChars) - �������� ��������� ���������� ��������, ������������ ���������� numChars,
 							� ������ buffer, ������� � �������� buffer[offset]. �� ���������� ����� ������ ������������ �������� -1
- int read (CharBuffer buffer)  - �������� ��������� �����, ������������ ���������� buffer, � ���������� ���������� ������� 
							����������� ��������. �� ���������� ����� ������ ������������ �������� -1.
- boolean ready ()			- ���������� �������� true, ���� ��������� ������ �� ��������� ������� ����� ���� �������� ��� ��������. � ��������� ������ ������������ �������� false
- void reset ()			- ���������� ������� ��������� �� ����� ������������� ����� 
- long skip(long numChars) - ���������� numChars �������� �� ������� ������, ��������� ����������� ���������� ����������� ��������
			������, ������������ � ������ Writer
- Writer append (char ch)	- ��������� ������ ch � ����� ����������� ��������� ������, ��������� ������ �� ���������� �����
- Writer append (CharSequencechars)	- ��������� ������������������ �������� ch rs � ����� ����������� ������, ��������� ������ ��
 							���������� �����. CharSequence- ��� ���������, ������������ �������� ��� �������������������� ��������, 
 							����������� � ������ "������ ������"
- Writer append (CharSequence chars, int begin, int �nd) - ��������� ������������������ �������� chars � ����� �������� ������,
							������� � �������, ������������ ���������� begin, � ���������� ��������, ������������ ���������� end.
							���������� ������ �� ���������� �����. CharSequence - ��� ���������, ������������ �������� ��� 
							�������������������� ��������, ����������� 
- abstract void close ()	- ��������� �������� �����. ���������� ������� ������ ����� ������������ ���������� IOException
- abstract void flush ()	- ��������� �������������� �������� ����������� ��������� ������ � ����� ���������� {��� ����� ������ �������� �����)
- void write (int ch)		- ���������� ���� ������ � ���������� �������� �����. �������� �������� �� ��, ��� �������� ����� ��� int,
 							  ��� ��������� �������� ����� write () � �����������, �� ������� �� � ���� char
- void write (char buffer[]) - ���������� ������ ������ �������� buffer � ���������� �������� �����
- abstract void write (char buffer(], int offset, int numChars) -  ���������� ����� ������� �������� �uffer � ���������� numChars
 							                ��������, ������� � �������� buffer[offset], � ���������� �������� �����
- void write(String str)	- ���������� ������ str � ���������� �������� �����
- void write (String str, int offset, int numChars) - ���������� ����� ������ str � ���������� numChars ��������, ������� � �������, 
													������������ ���������� offset, � ���������� ����� */ 

/* 		���������� ����� � �������������� PrintWriter
 	StringWriter - ���������� ����� ������, ��������� ������������ ������ Writer
	�������� �� �� ��� ����� ������������ ������ System.out ������ �������� ��� ������ �� �������, � ����������� ������� ����� ������
������������� ������������ ���� � ����� ������� ��� ��� �������� ����� ������� ��������.
 	� �������� ���������� ���������� �� Java ����� �� ������� ������ ������������ ����� ����� PrintWriter. ��� ��� �����������, 
 ���������� ������� �������� ����������� ���������� ��������.
	����������� PrintWriter(OutputStream outputStream, boolean flushOnNewline), ��� � �������� 
		- ������� ���������, outputStream, ������������ ���������� ������ ���� OutputStream,
		-  � ������ ��������, flushOnNewline, ���������, ������ �� ����� ��������� ������ ������������ ������ ���, ����� ���������� 
		(����� ������ ������) ����� println (). ��� true ��������� flushOnNewline ����������� ������ ����������� �������������.
		
	� ������ PrintWriter �������������� ������ print () � println () ��� ���� �����, ������� Object.
�������������, ������ print () � println () ����� ������������ ����� ��� ��, ��� � ��������� � ������� ������ System.out. 
���� �������� ��������� �� ��������� � �������� ����, �� ������ ������ PrintWriter �������� ����� toString () ��� �������.
	��� ������ ������ �� ������� ����� ����� ���� PrintWriter ������� ������� System.out � �������� ��������� ������ � ���������� 
����� ������ �� ������ ����� ������� ������ ������ println (). 
��������, ��� ���������� ��������� ������ ���� ��������� ������ ���� PrintWriter, ��������� � ��������:
	PrintWriter pw = new PrintWriter(System.out, true);
	
���� �������� ������ ���������, ��������������� ������������� ������ PrintWriter ��� ����������� ������ �� �������. */


public class t19_Symbol_PrintWriter_from_Consol {
public static void main(String[] args) {
	PrintWriter pw = new PrintWriter(System.out, true);
	int i = 10;
	double d = 123.42;
	pw.println("�cno���o�a��e ������ PrintWriter");
	pw.println(i);
	pw.println(d);
	pw.println(i +" +" + d +" " + (i+d));

	}
}

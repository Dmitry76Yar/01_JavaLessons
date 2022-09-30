package f22_In_Out_Streams;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
 													������������ ���������� offset, � ���������� �����	 */ 
/* 	����� FileReader
    �������� ������� ���������� ������� ��� ������ � ������� (��������� ����� �����������)
 	FileReader �������� ����������� ������ InputStreamReader, ������� � ���� ������� ����������� �� Reader
 Reader  ->  InputStreamReader  ->  FileReader
  		���� ����� ������������ ��������� ����� ������������ ����� ������:
 - FileReader(String fileName) - ����������� ������� ����� FileReader, �������� ��� ����� ��� ������. 
 - FileReader(File file) - ����������� ������� ����� FileReader � ������ �����, ������� ��������� ���������.
 - FileReader(FileDescriptor fd) - ����������� ������� ����� FileReader, � ������ FileDescriptor ��� ������.
 		������:
 - public int read() throws IOException - ������ ���� ������. ���������� int, ������� ������������ ����������� ������.
 - public int read(char [] c, int offset, int len) - ������ ������� � ������. ���������� ���������� ����������� ��������.
���� ��������� ���� �� ����������, ������������ ���������� FileNotFoundException. 

	����� FileWriter 
�������� �������� ���������� ������� ��� ������ � ������� (���������� ����� � ���� �����������)
FileWriter �������� ����������� ������ OutputStreamWriter, ������� � ���� ������� ����������� �� Writer
 Writer  ->  OutputStreamWriter  ->  FileWriter
		������������ ������� ������: 
 - FileWriter(String fileName) -  ����������� ������� ������ FileWriter, �������� ��� �����.
 - FileWriter(String fileName, boolean append) - ����������� ������� ������ FileWriter � ������ ����� � ���������� ��������� append.
 		���� append = true �� ������ ������������ � ����� �����, � ��������� ������ ������ �������������� ������ ������������ ������
 - FileWriter(File file) - ����������� ������� ������ FileWriter ��� ������� File.
 - FileWriter(File file, boolean append) - ����������� ������� ������ FileWriter, �������� �������� File � ���������� ��������� apend
 - FileWriter(FileDescriptor fd) - ����������� ������� ������ FileWriter, ��������� � ������ �������� ������������.
��� ������������� ������ � ������ �� ��������� ������������� ������������ ���������� IOException. 
		������ ������� FileWriter (������ ������ �������� �� ������ Writer)
 - public void write(int c) - ���������� ���� ������.
 - public void write(char [] c, int offset, int len) - ���������� ����� ������� ��������, ������� � offset, ������ len.
 - public void write(String s, int offset, int len) - �������� ����� ������, ������� �� �������� � ����� len.
 
	���� ������ �� ������ � ����� ������ ����� Copy1.txt   */

public class t14_FileReader_FileWriter {
public static void main(String[] args) {
			// ������������ ������ ������ � ������� FileWriter
	System.out.println("������������ ������ ������ � ������� FileWriter ��������");
	String str = "Recording with FileWriter char-by-char";
	try (FileWriter fwr = new FileWriter("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Copy1.txt")) {
		for (int i = 0; i<str.length(); i++) {
			fwr.write(str.charAt(i));
			System.out.print(str.charAt(i));}
		System.out.println("\n������ � ���� ���������\n"); 
	}
	catch (FileNotFoundException e) {System.out.println("����� �� �������");}
	catch (IOException e2) { System.out.println("������ ����� - ������");} 
		
		// ���������� ������ ������ � ������� FileWriter
	System.out.println("���������� ������ ������ � ������� FileWriter");
	String str1 = "Recording with \nFileWriter \string-by-string";
	try (FileWriter fwr1 = new FileWriter("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Copy1.txt")) {
		 fwr1.write(str1);
//		 System.out.print(str.charAt(i));}
		System.out.println("������ � ���� ���������\n");
	}
	catch (FileNotFoundException e) {System.out.println("����� �� �������");}
	catch (IOException e2) { System.out.println("������ ����� - ������");}
			
			// ������������ ������ ������ �� �����
	System.out.println("������������ ������ ������ �� ����� ��������");
	int a = 0;
	try (FileReader fr = new FileReader("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Copy1.txt")) {
		while ((a = fr.read()) != -1) {
			System.out.print((char)a); }
		System.out.println("\n������ �� ����� ���������");
	}
	catch (FileNotFoundException e) {
		System.out.println("����� �� �������");
		e.printStackTrace();}
	catch (IOException e1) {
		System.out.println("������ ������ ��� ������"); 
		e1.printStackTrace(); }
	}
}

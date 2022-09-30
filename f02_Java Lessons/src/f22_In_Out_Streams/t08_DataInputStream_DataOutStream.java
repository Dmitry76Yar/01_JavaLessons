package f22_In_Out_Streams;
/* � ���� ��������� ������ ������ ����� ������� ������������ � ����, � ����� �������� �� ����.
 	������ DataInputStream � DataOutputStream - ������ � �������� ����������� ����� (int, double,...)
 	��� ������ ��������� � �������, ����������� ������� - ��� �������� � ����� ������������� ��� ��������� ����� � ������� �����,
��������������� �����. ����� ������������ �� ���� ��� "���������� ������", ����� �������� ���� ����� ������� ��������.

* � �������� ������ �������� � ������������ �������� ��������, ���������� ������� � ���� ASCII. �� ����������� ������� �����
������������ ������ � ������ ����� ����� ������. ��������, ��������� ������� ����, ���������� int, dou�e ��� short. 
��� ������ � ������ ������� ����� ������ � Java ������������� ������ DatainputStream � DataOutputStream. 
	����� DataOutputStream ��������� ��������� DataOutput, � ������� ���������� ������, ����������� ���������� � ���� �������� ����� 
����������� �����. �������, ������, ����� � ����, ��� ������ ������������ �� ���������� �������� �������, � �� � ���� ������������������ 
��������. 			��� ������������� ������ �����- ������ ������ �� ��� ����� ������������ ���������� IOException.
	������ DataOutputStream, �������� ����� ����������� ��� ������ ������� ����� ������: 
- void writeBoolean (boolean va 1)  - ���������� ���������� ��������, ������������ ���������� val
- void writeByte (int val) - ���������� ������� ���� �������������� ��������, ������������� ���������� val
- void writeChar (int val) - ���������� ��������, ������������ ���������� val, ������������� ��� ��� ������
- void writeDou�le(dou�e val) - ���������� �������� ���� dou�e, ������������ ���������� val
- void writeFloat(float val) - ���������� �������� ���� float, ������������ ���������� val
- void writeint (int val) - ���������� �������� ���� int, ������������ ���������� val
- void writeLong(long val) - ���������� �������� ���� long, ������������ ���������� val
- void writeShort (int val) - ���������� ������������� ��������, ������������ ���������� val, ���������� ��� � ��� short
	����� DatainputStream ��������� ��������� Datainput, ��������������� ������ ��� ������ ���� ����������� ����� ������ Java 
��� ������������� ������ �����-������ ������ �� ��� ����� ������������ ���������� IOException.  � ������ ���� DatainputStream
������ �������� � �������� ����, � �� � ������� ��� ������ �����. 
	������ DatainputStream, �������� ����� ����������� ��� ������ ������� ����� ������:
- boolean readBoolean () - ������ �������� ���� boolean
- byte readByte () 	- ������ �������� ���� byte
- char readChar () 	- ������ �������� ���� char
- dou�e readDouble () 	- ������ �������� ���� double
- float readFloat ()	- ������ �������� ���� float
- int readint ()		- ������ �������� ���� int
- long readLong ()		- ������ �������� ���� long
- short readShort ()	- ������ �������� ���� short */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class t08_DataInputStream_DataOutStream {
public static void main(String[] args) {
		/* ����������� ������ DatainputStream-  DatainputStream(InputStream inputStream)
	��� inputStream - ��� �����, ��������� � ����������� ����������� ������ DataInputStream.
	����� ������������ ������ ������ �� �����, ������� �������� ������������ inputStream ������ ���� FileinputStream. */
		/* ����������� ������ DataOutputStream - DataOutputStream(OutputStream outputStream)
	 �������� �������� �� ��, ��� ��� ������ ��� ���������� ��������� ������ OutputStream. 	
	 ����� outputStream - �������� �����, � ������� ������������ ������. ��� ���� ����� ������������ ������ ������ � ����, �������
	 �������� ������������ � �������� ��������� outputStream ������ ���� FileOutputStream.  */
	
	int i = 10;
	double d = 1023.56;
	boolean b = true;
			
try (DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\DataIn"))) {
	System.out.println("�������� � ���� DataIn Int �������� i");
		dataOut.writeInt(i);
	System.out.println("�������� � ���� DataIn double �������� d");
		dataOut.writeDouble(d);
	System.out.println("�������� � ���� DataIn boolean �������� b");
		dataOut.writeBoolean(b);
		}
catch (FileNotFoundException e) {
	System.out.println("����� �� �������"); }
catch (IOException e) {
	System.out.println("������ ������"); }

try (DataInputStream dataIn = new DataInputStream(new FileInputStream("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\DataIn.txt"))){
	System.out.println("��������� Int ��������  " + dataIn.readInt());
	System.out.println("��������� double ��������  " + dataIn.readDouble());
	System.out.println("��������� boolean ��������  " + dataIn.readBoolean());
	}
catch (FileNotFoundException e) {
	System.out.println("����� �� �������"); }
catch (IOException e) {
	System.out.println("������ ������"); }
		
System.out.println("Main �������� �������");
	
	
	}

}



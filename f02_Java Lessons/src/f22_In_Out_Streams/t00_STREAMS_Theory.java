package f22_In_Out_Streams;

/* � Java �������� �����-������ ����������� �� ������ �������. 
����� - ��� ����������� ��������, �������������� ���������� �����-������, ������� ������ � �������� ����������. 
����� ����������� ���� ����� ��� �����, �� ������� � ����� ����������� ��������������� "�����" ������� ��� �����, ���� �� ������. 
������ read () , write () , print (), println () ��������������� � ����� ������ �����, ������ ����� ����������� � ����������
�� ����� ������� � ����������� ������������ �������� ������� �����-������, ��� ��������� �������� � ������� ������������, ��������� 
���� � �� �� ������ � ������. ��������, ������ ������ �� ������� � ������ ������� ����� ���� ������������ ��� ������ ������ � ����.

  ������ ����� � ������ ������ ������ - �������� � ���������� (������������� � Java ���� ������ �������� ������)
�������� ������, ��������, ����� ������������ ��� ������ � ������ �������� ������. ������ ����� ���� ������ ��� ������ � �������. 
���������� ������ ������������� �� ����� ����������� �������. � ��� ����������� ��������� Unicode, � ������� �� ����� ����������������������. 
����� ����, � ��������� ������� ���������� ������ ����� ���������� �� ��������� � ���������.
	� ������������ ���� ��� ������ ����������� ����� ���������������� ������������ ���������� ������. ����� ������ �������� 
������������������� �������� � ��������� �� �������������. ���� ������� ������� ����������� ��������������� ���������, �� ����� ����� �
������ �� �������������� �������� � �����, � ��������. ������ � ������� ��������� � ���������� ����������, ��� ������, ��������� � 
����������, �������������� ���������������, ������ ������������ ��������� ��������.
  ������ � ��� �� ����� ������ ������ ��� �������� �����-������ ����� �������� �����������. ���������� ������ ���� ������������ ������� � ����������� ��������,
���m��������� � ��������� ��������� ��������.
	�� �������  �������� ������� ��������� ����������� ������ 
- InputStrearn � OutputStrearn ��� �������� �������,
- Reader � Writer ��� ���������� �������.
	���������� ������ ������������� ������������� ������ � ������� java. lang. � ���� ������ ��������� ����� System. 
� ��� ���������� ���������������� ���������� in, out � err, �������������� ����������� ������ �����-������. ��� ���� ��������� 
��� public, final � static, �.�. � ��� ����� ���������� �� ����� ������ ����� ���������, �� �������� �� ���������� ������ ���� System.
	System.in � ��� ����������� ���������� �� ����� in ���� InputStream � ������ System.
	System.out � ��� ����������� ���������� �� ����� out ���� PrintStream (��������� OutputStream) � ������ System.
	���������� System.out ��������� �� ����������� �������� �����, ������� �� ��������� ������ � ��������. 
���������� System.in ��������� �� ����������� ������� �����, ������� �� ��������� ������ � �����������.
���������� System. err ��������� �� ����������� ����� ������, �������, ��� � �������� �����, ����� ������ �� ��������� � ��������. 
��� ������������� ������ �� ���� ������� ����� ���� ������������� �� ����� ������ ����������.

	������ ������� ������� Reader � inputstream ���������� ���������� ������ ����� ����:
- int read () � ���������� ���� ������ ��� ����, ������ �� �������� ������, � ���� ���� int; ���� ����� ��� ����������, ���������� -1;
- int read (chart] buf) � ��������� ������� ������������ ������ buf ��������� �� �������� ������; � ������ inputstream ������ ���� byte{] �
����������� �� �������; ����� ���������� ����������� ����� ������ �� ������ ��������� ��� -1, ���� ����� ��� ����������;
- int read (char[] buf, int offset, int len) � ��������� ����� ����������� ��� ��������� ������� buf, ������� � ������� offset, ����� 
������ �� ������ ��������� ����� len; ����� ���������� ����������� ����� ������ �� ������ ��������� ��� -1.
��� ������ ����������� IOException, ���� ��������� ������ �����/������.
- long skip (long n) "�����������" ����� � ������� ������� �� � �������� ��� ������ ������. ��� �������� ������ �� �������� �������� 
read(). ����� ���������� �������� ����� ����������� ���������, ������� ����� ���������� �� �, �������� ����� ����� �����������.
- void mark (int n) - ������� ������ ����� ��������, � ����� ��������� � ����������� �������� reset(), �� �� ����� ��� ����� � ���������. 
- boolean markSupported (). �� ��� ��������� ��������� ���� mark, ������� ����� ������������ ������� ������� ���������� � ����������� 
������ marksupported (), ������� ���������� true, ���� ����������� ������ ����������� � �������� � ��������
	������������� ����� InputStream ����� �����
- int available ()  - ���������� ���������� ������ �����, ��������� � ������ ������ ��� ������
- void close ()	- ��������� �������� �����. ���������� ������� ������ ����� ������������ ���������� IOException
- void reset () - ���������� ������� ��������� �� ����� ������������� �����

	������ �������� ������� writer � outputstream ���������� �� ��� ����� ���������� ������ ������:
- write (char[] buf) � ������� ������ � �������� �����, � ������ Outputstream ������ ����� ��� byte[];
- write (char[] buf, int offset, int len) � ������� len ��������� ������� buf, ������� � �������� � �������� offset;
- write (int elem) � ������ Writer - ������� 16, � � ������ Outputstream 8 ������� ����� ��������� elem � �������� �����, 
     � ������ writer ���� ��� ��� ������: 
- write (string s) � ������� ������ s � �������� �����;
- write (String s, int offset, int len) � ������� len �������� ������ s, ������� � ������� � ������� offset.
	  ����� � ��� ���� ������
- void close ( ) - ��������� �������� �����. ���������� ������� ������ ����� ������������ ���������� IOException
- void flush () - ��������� �������������� �������� ����������� ��������� ������ � ����� ���������� (��� ����� ������ �������� �����)
*/


public class t00_STREAMS_Theory {
public static void main(String[] args) {


	}

}
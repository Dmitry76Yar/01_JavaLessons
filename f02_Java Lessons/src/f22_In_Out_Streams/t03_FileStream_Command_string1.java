package f22_In_Out_Streams;
/* ������ ���������, � ������� ����� read () ������������ ��� ��������� ����������� ����������� ���������� �����.
  	��� ����� ����������� � ��������� ������ ��� ������� ���������. 
  	������ �����-������ �������������� � ������� ����� try/catch.
  �������� ������, ��������� � �������, ��������� � ������� ������� FilelnputStream ��� FileOutputStream. ����� ������� ����, 
���������� ������� ������ ������ �� ���� �������, ������� ������������ ��� ����� � �������� ���������. �������� �����
���������� ��� ����, ����� � ��� ����� ���� ��������� �������� �������� ������  � ������.
  FilelnputStream - ��������� ������ InputStream,  FileOutputStream  - ��������� ������ OutputStream  
*/

import java.io.*;

public class t03_FileStream_Command_string1 {
public static void main(String[] args) {
	/*args � ��� ������ ������� ����������, ������������ ��� ������� ���������. 
	args[0] - ������� ������ ����� ��� �������� �� ��������� ������,   args[1] - ������� ������ ����� 	*/ 
		
	// ������ ����� ���������� ��������� � ���, ��� ��������� ���������� ��� �����
	System.out.println("������� java f22_In_Out_Streams.t03_FileStream_Command_string1 ��� ����� � ������� Enter");
	if (args.length !=1) {
		System.out.println("�� �� ����� ��� �� ��������� ����� ��� ����� (�.�. ���� �����)");
		return;}

	// ����� ������� ���� ��� ������ ����� ������� ������ ���� FileInputStream
   FileInputStream fis = null;					// ������������� ������ �� �����
   int i = 0;
   
   try { 
	   fis = new FileInputStream(args[0]);		// ������� ����. ���� ���� �� ������, �� ����� FileNotFoundException
   do {
	   i = fis.read();
	   if(i!=-1) System.out.print((char)(i));}		// �������� -1 �������� ���������� ����� �����. ��� ���� - IOException
   while (fis.available() !=0);}
   catch (FileNotFoundException e) {
	   System.out.println("���� �� ������");}
   catch (IOException e) {
	   System.out.println("������ ����� - ������"); }

   /* �������� �������� �� ��, ��� �������� ����� ����������� ����� ������ ������. 
    �����, ���  close () ��������� � ����� finally. ������ ������ ����� �� ������������, ��� � ������ ���������� ���������� ���������
    ��-�� ������������� ����������, �� ���������� � ���������� �����-������, ���� ��� ����� ����� ����������� � ����� finally.
    	���������� fis ���������������� ��������� null. � ����� finally ���� ����������� ������ � ��� ������, ���� �������� ���������� 
    fis �� ����� null. fis �� �������� �������� null ���� � ��� ������, ���� ���� ��� ������� ������.      */ 
      finally {
   try {
	   if (fis != null) fis.close(); } 
   catch (IOException e1) {
	e1.printStackTrace(); 
	System.out.println("������ �������� �����");}
   }
      
    /* ������������ �� ��������� ������c: javac t03_FileStream_Command_string.java 
  (��� ������ ������ ���������� � ��������� ������ �������� cd C:...����������� ������ ����� �� �����...  cd - change directory) 
            C:\Users\dkuli\Documents\My_works\Lessons\src\f22_In_Out_Streams> javac t03_FileStream_Command_string1.java
           
  		����� ������� ��� ��� � �������� �����     
  (����� ��������� �� ������� ����� src � ������� ��� ������ � �������: java f22_Threads.t01_Args_in_command_string FileIn.txt 
            C:\Users\dkuli\Documents\My_works\Lessons\src>java f22_In_Out_Streams.t03_FileStream_Command_string1 FileIn.txt 	
         ���� ������ ���� �������� � ����� SRC   */
   	
	}
}

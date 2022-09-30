package f24_Threads;
/* ����� Thread	
   ����� Thread ��������� ����� Objects � ��������� ��������� Runnable
 ����� ����������� ����� ����������, �� �������� ����������� �����, ���������� ������� ������� (main). �� ���� ����������� �������� 
 ������. ������� �����, ��� �������, �������� ��������� �������, ����������� ���������� ���������.
 �������� �� ��, ��� ������� ����� �������� �������������, �� ����� ��������� ����� ������ ������ Thread. 
 ��� ����� ����� ������� ����� currentThread(), ����� ���� ����� ��������� �������.
 
 ����� � Java ����������� � ���� ���������� ������ java.lang.Thread.
 ����� ����� ��������, ��� ���������� ������ Thread � Java ���� �� ���� �� �������� ��������. ��� ���� ������ ���� API ��� 
 �������������� �������, �������� ��������� JVM � ������������ �������. ����� ��� ������ java launcher'� �� ��������� JVM, ��� �������
 ������� ����� � ������ main � ��� ��������� ��������� �������.
 */

public class t09_Args_in_command_string {
public static void main(String[] args) {
	//args � ��� ������ ������� ����������, ������������ ��� ������� ���������. 
    System.out.println("Hello, " + args[0]);
    
    /* ������������ �� ��������� ������ ��� ������ ������� javac: javac t01_Args_in_command_string.java 
  (��� ������ ������ ���������� ��� ���������� � ��������� ������ �������� cd C:...����������� ������ ����� �� �����...  cd - change directory) 
           C:\Users\dkuli\Documents\My_works\Lessons\src\f22_Threads> javac t01_Args_in_command_string.java
           
  ����� ������� ��� ��� � �����-������ ����������, ��������, Roger   - java HelloWorldApp Roger   
  (����� ��������� �� ������� ����� � ������� ��� ������ � �������: java f22_Threads.t01_Args_in_command_string Roger 
            C:\Users\dkuli\Documents\My_works\Lessons\src>java f22_Threads.t01_Args_in_command_string Roger 	   */
    
    /* � ������ ���� ������ ���� ��������� �����. ���� �� �������� ������� �������� (�.�. ��������� ������ java HelloWorldApp), �� 
   ������� ������ � ������ main: Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 0     */
    
    
    
}
}

package f22_In_Out_Streams;

public class t03_FileStream_Command_string {
public static void main(String[] args) {
	/*args � ��� ������ ������� ����������, ������������ ��� ������� ���������. 
	args[0] - ������� ������ ����� ��� �������� �� ��������� ������,   args[1] - ������� ������ ����� 	*/ 
   try { System.out.println("Hello, " + args[0]); } 
   catch (Exception e) { 
		e.printStackTrace();
		System.out.println("�� ���� �������� �� ������ ��������� (�����)");	}
   // ���� �� �������� ������� ��������, ��  ������� ������ � ������ main: Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 0     */
    
    /* ������������ �� ��������� ������c: javac t03_FileStream_Command_string.java 
  (��� ������ ������ ���������� � ��������� ������ �������� cd C:...����������� ������ ����� �� �����...  cd - change directory) 
            C:\Users\dkuli\Documents\My_works\Lessons\src\f22_In_Out_Streams> javac t03_FileStream_Command_string.java
           
  ����� ������� ��� ��� � �����-������ ����������, ��������, Roger   - java HelloWorldApp Roger   
  (����� ��������� �� ������� ����� � ������� ��� ������ � �������: java f22_Threads.t01_Args_in_command_string Roger 
            C:\Users\dkuli\Documents\My_works\Lessons\src>java f22_In_Out_Streams.t03_FileStream_Command_string Roger 	   */
        
    
}
}

package f20_Exceptions;
/* ������� ������� ��� ���� ���������� �������� ����� Throwable. �� ���� ��� ����������� ��� ������: Error � Exception.
��� ��������� ������ �������� ������������ �� ���� ���� �������. 
����� Error ��������� ���������� ������ � ����������� ����� Java. ����������� �� ����� ����������� ��� ��������� �������� ������.
	����� Exception - ���������� ��� ���� ����������, ��������� ��� ������ RuntimeException. 
	
RuntimeException �������� ������� ������� ��� ��� ���������� ������ ������������� ���������� (unchecked exceptions).
����� ���������� ������������� �� ��������� � �� ��������� ��������� �������� throws � ���������� ������. 
����� ���������� �������� ���������� ������ ������������, ��������, �������� �������������� ����� ��� ����� �� ������� �������.  */

public class t2_Unchecked_Exceptions {
	
	// ���������� ArithmeticException - ������� �� ����.  ��������� ������ RuntimeException, �� ������� �������� ��������� throws
public static int division (int a) {
	int result = 1;  result = 5/a; return result;}

	// ���������� IndexOutOfBoundsException: ������ ��� ������ �������. ��������� ������ RuntimeException, �� ������� �������� ��������� throws
public static int sumArray (int a[], int b) {
	int result = 1; result = a[b] + a[b+1]; return result;} 

	// ���������� NullPointerException: ������������� ������ ������. ��������� ������ RuntimeException, �� ������� �������� ��������� throws
public static String join (String a) {
	String result; result = a.concat("plus"); return result;}

public static void main(String[] args) {
	System.out.println("\t ���������� ArithmeticException - ������� �� ����. �� ������� throws � �����e division");
try {division(0);}
catch (ArithmeticException ex) {System.out.println("������� �� ����");}
	
	System.out.println("\t ���������� IndexOutOfBoundsException. �� ������� throws � �����e sumArray");
int Array[] = {1,2,4};
try {sumArray(Array, 2); }
catch (IndexOutOfBoundsException ex1) {System.out.println("������ ��� ������ �������");}

	System.out.println("\t ���������� NullPointerException. �� ������� throws � �����e sumArray");
String a = null; 
try {System.out.println(join(a));}
catch (NullPointerException ex) {System.out.println("������������� ������ ������");}
	
	}
}
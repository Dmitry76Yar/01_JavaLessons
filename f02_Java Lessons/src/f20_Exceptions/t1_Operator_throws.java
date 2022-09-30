package f20_Exceptions;
/* �������� throws
������ �����, � ������� ����� �������������� ����������, ��� �� ������������ ��� ����������. � ���� ������ � ���������� ������ 
������������ �������� throws, ������� ���� ���������� ��� ������ ����� ������. 
��������, � ��� ������� ����� ���������� ����������, � ��� ���� ���������� ��������, ���� � ����� ���������� ����� ������ 1
��� ��������� ���������� � ��� ��������� ������ ����������, � �� �� ������ �������������� ���������. */

public class t1_Operator_throws{
	
	/* � ������� ��������� throw �� ������� ������������� ����������. � �� �� ����� ����� ��� ��� ���������� ��
		������������ � ������� try..catch, ������� � ����������� ������ ������������ ��������� throws Exception.  */
public static int factorial (int num)  throws Exception {
		if (num<1) throw new Exception ("����� ������ �������");
		int result = 1;
		for (int i=1; i<=num; i++) result = result*i;
		return result; 	}

	/* � �������� ������������ �� ����� �� � �� ������������ �������� throws, � ���������� ���������� ����� � ������: */
public static int factorial2 (int num) {
	int result = 1;
	try {
		if (num<1) throw new Exception ("����� ������ �������");
		for (int i=1; i<=num; i++) result = result*i; }
	catch (Exception ex) {
		System.out.println(ex.getMessage()); 
		result = num;}
	return result;  }

public static void main(String[] args) {
	int result = 0;
						// ������ ��� ������ ������ factorial ��� ����������� ���� ���������� ������������� ����������
	System.out.println("��� ��������� ���������� � �����e, � ��������� ���������� ��� � �������� ���������");
	try {
		result = factorial(0);
		System.out.println(result); }
	catch(Exception ex) {
		System.out.println(ex.getMessage()); }
	
	System.out.println("\n ��� ��������� � ��������� ���������� ����� � ������");
	int result2 = 1;
	result2 = factorial2(-5);
	System.out.println(result2); 
	}
}

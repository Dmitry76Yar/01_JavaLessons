package f20_Exceptions;
/* ��������� ��� ������ ���������� ����������� �� ������ Exception, �� ��� ��� ��������� ��� ��� �������, ������� ��������� �������� ���������� � ��������� ����������. ����� ���� ������� ������� �������� ������:
	����� getMessage() ���������� ��������� �� ����������
	����� getStackTrace() ���������� ������, ���������� ����������� ����� ����������
	����� printStackTrace() ���������� ����������� ����� */

public class t4_Methods_of_Expectation {
	public static int division (int a) {
	int result = 1;  result = 5/a; return result;}

public static void main(String[] args) {
	try {division(0);}
	catch (ArithmeticException ex) {
		System.out.println("������� �� ����");
		System.out.println(ex.getMessage());	// ����� getMessage() ���������� ��������� �� ����������
		System.out.println(ex.getStackTrace());	// ����� getStackTrace() ���������� ������, ���������� ����������� ����� ����������
		ex.printStackTrace();
		System.out.println(ex.getCause());}					// ����� printStackTrace() ���������� ����������� ����� */
	}
}

package f20_Exceptions;

/* ���� ��������� � ����������� ���������� ������� Java ������ ���������� ��������� ����������� �������������� ��������, ������� 
 ����� ���������� ��� ���������� ���������, ��� ���� ������ ��������� ������� ���� ����������� ������ ���������� �� ����� �������.
 	����� ������� ���� ����� ����������, ���� ������������ ��� �� ������ Exception. ��������, � ��� ���� �����, ����������� ���������, 
 � ��� ���� ����������� ����������� ����������, ���� �����, ������������ � �����, ������ 1 */

public class t5_Own_Exceptions {

public static int factorial (int n) throws OwnException {		// �.�.���������� �������������� � main, ��  ��������� throws OwnException 
		int result = 1;
		if (n<1) throw new OwnException("������� �� ����", n);	/* ��� ��������� ���������� � ������ ���������� ���������� ������������� 
																  ���������� � ������� ��������� throw: throw new OwnException("������� �� ����", n) */ 
		for (int i=1; i<=n; i++) result = result*i;
		return result;}
	
public static void main(String[] args) {
	int result;
	try {	result = factorial(-1); 
			System.out.println(result);}
	catch (OwnException ex) {System.out.printf("���������: %s, \t �����: %d", ex.getMessage(), ex.getNumber());}
	}
}

class OwnException extends Exception {		/* ��� ����������� ������, ��������� � ����������� ����������, ��������� ����� OwnException,
											   ������� ����������� �� Exception � ������� �������� ��� ���������� � ����������.*/
	private int number;
	public int getNumber() { return number; 	} 	/* � ������������ OwnException � ����������� �������� ������ Exception ���������� 
														��������� �� ������: super(message). ����� ����, ��������� ���� ������������� ��� 
														�������� �����, ��������� �������� �����������. */
	public OwnException(String message, int number) {	
		super(message);
		this.number = number;	}
}
